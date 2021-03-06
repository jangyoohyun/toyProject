package com.study.toyproject.domain.likes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;

import com.study.toyproject.domain.board.Board;
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
@Table(
		uniqueConstraints = {
				@UniqueConstraint(
						name="likes_uk",
						columnNames = {"boardId", "userId"}
						)			
		}
)
public class Likes extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "boardId")
	@ManyToOne
	private Board board;
	
	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;
	
	@ColumnDefault("1")
	private int likeState;
	
	@Transient
	private int likeCount;
	
}
