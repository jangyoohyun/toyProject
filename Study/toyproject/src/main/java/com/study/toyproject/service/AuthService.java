package com.study.toyproject.service;

import java.util.Date;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
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

	private final JavaMailSender javaMailSender;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserRepository userRepository;

	@Transactional
	public User signUp(User user) {

		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");

		System.out.println("서비스");

		User userEntity = userRepository.save(user);

		return userEntity;

	}

	@Transactional
	public User userUpdate(int userId, User user) {

		User userUpdate = userRepository.findById(userId).orElseThrow(() -> {
			return new CustomException("회원 ID를 찾을 수 없습니다.");
		});

		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);

		userUpdate.setPassword(encPassword);
		userUpdate.setName(user.getName());
		userUpdate.setEmail(user.getEmail());

		return userUpdate;

	}

	public boolean checkUsername(String username) {

		return userRepository.existsByUsername(username);
	}
	
	public User findUsername(String email) {

		return userRepository.findByEmail(email);

	}

	@Transactional
	public User findPassword(String username, String email) throws MessagingException {

		User userEntity = userRepository.mfindByPassword(username, email);

		if (userEntity != null) {
			
			UUID uid = UUID.randomUUID();
			String password = uid.toString().substring(0, 6);
			
			userEntity.setPassword(password);
			
			MimeMessage message = javaMailSender.createMimeMessage();
			
			String mailContent = "안녕하세요.\n"
					+ "회원님께서 요청하신 임시 비밀번호는 "+password+" 입니다.\n"
					+ "임시 비밀번호는 발급 즉시 변경을 권장드립니다.\n"
					+ "감사합니다.";
			
			message.setSubject("댕구랜드 임시 비밀번호입니다.");
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEntity.getEmail()));
			message.setText(mailContent);
			message.setSentDate(new Date());
			
			javaMailSender.send(message);
			
			userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));

			return userEntity;

		} else {
			
			return null;
			
		}
		

	}

	

}
