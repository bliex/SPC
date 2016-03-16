package com.spc.jpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.jpa.domain.onetoone.Cellular;
import com.spc.jpa.domain.onetoone.OneToOneRepository;
import com.spc.jpa.domain.onetoone.Person;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class OneToOneController {
	
	@Autowired
	OneToOneRepository oneToOneRepository;

    @ApiOperation(value = "persons", notes = "get : persons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/persons", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getPersons() {

    	List<Person> result = oneToOneRepository.findAll();
		return ResponseEntity.ok(result);
		
	}
    
}
