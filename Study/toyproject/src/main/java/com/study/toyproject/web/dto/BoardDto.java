package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;

import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.user.User;

import lombok.Data;

@Data
public class BoardDto {

	@NotBlank(message = "제목을 입력해주세요!")
	private String title;
	
	@NotBlank(message = "내용을 입력해주세요!")
	private String content;

	public Board toEntity(User user) {
		return Board.builder()
				.title(title)
				.content(content)
				.user(user)
				.build();
	}
	
}
