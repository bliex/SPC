package com.spc.jpa.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.spc.jpa.domain.AbstractHistoryEntity;
import com.spc.jpa.domain.board.Board;

/**
 * @author lKJ
 */
@Entity
@Table(name = "users")
public class User extends AbstractHistoryEntity{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "user_id")
	String id;

	@Column(name = "token_uuid")
	String tokenUuid;
	
	@Column(name = "password")
  	private String password;
  	
  	@Column(name = "name")
  	private String name;
  	
  	@Column(name = "email")
  	private String email;
  	
  	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  	private List<Board> boards = new ArrayList<Board>();
  	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
  	public String getTokenUuid() {
		return tokenUuid;
	}

	public void setTokenUuid(String tokenUuid) {
		this.tokenUuid = tokenUuid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

}
