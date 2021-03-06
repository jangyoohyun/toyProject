package com.study.toyproject.domain.board;

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
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.util.backoff.BackOff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.toyproject.domain.comment.BoardComment;
import com.study.toyproject.domain.likes.Likes;
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
public class Board extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@JsonIgnoreProperties({"boards", "photos"})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<BoardComment> boardComments;
	
	@JsonIgnoreProperties({"board"})
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	private List<Likes> likes;

	@Column(columnDefinition = "integer default 0", nullable = false)
	private int view;
	
	@Transient
	private int likeCount;

}
