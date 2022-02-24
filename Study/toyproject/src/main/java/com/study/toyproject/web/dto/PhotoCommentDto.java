package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoCommentDto {
	
	private int userId;
	
	private int photoId;
	
	@NotBlank
	private String photoCommentContent;

}
