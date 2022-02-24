package com.study.toyproject.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.toyproject.domain.user.User;
import com.study.toyproject.domain.user.UserRepository;
import com.study.toyproject.handler.ex.CustomException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserRepository userRepository;
	
	@Transactional
	public User 회원가입(User user) {
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		
		User userEntity = userRepository.save(user);
		
		return userEntity;
		
	}

	@Transactional
	public User userUpdate(int userId, User user) {
	
		User userUpdate = userRepository.findById(userId).orElseThrow(() -> {return new CustomException("회원 ID를 찾을 수 없습니다.");});
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		
		userUpdate.setPassword(encPassword);
		userUpdate.setName(user.getName());
		userUpdate.setPhone(user.getPhone());
		
		return userUpdate;

	}

}
