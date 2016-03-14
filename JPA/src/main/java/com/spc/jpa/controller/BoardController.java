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

import com.spc.jpa.domain.board.Board;
import com.spc.jpa.domain.board.BoardRepository;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class BoardController {
	
	@Autowired
	BoardRepository boardRepository;

    @ApiOperation(value = "boards", notes = "get : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getBoards() {

    	List<Board> result = boardRepository.findAll();
		return ResponseEntity.ok(result);
	}
    
    @ApiOperation(value = "boards", notes = "post : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> postUsers(@ApiParam(name = "boardVO", defaultValue="{\"boardType\" : \"NOTICE_BOARD\", \"title\":\"2\",\"content\":\"3\"}", value ="board data insert", required = true)@RequestBody Board board){

    	Board boardVO = new Board();
    	boardVO.setBoardType(board.getBoardType());
    	boardVO.setTitle(board.getTitle());
    	boardVO.setContents(board.getContents());
    	
    	Board resultUserVO = boardRepository.save(boardVO);

		return ResponseEntity.ok(resultUserVO);
	}
	
    @ApiOperation(value = "boards", notes = "put : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?> putUsers(@ApiParam(name = "boardVO", defaultValue="{\"boardType\" : \"NOTICE_BOARD\", \"title\":\"2\",\"content\":\"3\"}", value ="board data update", required = true)@RequestBody Board board){

    	Board boardVO = boardRepository.findOne(board.getId());
    	
    	if (null != boardVO) {
    		if (!"".equals(boardVO.getBoardType())) {
    			boardVO.setBoardType(board.getBoardType());
    		}
    		if (!"".equals(boardVO.getTitle())) {
    			boardVO.setTitle(board.getTitle());
    		}
    		if (!"".equals(boardVO.getContents())) {
    			boardVO.setContents(board.getContents());
    		}
    		Board resultUserVO = boardRepository.save(boardVO);
    		boardRepository.flush();
    		return ResponseEntity.ok(resultUserVO);
    	} 
    	else {
    		return null;
    	}

	}
    
    @ApiOperation(value = "boards", notes = "DELET : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> deleteUsers(@ApiParam(name = "boardId", defaultValue="boardId", value ="board data delete", required = true)@RequestBody String boardId){

    	boardRepository.delete(boardId);
    	boardRepository.flush();
    	
		return ResponseEntity.ok("SUCCESS");
	}	
}
