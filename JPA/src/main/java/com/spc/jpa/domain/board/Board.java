package com.spc.jpa.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.spc.jpa.domain.AbstractHistoryEntity;

/**
 * @author lKJ
 */
@Entity
@Table(name = "boards")
public class Board extends AbstractHistoryEntity{

	public enum BoardType{
		NOTICE_BOARD,
		ALERT_BOARD,
		FREE_BOARD,
		GALLERY_BOARD
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	String id;


	@Column(name = "board_type")
	@Enumerated(EnumType.STRING)
	private BoardType boardType;

	@Column(name = "title")
	private String title;

	@Lob
	@Column(name = "contents")
	private String contents;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public BoardType getBoardType() {
		return boardType;
	}
	
	public void setBoardType(BoardType boardType) {
		this.boardType = boardType;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Override
	public String toString() {
		return "Board [id=" + id + ", boardType=" + boardType + ", title=" + title + ", contents=" + contents + "]";
	}
	
}
