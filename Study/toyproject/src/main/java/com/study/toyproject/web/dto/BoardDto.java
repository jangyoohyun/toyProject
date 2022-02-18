package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.user.User;

import lombok.Data;

@Data
public class BoardDto {

	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private User user;
	
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.user(user)
				.build();
	}
	
}
