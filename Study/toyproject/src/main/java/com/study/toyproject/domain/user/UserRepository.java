package com.study.toyproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
	User findByEmail(String email);

	@Query(value = "select * from user where username = :username and email = :email", nativeQuery = true)
	User mfindByPassword(String username, String email);

}
