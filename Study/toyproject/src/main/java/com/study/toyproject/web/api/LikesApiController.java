package com.study.toyproject.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.service.LikesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LikesApiController {
	
	private final LikesService likesService;
	
	@PostMapping("/api/likes/{boardId}/likes")
	public ResponseEntity<?> likes(@PathVariable int boardId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		likesService.likes(boardId, principalDetails.getUser().getId());
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
