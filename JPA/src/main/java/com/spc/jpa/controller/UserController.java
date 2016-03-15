package com.spc.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.jpa.domain.user.User;
import com.spc.jpa.domain.user.UserRepository;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

    @ApiOperation(value = "users", notes = "get : users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/users", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getUsers() {

    	List<User> result = userRepository.findAll();
		return ResponseEntity.ok(result);
	}
    
    @ApiOperation(value = "users", notes = "post : users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/users", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> postUsers(@ApiParam(name = "userVO", defaultValue="{\"name\":\"2\",\"password\":\"3\"}", value ="user data insert", required = true)@RequestBody User user){

    	User userVO = new User();
    	userVO.setName(user.getName());
    	userVO.setPassword(user.getPassword());
    	
    	User resultUserVO = userRepository.save(userVO);

		return ResponseEntity.ok(resultUserVO);
	}
	
    @ApiOperation(value = "users", notes = "put : users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/users", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?> putUsers(@ApiParam(name = "userVO", defaultValue="{\"id\":\"bliex\",\"name\":\"2\",\"password\":\"3\"}", value ="user data update", required = true)@RequestBody User user){

    	User userVO = userRepository.findOne(user.getId());
    	userVO.setName(user.getName());
    	userVO.setPassword(user.getPassword());
    	
    	User resultUserVO = userRepository.save(userVO);
    	userRepository.flush();

		return ResponseEntity.ok(resultUserVO);
	}
    
    @ApiOperation(value = "users", notes = "DELET : users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/users", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> deleteUsers(@ApiParam(name = "userId", defaultValue="\"bliex\"", value ="user data delete", required = true)@RequestBody String userId){

    	userRepository.delete(userId);
    	userRepository.flush();
    	
		return ResponseEntity.ok("SUCCESS");
	}	
}
