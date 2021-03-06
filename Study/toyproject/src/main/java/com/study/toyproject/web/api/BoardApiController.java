package com.study.toyproject.web.api;



import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.service.BoardService;
import com.study.toyproject.web.dto.BoardCommentDto;
import com.study.toyproject.web.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
	
	private final BoardService boardService;
	
	@PostMapping("/api/board/write")
	public ResponseEntity<?> write(@Valid @RequestBody BoardDto boardDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		boardService.postWrite(boardDto, principalDetails);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@PutMapping("/api/board/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @Valid @RequestBody BoardDto boardDto){
		boardService.postUpdate(id, boardDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/api/board/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		boardService.postDelete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/api/board/comment/{id}")
	public ResponseEntity<?> commentWrite(@Valid @RequestBody BoardCommentDto boardCommentDto) {
		boardService.replyWrite(boardCommentDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/api/board/{boardId}/delete/{commentId}")
	public ResponseEntity<?> commentDelete(@PathVariable int commentId) {
		
		boardService.replyDelete(commentId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/api/board/{boardId}/update/{commentId}")
	public ResponseEntity<?> commentUpdate(@PathVariable int commentId, @Valid @RequestBody BoardCommentDto boardCommentDto) {
		
		boardService.replyUpdate(commentId, boardCommentDto);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
