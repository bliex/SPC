package com.spc.jpa.service;

import java.util.List;

import com.spc.jpa.domain.user.User;


/**
 * @author lKJ
 */
public interface UserService {
	/**
	 * user 리스트 가져오기
	 * @param 
	 * @return List<String>
	 */
	List<User> getUserList();
}
