package com.study.toyproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	@Query(value = "select * from user where email = :email", nativeQuery = true)
	User mfindByEmail(String email);

}
