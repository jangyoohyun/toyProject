package com.study.toyproject.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.study.toyproject.domain.user.User;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Integer>{

	@Modifying
	@Query(value = "INSERT INTO boardcomment(userId, boardId, commentContent, createDate) values(?1, ?2, ?3, now())", nativeQuery = true)
	int mSave(int userId, int boardId, String commentContent);
	
}
