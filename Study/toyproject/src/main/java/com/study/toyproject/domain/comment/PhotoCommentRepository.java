package com.study.toyproject.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PhotoCommentRepository extends JpaRepository<PhotoComment, Integer>{

	@Modifying
	@Query(value = "INSERT INTO photocomment(userId, photoId, photoCommentContent, createDate) values(?1, ?2, ?3, now())", nativeQuery = true)
	int mSave(int userId, int photoId, String photoCommentContent);

}
