package com.spc.jpa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spc.jpa.domain.user.User;
import com.spc.jpa.domain.user.UserRepository;
import com.spc.jpa.service.UserService;

/**
 * @author lKJ
 */
@Component
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserRepository userRepository;
	
	
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * user 리스트 가져오기
	 * @param 
	 * @return List<String>
	 */
    @Override
	public List<User> getUserList() {
    	return userRepository.findAll();
	}

    
}
