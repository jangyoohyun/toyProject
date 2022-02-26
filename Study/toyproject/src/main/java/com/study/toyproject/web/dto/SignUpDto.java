package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.study.toyproject.domain.user.User;

import lombok.Data;

@Data
public class SignUpDto {
	
	@Size(min = 6, max = 20, message = "아이디는 최소 6자, 영문자로 시작하는 영문자 또는 숫자 6~20자 이내로 입력해주세요.")
	@NotBlank(message = "아이디는 최소 6자, 영문자로 시작하는 영문자 또는 숫자 6~20자 이내로 입력해주세요.")
	@Pattern(regexp="/^[a-z]+[a-z0-9]{5,19}$/g", message = "아이디는 최소 6자, 영문자로 시작하는 영문자 또는 숫자 6~20자 이내로 입력해주세요.")
	private String username;
	
	@Size(min = 8, message = "비밀번호는 최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	@NotBlank(message = "비밀번호는 최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "비밀번호는 최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	private String password;
	
	@Size(min = 2, max = 6, message = "이름은 2~6자 이내로 입력해주세요.")
	@NotBlank(message = "이름은 2~10자 이내로 입력해주세요.")
	private String name;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.name(name)
				.build();
	}
	
}
