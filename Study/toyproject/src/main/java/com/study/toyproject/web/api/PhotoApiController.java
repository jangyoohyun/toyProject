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
import com.study.toyproject.service.PhotoService;
import com.study.toyproject.web.dto.PhotoCommentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PhotoApiController {
	
	private final PhotoService photoService;

	@DeleteMapping("/api/photo/photoDelete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		photoService.photoDelete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/api/photo/comment/{id}")
	public ResponseEntity<?> commentWrite(@Valid @RequestBody PhotoCommentDto photoCommentDto) {
		photoService.replyWrite(photoCommentDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/api/photo/{photoId}/delete/{commentId}")
	public ResponseEntity<?> commentDelete(@PathVariable int commentId) {
		
		photoService.replyDelete(commentId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/api/photo/{photoId}/update/{commentId}")
	public ResponseEntity<?> commentUpdate(@PathVariable int commentId, @Valid @RequestBody PhotoCommentDto photoCommentDto) {
		
		System.out.println(commentId);
		
		photoService.replyUpdate(commentId, photoCommentDto);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
