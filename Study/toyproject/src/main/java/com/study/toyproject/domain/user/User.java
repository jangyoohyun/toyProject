package com.study.toyproject.domain.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.toyproject.domain.board.Board;
import com.study.toyproject.domain.comment.BoardComment;
import com.study.toyproject.domain.comment.PhotoComment;
import com.study.toyproject.domain.likes.Likes;
import com.study.toyproject.domain.photo.Photo;
import com.study.toyproject.util.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class User extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"user"})
	private List<Board> boards;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"user"})
	private List<Photo> photos;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties({"user", "board"})
	private  List<BoardComment> boardComments;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties({"user", "photo"})
	private List<PhotoComment> photoComments;

}
