package com.study.toyproject.web.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.study.toyproject.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
	
	@Size(min = 4, max = 15)
	@NotBlank(message = "비밀번호를 입력해주세요!")
	private String password;
	
	@NotBlank(message = "이름을 입력해주세요!")
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
