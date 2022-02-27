package com.study.toyproject.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.photo.Photo;
import com.study.toyproject.service.PhotoService;
import com.study.toyproject.web.dto.PhotoDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PhotoController {
	
	private final PhotoService photoService;
	
	@GetMapping("/photo")
	public String photoList(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Photo> photo = null; 
				
		if(keyword == null) {
			photo = photoService.photoList(pageable);
		} else {
			photo = photoService.photoSearch(keyword, pageable);
		}
				
		
		int nowPage = photo.getPageable().getPageNumber() + 1;
		int startPage = Math.max(1, nowPage - 4);
		int endpage = Math.min(nowPage + 5, photo.getTotalPages());
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("photo", photo);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endpage);
		
		return "/photo/photoList";
	}
	
	@GetMapping("/photo/photoForm")
	public String photoWrite() {
		
		return "/photo/photoWrite";
	}
	
	@GetMapping("/photo/{id}")
	public String photoDetail(@PathVariable int id, Model model) {
		
		model.addAttribute("photo", photoService.photoDetail(id));
		
		return "/photo/photoDetail";
	}
	
	@GetMapping("/photo/{id}/photoUpdateForm")
	public String photoUpdateForm(@PathVariable int id, Model model) {
		
		model.addAttribute("photo", photoService.photoDetail(id));
		
		return "/photo/photoUpdateForm";
	}
	
	@PostMapping("/photo/photoWrite")
	public String PhotoUpload(PhotoDto photoDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		photoService.photoUpload(photoDto, principalDetails);
		
		return "redirect:/photo";
	}
	
	@PostMapping("/photo/photoUpdate/{id}")
	public String update(@PathVariable int id, MultipartFile photoImageUrl, PhotoDto photoDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
		photoService.photoUpdate(id, photoDto, photoImageUrl);
		return "redirect:/photo";
	}
	

}
