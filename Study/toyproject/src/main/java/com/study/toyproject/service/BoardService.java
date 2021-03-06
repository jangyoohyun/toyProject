package com.study.toyproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.board.BoardRepository;
import com.study.toyproject.domain.comment.BoardComment;
import com.study.toyproject.domain.comment.BoardCommentRepository;
import com.study.toyproject.handler.ex.CustomException;
import com.study.toyproject.web.dto.BoardCommentDto;
import com.study.toyproject.web.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	private final BoardCommentRepository boardCommentRepository;

	@Transactional
	public void postWrite(BoardDto boardDto, PrincipalDetails principalDetails) {

		Board boardEntity = boardDto.toEntity(principalDetails.getUser());
		boardRepository.save(boardEntity);

	}

	@Transactional
	public Page<Board> postList(Pageable pageable) {

		return boardRepository.findAll(pageable);
	}

	public Page<Board> searchList(String keyword, Pageable pageable) {
		return boardRepository.findByTitleContaining(keyword, pageable);
	}

	@Transactional(readOnly = true)
	public Board postDetail(int boardId) {

		boardRepository.findById(boardId).get();
		
		return boardRepository.findById(boardId).orElseThrow(() -> {
			return new CustomException("글 조회의 아이디를 찾을 수 없습니다.");
		});

	}

	@Transactional
	public void postUpdate(int id, BoardDto boardDto) {

		Board updateBoard = boardRepository.findById(id).orElseThrow(() -> {
			return new CustomException("글 수정의 아이디를 찾을 수 없습니다.");
		});
		updateBoard.setTitle(boardDto.getTitle());
		updateBoard.setContent(boardDto.getContent());

	}

	@Transactional
	public void postDelete(int id) {

		boardRepository.deleteById(id);

	}

	@Transactional
	public void replyWrite(BoardCommentDto boardCommentDto) {

		boardCommentRepository.mSave(boardCommentDto.getUserId(), boardCommentDto.getBoardId(),
				boardCommentDto.getCommentContent());

	}

	@Transactional
	public void replyDelete(int commentId) {

		boardCommentRepository.deleteById(commentId);

	}

	@Transactional
	public void replyUpdate(int commentId, BoardCommentDto boardCommentDto) {

		BoardComment commentUpdate = boardCommentRepository.findById(commentId).orElseThrow(() -> {
			return new CustomException("댓글 수정의 아이디를 찾을 수 업습니다.");
		});
		commentUpdate.setCommentContent(boardCommentDto.getCommentContent());

	}

	@Transactional
	public int updateView(int boardId) {
		return boardRepository.updateView(boardId);
	}


}
