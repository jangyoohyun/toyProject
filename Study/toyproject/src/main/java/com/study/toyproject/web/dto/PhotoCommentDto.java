package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoCommentDto {
	
	@NotBlank
	private int userId;
	
	@NotBlank
	private int photoId;
	
	@NotBlank
	private String photoCommentContent;

}
