package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCommentDto {
	
	private int userId;
	
	private int boardId;
	
	@NotBlank
	private String commentContent;

}