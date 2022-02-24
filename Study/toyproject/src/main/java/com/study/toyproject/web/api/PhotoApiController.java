package com.study.toyproject.web.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.service.PhotoService;
import com.study.toyproject.web.dto.BoardCommentDto;
import com.study.toyproject.web.dto.CMRespDto;
import com.study.toyproject.web.dto.PhotoCommentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PhotoApiController {
	
	private final PhotoService photoService;

	@DeleteMapping("/api/photo/photoDelete/{id}")
	public CMRespDto<?> delete(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		photoService.photoDelete(id);
		
		return new CMRespDto<>(1, "사진 삭제 성공", null);
	}
	
	@PostMapping("/api/photo/comment/{id}")
	public CMRespDto<?> commentWrite(@RequestBody PhotoCommentDto photoCommentDto) {
		photoService.replyWrite(photoCommentDto);
		return new CMRespDto<>(1, "댓글 작성", null);
	}
	
	@DeleteMapping("/api/photo/{photoId}/delete/{commentId}")
	public CMRespDto<?> commentDelete(@PathVariable int commentId) {
		
		photoService.replyDelete(commentId);
		
		return new CMRespDto<>(1, "댓글 삭제 성공", null);
	}
	
	@PutMapping("/api/photo/{photoId}/update/{commentId}")
	public CMRespDto<?> commentUpdate(@PathVariable int commentId, @RequestBody PhotoCommentDto photoCommentDto) {
		
		photoService.replyUpdate(commentId, photoCommentDto);

		return new CMRespDto<>(1, "댓글 수정 성공", null);
	}

}
