package com.study.toyproject.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Integer>{

	@Modifying
	@Query(value = "INSERT INTO boardcomment(userId, boardId, content, createDate) values(?1, ?2, ?3, now())", nativeQuery = true)
	int mSave(int userId, int boardId, String content);
	
}
