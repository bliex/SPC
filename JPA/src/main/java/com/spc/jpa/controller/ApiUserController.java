package com.spc.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.jpa.domain.user.User;
import com.spc.jpa.domain.user.UserRepository;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class ApiUserController {
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * 로그인
	 */
    @ApiOperation(value = "users", notes = "post : login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(@ApiParam(name = "userVO", defaultValue="{\"email\" : \"bliex@gmail.com\", \"password\":\"password\"}", value ="user data insert", required = true)@RequestBody User user){
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
    		User result = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    		if ( result != null ) {
    			resultMap.put("resultCode", "000");
				resultMap.put("resultMessage", "success");
				resultMap.put("data", result);
    		} else {
    			resultMap.put("resultCode", "101");
				resultMap.put("resultMessage", "아이디 혹은 비밀번호를 확인해 주세요.");
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", "900");
			resultMap.put("resultMessage", "fail");
		}
    	return resultMap;
	}
    
    /**
	 * 중복 아이디 체크
	 */
    @ApiOperation(value = "users", notes = "get : countById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/count", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> countById(@ApiParam(name = "userVO", defaultValue="{\"email\" : \"email\"}", value ="ID validation check", required = true)@RequestParam String email){
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
    		long result = userRepository.countByEmail(email);
    		if ( result == 0 ) {
    			resultMap.put("resultCode", "000");
				resultMap.put("resultMessage", "success");
    		} else {
    			resultMap.put("resultCode", "102");
				resultMap.put("resultMessage", "이미 사용중인 아이디 입니다.");
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", "900");
			resultMap.put("resultMessage", "fail");
		}
    	return resultMap;
	}
    
    /**
     * 회원가입
     */
    @ApiOperation(value = "users", notes = "post : register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/register", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> registerUser(@ApiParam(name = "userVO", defaultValue="{\"id\":\"id\",\"password\":\"password\",\"name\":\"name\"}", value ="user data insert", required = true)@RequestBody User user){
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
    		User userVO = new User();
    		userVO.setName(user.getName());
    		userVO.setPassword(user.getPassword());
    		userVO.setEmail(user.getEmail());
    		User result = userRepository.save(userVO);
    		
    		if ( result != null ){
    			resultMap.put("resultCode", "000");
				resultMap.put("resultMessage", "success");
				resultMap.put("data", result);
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", "900");
			resultMap.put("resultMessage", "fail");
		}
		return resultMap;
	}
    
}
