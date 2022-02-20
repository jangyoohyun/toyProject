package com.study.toyproject.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.photo.Photo;
import com.study.toyproject.domain.photo.PhotoRepository;
import com.study.toyproject.web.dto.PhotoDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PhotoService {
	
	private final PhotoRepository photoRepository;
	
	@Value("${file.path}")
	private String uploadFolder;
	
	
	@Transactional
	public void 사진업로드(PhotoDto photoDto, PrincipalDetails principalDetails) {
	
		
		UUID uuid = UUID.randomUUID();
		String photoFileName = uuid+"_"+photoDto.getFile().getOriginalFilename();
		
		Path photoFilePath = Paths.get(uploadFolder+photoFileName);
		
		try {
			Files.write(photoFilePath, photoDto.getFile().getBytes());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Photo photo = photoDto.toEntity(photoFileName, principalDetails.getUser());
		photoRepository.save(photo);
		
	}
	
	
	@Transactional
	public Page<Photo> 포토리스트(Pageable pageable) {
		
		return photoRepository.findAll(pageable);
		
	}


	@Transactional
	public void 사진수정(int id, PhotoDto photoDto, PrincipalDetails principalDetails) {

		Photo photoUpdate = photoRepository.findById(id).orElseThrow(()->{return new IllegalArgumentException("글 수정의 아이디를 찾을 수 없습니다.");});
		
		if(photoDto.getFile() != null) {
			
			new File(uploadFolder+photoDto.getFile().getOriginalFilename()).delete();

			UUID uuid = UUID.randomUUID();
			String photoFileName = uuid+"_"+photoDto.getFile().getOriginalFilename();
			
			
			Path photoFilePath = Paths.get(uploadFolder+photoFileName);
			
			try {
				Files.write(photoFilePath, photoDto.getFile().getBytes());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			photoUpdate.setPostImageUrl(photoFileName);
			
		} else {
			photoUpdate.setPostImageUrl(photoUpdate.getPostImageUrl());
		}
		
		photoUpdate.setTitle(photoDto.getTitle());
		photoUpdate.setContent(photoDto.getContent());
		
	}

	@Transactional(readOnly = true)
	public Photo 사진읽기(int id) {
		
		photoRepository.findById(id).get();

		return photoRepository.findById(id).orElseThrow(()->{return new IllegalArgumentException("글 조회의 아이디를 찾을 수 없습니다.");});
		
	}



}