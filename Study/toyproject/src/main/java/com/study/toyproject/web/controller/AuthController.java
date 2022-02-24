package com.study.toyproject.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.toyproject.domain.user.User;
import com.study.toyproject.handler.ex.CustomValidationException;
import com.study.toyproject.service.AuthService;
import com.study.toyproject.web.dto.SignUpDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final AuthService authService;

	@GetMapping("/auth/signInForm")
	public String signInForm() {
		return "/auth/signInForm";
	}
	
	@GetMapping("/auth/signUpForm")
	public String signUpForm() {
		return "/auth/signUpForm";
	}
	
	@PostMapping("/auth/signUp")
	public String signUp(@Valid SignUpDto signUpDto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new CustomValidationException("유효성 검사 실패", errorMap);
		} else {
			User user = signUpDto.toEntity();
			User userEntity = authService.회원가입(user);
			System.out.println(userEntity);
			return "/auth/signInForm";
		}
		
		
	}
	
	@GetMapping("/auth/userUpdate")
	public String userUpdate() {
		return "/auth/userUpdate";
	}
	
}
