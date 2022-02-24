package com.study.toyproject.service;


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
import com.study.toyproject.domain.comment.PhotoComment;
import com.study.toyproject.domain.comment.PhotoCommentRepository;
import com.study.toyproject.domain.photo.Photo;
import com.study.toyproject.domain.photo.PhotoRepository;
import com.study.toyproject.handler.ex.CustomException;
import com.study.toyproject.web.dto.PhotoCommentDto;
import com.study.toyproject.web.dto.PhotoDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PhotoService {

	private final PhotoRepository photoRepository;
	private final PhotoCommentRepository photoCommentRepository;

	@Value("${file.path}")
	private String uploadFolder;

	@Transactional
	public void photoUpload(PhotoDto photoDto, PrincipalDetails principalDetails) {

		UUID uuid = UUID.randomUUID();
		String photoFileName = uuid + "_" + photoDto.getFile().getOriginalFilename();

		Path photoFilePath = Paths.get(uploadFolder + photoFileName);

		try {
			Files.write(photoFilePath, photoDto.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Photo photo = photoDto.toEntity(photoFileName, principalDetails.getUser());
		photoRepository.save(photo);

	}

	@Transactional
	public Page<Photo> photoList(Pageable pageable) {

		return photoRepository.findAll(pageable);

	}

	@Transactional
	public Photo photoUpdate(int id, PhotoDto photoDto, MultipartFile photoImageFile) {

		UUID uuid = UUID.randomUUID();
		String photoFileName = uuid + "_" + photoImageFile.getOriginalFilename();

		Path photoFilePath = Paths.get(uploadFolder + photoFileName);

		try {
			Files.write(photoFilePath, photoImageFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Photo photoUpdate = photoRepository.findById(id).orElseThrow(() -> {
			throw new CustomException("글 수정의 아이디를 찾을 수 없습니다.");
		});

		photoUpdate.setPostImageUrl(photoFileName);
		photoUpdate.setTitle(photoDto.getTitle());
		photoUpdate.setContent(photoDto.getContent());

		return photoUpdate;

	}

	@Transactional(readOnly = true)
	public Photo photoDetail(int id) {

		photoRepository.findById(id).get();

		return photoRepository.findById(id).orElseThrow(() -> {
			return new CustomException("글 조회의 아이디를 찾을 수 없습니다.");
		});

	}
	
	@Transactional
	public void photoDelete(int id) {
		photoRepository.deleteById(id);
	}
	
	
	@Transactional
	public void replyWrite(PhotoCommentDto photoCommentDto) {

		photoCommentRepository.mSave(photoCommentDto.getUserId(), photoCommentDto.getPhotoId(), photoCommentDto.getPhotoCommentContent());
		
	}

	@Transactional
	public void replyDelete(int commentId) {
		
		photoCommentRepository.deleteById(commentId); 
		
	}

	@Transactional
	public void replyUpdate(int commentId, PhotoCommentDto photoCommentDto) {
		
		PhotoComment commentUpdate = photoCommentRepository.findById(commentId).orElseThrow(() -> {return new CustomException("댓글 수정의 아이디를 찾을 수 업습니다.");});
		commentUpdate.setPhotoCommentContent(photoCommentDto.getPhotoCommentContent());
		
	}


}
