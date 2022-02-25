package com.study.toyproject.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


	@GetMapping("/auth/userUpdate")
	public String userUpdate() {
		return "/auth/userUpdate";
	}
	
	
	@GetMapping("/auth/{username}")
	public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
		return ResponseEntity.ok(authService.checkUsername(username));
	}
	
	@PostMapping("/auth/signUp")
	public String signUp(@Valid SignUpDto signUpDto, Errors errors, Model model) {

		
		if(errors.hasErrors()) {
			
			model.addAttribute("signUpDto", signUpDto);
			
			Map<String, String> validatorResult = authService.validateHandling(errors);
			
			for(String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			
			return "/auth/signUpForm";
			
		}
		
		User user = signUpDto.toEntity();
		authService.signUp(user);

		return "/auth/signInForm";

	}

}
