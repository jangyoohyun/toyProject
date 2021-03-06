package com.study.toyproject.service;

import org.springframework.stereotype.Service;

import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.likes.Likes;
import com.study.toyproject.domain.likes.LikesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LikesService {
	
	private final LikesRepository likesRepository;

	public int likes(int boardId, int userId) {
			
		return likesRepository.mLikes(boardId, userId);
		
	}

	public void unLikes(int boardId, int userId) {

		likesRepository.mUnlikes(boardId, userId);
		
	}

	public Likes likeState(int boardId, int userId) {
		
		 return likesRepository.mLikeState(boardId, userId);
		
	}

	public int likeCount(int boardId) {

		return likesRepository.mLikeCount(boardId);
	}
	
}
