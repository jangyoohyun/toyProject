package com.study.toyproject.domain.photo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.toyproject.domain.comment.PhotoComment;
import com.study.toyproject.domain.user.User;

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
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	private String content;
	
	private String postImageUrl;
	
	@JsonIgnoreProperties({"photos"})
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "photo", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<PhotoComment> photoComments;
	
	@Column(columnDefinition = "integer default 0", nullable = false)
	private int view;

}
