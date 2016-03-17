package com.spc.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.jpa.common.Constant.Code;
import com.spc.jpa.common.Constant.Message;
import com.spc.jpa.common.Session;
import com.spc.jpa.domain.user.User;
import com.spc.jpa.domain.user.UserRepository;
import com.spc.jpa.vo.UserToken;
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
	public @ResponseBody Map<String, Object> login(HttpServletRequest request,
			HttpServletResponse response, @ApiParam(name = "userVO", defaultValue="{\"email\" : \"bliex@gmail.com\", \"password\":\"password\"}", value ="user data insert", required = true)@RequestBody User user){
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
    		User result = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    		if ( result != null ) {
    			resultMap.put("resultCode", Code.CODE_SUCCESS);
				resultMap.put("resultMessage", Message.MSG_SUCCESS);
				resultMap.put("data", result);
				// 로그인정보만 세션에 담음
				HttpSession session = request.getSession();
				session.setAttribute(Session.LOGIN_KEY, user);
				
				// 토큰정보 세션에 담음
				UserToken token = new UserToken(result);
		        session.setAttribute(Session.LOGIN_TOKEN_KEY, token);
    		} else {
    			resultMap.put("resultCode", Code.CODE_LOGIN_FAIL);
				resultMap.put("resultMessage", Message.MSG_LOGIN_FAIL);
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", Code.CODE_SERVER_ERR);
			resultMap.put("resultMessage", Message.MSG_SERVER_ERR);
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
    			resultMap.put("resultCode", Code.CODE_SUCCESS);
				resultMap.put("resultMessage", Message.MSG_SUCCESS);
    		} else {
    			resultMap.put("resultCode", Code.CODE_DUPLICATION);
				resultMap.put("resultMessage", Message.MSG_DUPLICATION);
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", Code.CODE_SERVER_ERR);
			resultMap.put("resultMessage", Message.MSG_SERVER_ERR);
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
    			resultMap.put("resultCode", Code.CODE_SUCCESS);
				resultMap.put("resultMessage", Message.MSG_SUCCESS);
				resultMap.put("data", result);
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", Code.CODE_SERVER_ERR);
			resultMap.put("resultMessage", Message.MSG_SERVER_ERR);
		}
		return resultMap;
	}
    /**
	 * 로그아웃
	 */
    @ApiOperation(value = "users", notes = "post : logout", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/logout", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> logout(HttpServletRequest request,
			HttpServletResponse response, @ApiParam(name = "userVO", defaultValue="{\"id\":\"id\",\"password\":\"password\",\"name\":\"name\"}", value ="user data insert", required = true)@RequestBody User user){
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
    		HttpSession session = request.getSession();
    		session.removeAttribute(Session.LOGIN_KEY);
    		session.removeAttribute(Session.LOGIN_TOKEN_KEY);
    		
    		resultMap.put("resultCode", Code.CODE_SUCCESS);
			resultMap.put("resultMessage", Message.MSG_SUCCESS);
		} catch (Exception e) {
			resultMap.put("resultCode", Code.CODE_SERVER_ERR);
			resultMap.put("resultMessage", Message.MSG_SERVER_ERR);
		}
    	return resultMap;
	}
    
}
