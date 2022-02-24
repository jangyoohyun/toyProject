package com.study.toyproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.toyproject.domain.user.User;
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
	public String signUp(SignUpDto signUpDto) {

		User user = signUpDto.toEntity();
		authService.회원가입(user);

		return "/auth/signInForm";

	}

	@GetMapping("/auth/userUpdate")
	public String userUpdate() {
		return "/auth/userUpdate";
	}

}
