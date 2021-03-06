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
import com.study.toyproject.domain.likes.Likes;
import com.study.toyproject.service.BoardService;
import com.study.toyproject.service.LikesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {

	private final BoardService boardService;
	private final LikesService likesService;

	@GetMapping("/")
	public String index(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {

		model.addAttribute("principal", principalDetails.getUser());
		
		return "/index";
	}

	@GetMapping("/board")
	public String boardList(Model model,
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable, String keyword) {

		Page<Board> list = null;

		if (keyword == null) {
			list = boardService.postList(pageable);
		} else {
			list = boardService.searchList(keyword, pageable);
		}

		int nowPage = list.getPageable().getPageNumber() + 1;
		int startPage = Math.max(1, nowPage - 4);
		int endPage = Math.min(nowPage + 5, list.getTotalPages());

		model.addAttribute("keyword", keyword);
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

	@GetMapping("/board/{boardId}")
	public String postDetail(@PathVariable int boardId, Model model,
			@AuthenticationPrincipal PrincipalDetails principalDetails, Board board) {

		Likes likeState = likesService.likeState(boardId, principalDetails.getUser().getId());
		int likeCount = likesService.likeCount(boardId);
		
		if (likeState == null) {
			boardService.updateView(boardId);
			model.addAttribute("board", boardService.postDetail(boardId));
			model.addAttribute("likeCount", likeCount);
		} else {
			boardService.updateView(boardId);
			model.addAttribute("board", boardService.postDetail(boardId));
			model.addAttribute("likes", likeState);
			model.addAttribute("likeCount", likeCount);
		}

		return "/board/boardDetail";
	}

	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.postDetail(id));
		return "/board/updateForm";
	}

}
