package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.study.toyproject.domain.user.User;

import lombok.Data;

@Data
public class SignUpDto {
	
	@Size(min = 4, max = 12)
	@NotBlank(message = "아이디를 입력해주세요!")
	private String username;
	
	@Size(min = 8)
	@NotBlank(message = "비밀번호를 입력해주세요!")
	@Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어와 숫자로 포함해서 6~12자리 이내로 입력해주세요.")
	private String password;
	
	@Size(min = 2, max = 8)
	@NotBlank(message = "이름을 입력해주세요!")
	private String name;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.name(name)
				.build();
	}
	
}
