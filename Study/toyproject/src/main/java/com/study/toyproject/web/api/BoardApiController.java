package com.study.toyproject.web.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.comment.BoardComment;
import com.study.toyproject.service.BoardService;
import com.study.toyproject.web.dto.BoardCommentDto;
import com.study.toyproject.web.dto.BoardDto;
import com.study.toyproject.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
	
	private final BoardService boardService;
	
	@PostMapping("/api/board/write")
	public CMRespDto<?> write(@RequestBody BoardDto boardDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		boardService.글작성(boardDto, principalDetails);
		return new CMRespDto<>(1, "글 작성 성공", null);
		
	}

	@PutMapping("/api/board/update/{id}")
	public CMRespDto<?> update(@PathVariable int id, @RequestBody BoardDto boardDto){
		boardService.글수정(id, boardDto);
		return new CMRespDto<>(1, "글 업데이트 성공", null);
	}
	
	@DeleteMapping("/api/board/delete/{id}")
	public CMRespDto<?> delete(@PathVariable int id) {
		boardService.글삭제(id);
		return new CMRespDto<>(1, "글 삭제 성공", null);
	}
	
	@PostMapping("/api/board/comment/{id}")
	public CMRespDto<?> commentWrite(@RequestBody BoardCommentDto boardCommentDto) {
		boardService.댓글작성(boardCommentDto);
		return new CMRespDto<>(1, "댓글 작성", null);
	}
}
