package com.study.toyproject.domain.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.study.toyproject.domain.board.Board;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {

	@Transactional
	@Modifying
	@Query(value = "insert into likes(boardId, userId, createDate) values(:boardId, :userId, now())", nativeQuery = true)
	int mLikes(int boardId, int userId);

	@Transactional
	@Modifying
	@Query(value = "delete from likes where boardId = :boardId and userId = :userId", nativeQuery = true)
	int mUnlikes(int boardId, int userId);
	
	@Query(value = "select * from likes where boardId = :boardId and userId = :userId", nativeQuery = true)
	Likes mLikeState(int boardId, int userId);

	@Query(value = "select count(boardId) as likeCount from likes where boardId = :boardId", nativeQuery = true)
	int mLikeCount(int boardId);

}
