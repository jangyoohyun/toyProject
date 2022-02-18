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
import com.study.toyproject.service.BoardService;
import com.study.toyproject.web.dto.BoardDto;
import com.study.toyproject.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
	
	private final BoardService boardService;
	
	@PostMapping("/api/board/write")
	public CMRespDto<?> write(@RequestBody BoardDto boardDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Board board = boardDto.toEntity();
		boardService.글작성(board, principalDetails.getUsername());
		return new CMRespDto<>(1, "성공", null);
		
	}

	@PutMapping("/api/board/update/{id}")
	public CMRespDto<?> update(@PathVariable int id, @RequestBody BoardDto boardDto){
		Board board = boardDto.toEntity();
		boardService.글수정(id, board);
		return new CMRespDto<>(1, "업데이트 성공", null);
	}
	
	@DeleteMapping("/api/board/delete/{id}")
	public CMRespDto<?> delete(@PathVariable int id) {
		boardService.글삭제(id);
		return new CMRespDto<>(1, "삭제 성공", null);
	}
}
