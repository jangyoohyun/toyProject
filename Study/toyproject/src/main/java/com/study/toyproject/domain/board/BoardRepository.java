package com.study.toyproject.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

	Page<Board> findByTitleContaining(String keyword, Pageable pageable);
	
	@Modifying
	@Query(value = "update board set view = view + 1 where id = :id", nativeQuery = true)
	int updateView(int id);
	
}
