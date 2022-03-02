package com.study.toyproject.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.toyproject.service.AuthService;

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


	@GetMapping("/auth/userUpdate")
	public String userUpdate() {
		return "/auth/userUpdate";
	}
	
	
	@GetMapping("/auth/{username}")
	public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
		return ResponseEntity.ok(authService.checkUsername(username));
	}


}
