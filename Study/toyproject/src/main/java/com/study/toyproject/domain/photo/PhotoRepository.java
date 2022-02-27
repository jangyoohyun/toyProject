package com.study.toyproject.domain.photo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>{

	Page<Photo> findByTitleContaining(String keyword, Pageable pageable);
	
}
