package com.study.toyproject.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.user.User;
import com.study.toyproject.service.AuthService;
import com.study.toyproject.web.dto.CMRespDto;
import com.study.toyproject.web.dto.SignUpDto;
import com.study.toyproject.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthApiController {

	private final AuthService authService;

	@PutMapping("/api/auth/{userId}/update")
	public ResponseEntity<?> userUpate(@PathVariable int userId, @Valid @RequestBody UserUpdateDto userUpdateDto,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {

		User userEntity = authService.userUpdate(userId, userUpdateDto.toEntity());
		principalDetails.setUser(userEntity);
		
		return new ResponseEntity<>(new CMRespDto<>(1, "회원정보 수정 성공", userEntity), HttpStatus.OK);
	}
	
	@PostMapping("/api/auth/signUp")
	public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error:bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		
		User user = signUpDto.toEntity();
		authService.signUp(user);

		return new ResponseEntity<>(new CMRespDto<>(1, "회원가입 성공", null), HttpStatus.OK);

	}

}
