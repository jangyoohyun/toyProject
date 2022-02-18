package com.study.toyproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Transactional
	public Board 글작성(Board board, String username) {
		
		Board boardEntity = boardRepository.save(board);
		boardEntity.setWriter(username);
		
		return boardEntity;
		
	}

	@Transactional
	public Page<Board> 글리스트(Pageable pageable) {
		
		return boardRepository.findAll(pageable);
	}
	
	
	@Transactional(readOnly = true)
	public Board 글읽기(int id) {
		
		boardRepository.findById(id).get();

		return boardRepository.findById(id).orElseThrow(()->{return new IllegalArgumentException("글 조회의 아이디를 찾을 수 없습니다.");});
		
	}

	@Transactional
	public void 글수정(int id, Board board) {
		
		Board updateBoard = boardRepository.findById(id).orElseThrow(()->{return new IllegalArgumentException("글 수정의 아이디를 찾을 수 없습니다.");});
		updateBoard.setTitle(board.getTitle());
		updateBoard.setContent(board.getContent());
				
	}

	@Transactional
	public void 글삭제(int id) {
		
		boardRepository.deleteById(id);
		
	}
	
	

}
