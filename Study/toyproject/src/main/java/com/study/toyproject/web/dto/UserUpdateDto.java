package com.study.toyproject.web.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.study.toyproject.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
	
	@Size(min = 8, message = "비밀번호는 최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	@NotBlank(message = "비밀번호는 최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "비밀번호는 최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	private String password;
	
	@Size(min = 2, max = 6, message = "이름은 2~6자 이내로 입력해주세요.")
	@NotBlank(message = "이름은 2~6자 이내로 입력해주세요.")
	private String name;
	
	@NotBlank(message = "이메일을 입력해주세요.")
	@Email(message = "이메일 형식에 맞게 입력해주세요.")
	private String email;
	
	@NotBlank(message = "휴대폰 번호를 입력해주세요.")
	@Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "휴대폰 번호 형식에 맞게 입력해주세요.")
	private String phone;
	
	public User toEntity() {
		return User.builder()
				.password(password)
				.name(name)
				.email(email)
				.phone(phone)
				.build();
	}
}
