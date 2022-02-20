package com.study.toyproject.web.dto;

import org.springframework.web.multipart.MultipartFile;

import com.study.toyproject.domain.photo.Photo;
import com.study.toyproject.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDto {
	
	private String title;
	
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
