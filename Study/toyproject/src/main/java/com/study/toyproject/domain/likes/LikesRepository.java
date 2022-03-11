package com.study.toyproject.domain.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {

	@Modifying
	@Query(value = "insert into likes(boardId, userId) values(:boardId, :userId)", nativeQuery = true)
	int mLikes(int boardId, int userId);

	@Modifying
	@Query(value = "delete from likes where boardId = :boardId and userId = :userId", nativeQuery = true)
	int mUnlikes(int boardId, int userId);
	
}
