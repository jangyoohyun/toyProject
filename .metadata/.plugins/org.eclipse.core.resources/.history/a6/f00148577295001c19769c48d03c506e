package com.study.toyproject.web.dto;


import javax.validation.constraints.NotBlank;

import com.study.toyproject.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
	
	@NotBlank
	private String password;
	
	private String name;
	private String phone;
	
	public User toEntity() {
		return User.builder()
				.password(password)
				.name(name)
				.phone(phone)
				.build();
	}
}
