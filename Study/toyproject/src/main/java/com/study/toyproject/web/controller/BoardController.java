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

import com.study.toyproject.config.auth.PrincipalDetails;
import com.study.toyproject.domain.board.Board;
import com.study.toyproject.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/")
	public String index(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
		
		model.addAttribute("principal", principalDetails.getUsername());
				
		return "/index";
	}
	
	@GetMapping("/board")
	public String boardList(Model model, @PageableDefault(sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<Board> list = boardService.글리스트(pageable);
		
		int nowPage = list.getPageable().getPageNumber();
		int startPage = Math.max(1, nowPage - 4);
		int endPage = Math.min(nowPage + 5, list.getTotalPages());
		
		model.addAttribute("board", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		
		return "/board/boardList";
	}
	
	@GetMapping("/board/writeForm")
	public String writeForm() {
		return "/board/writeForm";
	}
	

	@GetMapping("/board/{id}")
	public String Detail(@PathVariable int id, Model model) {
		
		model.addAttribute("board", boardService.글읽기(id));
		
		return "/board/boardDetail";
	}
	
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글읽기(id));
		return "/board/updateForm";
	}

}
