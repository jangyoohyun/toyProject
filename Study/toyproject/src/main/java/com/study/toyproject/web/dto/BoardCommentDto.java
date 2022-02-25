package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCommentDto {
	
	@NotNull
	private int userId;
	
	@NotNull
	private int boardId;
	
	@NotBlank(message = "댓글을 입력해주세요!")
	private String commentContent;

}
