package com.study.toyproject.web.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.study.toyproject.domain.photo.Photo;
import com.study.toyproject.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDto {
	
	@NotBlank(message = "제목을 입력해주세요!")
	private String title;
	
	@NotBlank(message = "내용을 입력해주세요!")
	private String content;
	
	private MultipartFile file;
	
	public Photo toEntity(String postImageUrl, User user) {
		return Photo.builder()
				.title(title)
				.content(content)
				.postImageUrl(postImageUrl)
				.user(user)
				.build();
	}

}
