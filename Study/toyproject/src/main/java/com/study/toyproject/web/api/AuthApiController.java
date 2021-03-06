package com.study.toyproject.web.api;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.user.User;
import com.study.toyproject.service.AuthService;
import com.study.toyproject.web.dto.UserDto;
import com.study.toyproject.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthApiController {

	private final AuthService authService;

	@PutMapping("/api/auth/{userId}/update")
	public ResponseEntity<?> userUpate(@PathVariable int userId, @Valid @RequestBody UserUpdateDto userUpdateDto,
			BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails) {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User userEntity = authService.userUpdate(userId, userUpdateDto.updateEntity());
		principalDetails.setUser(userEntity);

		return new ResponseEntity<>(userEntity, HttpStatus.OK);
	}

	@PostMapping("/api/auth/signUp")
	public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			User user = userDto.toEntity();
			authService.signUp(user);

			return new ResponseEntity<>(HttpStatus.CREATED);
		}

	}

	@PostMapping("/api/auth/{email}")
	public ResponseEntity<?> findUsername(@PathVariable String email, User user) {

		if (authService.findUsername(email) == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			User userEntity = authService.findUsername(email);
			return new ResponseEntity<>(userEntity.getUsername(), HttpStatus.OK);
		}

	}

	@PostMapping("/api/auth/findPassword")
	public ResponseEntity<?> findPassword(@RequestBody UserDto userDto) throws MessagingException {

		if (authService.findPassword(userDto.getUsername(), userDto.getEmail()) != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			authService.findPassword(userDto.getUsername(), userDto.getEmail());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/api/auth/changPassword")
	public ResponseEntity<?> changePassword() {

		return null;
	}

}
