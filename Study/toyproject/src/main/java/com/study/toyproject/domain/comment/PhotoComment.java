package com.study.toyproject.domain.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.toyproject.domain.photo.Photo;
import com.study.toyproject.domain.user.User;
import com.study.toyproject.util.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PhotoComment extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100, nullable = false)
	private String photoCommentContent;
	
	@JsonIgnoreProperties({"photos", "boards"}) // "boardComments", "photoComments", "boards"
	@JoinColumn(name = "userId")
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@JsonIgnoreProperties({"photoComments"})
	@JoinColumn(name = "photoId")
	@ManyToOne(fetch = FetchType.EAGER)
	private Photo photo;


}
