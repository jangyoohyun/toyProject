package com.study.toyproject.web.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.service.PhotoService;
import com.study.toyproject.web.dto.CMRespDto;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PhotoApiController {
	
	private final PhotoService photoService;

	@DeleteMapping("/api/photo/photoDelete/{id}")
	public CMRespDto<?> delete(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		photoService.사진삭제(id);
		
		return new CMRespDto<>(1, "사진 삭제 성공", null);
	}

}
