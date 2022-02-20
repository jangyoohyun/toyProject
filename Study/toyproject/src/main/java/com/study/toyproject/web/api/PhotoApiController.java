package com.study.toyproject.web.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.service.PhotoService;
import com.study.toyproject.web.dto.CMRespDto;
import com.study.toyproject.web.dto.PhotoDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PhotoApiController {
	
	private final PhotoService photoService;
	
	@PutMapping("/api/photo/photoUpdate/{id}")
	public CMRespDto<?> update(@PathVariable int id, @RequestBody PhotoDto photoDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
		photoService.사진수정(id, photoDto, principalDetails);
		return new CMRespDto<>(1, "사진 수정 성공", null);
	}

}