package com.study.toyproject.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.toyproject.domain.user.User;
import com.study.toyproject.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {

	private final AuthService authService;

	@GetMapping("/auth/signInForm")
	public String signInForm(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception, Model model) {

		model.addAttribute("error", error);
		model.addAttribute("exception", exception);

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
	
	@GetMapping("/auth/findUsernameForm")
	public String findUsernameForm() {
		return "/auth/findUsernameForm";
	}

	
	@GetMapping("/auth/findUsername/{username}")
	public String findUser(@PathVariable String username, Model model) {
		
		model.addAttribute("username", username);
		
		return "/auth/findUsername";
	}

	@GetMapping("/auth/findPasswordForm")
	public String findPassword() {
		return "/auth/findPasswordForm";
	}
	

}
