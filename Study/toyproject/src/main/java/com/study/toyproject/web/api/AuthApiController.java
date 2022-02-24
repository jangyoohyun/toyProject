package com.study.toyproject.web.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.user.User;
import com.study.toyproject.service.AuthService;
import com.study.toyproject.web.dto.CMRespDto;
import com.study.toyproject.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthApiController {
	
	private final AuthService authService;
	
	@PutMapping("/api/auth/{userId}/update")
	public CMRespDto<?> userUpate(@PathVariable int userId, @RequestBody UserUpdateDto userUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		User userEntity = authService.userUpdate(userId, userUpdateDto.toEntity());
		principalDetails.setUser(userEntity);
		return new CMRespDto<>(1, "회원정보 수정 성공", userEntity);
	}

}
