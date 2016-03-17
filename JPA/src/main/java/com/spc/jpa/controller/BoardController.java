package com.spc.jpa.controller;

import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/**
	 * 게시판 목록 전체 조회
	 */
    @ApiOperation(value = "boards", notes = "get : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getBoards() {
    	List<Board> result = boardRepository.findAll();
		return ResponseEntity.ok(result);
	}
    
    /**
	 * 게시판 조회(페이징)
	 */
    @ApiOperation(value = "boards", notes = "get : boards [paging]", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards/paging", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getBoardsPaging(@RequestParam(value="page", required=true, defaultValue="1") int page,
			@RequestParam(value="size", required=true, defaultValue="5") int size) {
    	Page<Board> result = (Page<Board>) boardRepository.findAll(new PageRequest(page-1, size));
		return ResponseEntity.ok(result);
	}
    
    /**
	 * 게시판 조회(정렬)
	 */
    @ApiOperation(value = "boards", notes = "get : boards [sorting]", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards/sorting", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getBoardsSorting(@RequestParam(value="order", required=true, defaultValue="ASC/DESC") String order,
			@RequestParam(value="column", required=true, defaultValue="title") String column) {
    	
    	Sort sort;
    	if ( order.toUpperCase().equals("DESC") ) {
    		sort = new Sort(Sort.Direction.DESC, column.toLowerCase());
    	} else {
    		sort = new Sort(Sort.Direction.ASC, column.toLowerCase());
    	}
    	
    	List<Board> result = boardRepository.findAll(sort);
		return ResponseEntity.ok(result);
	}
    
    /**
	 * 게시판 조회 (검색, 페이징)
	 */
    @ApiOperation(value = "boards", notes = "get : boards [searching, paging]", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards/searching", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getBoardsSearching(@RequestParam(value="page", required=true, defaultValue="1") int page,
			@RequestParam(value="size", required=true, defaultValue="5") int size,
			@RequestParam(value="searchkeyword", required=true, defaultValue="keyword") String searchkeyword) {
    	
    	Page<Board> result;
    	if( searchkeyword.equals( "" )){
    		result = boardRepository.findAll(new PageRequest(page-1, size));
    	}else{
    		result = boardRepository.findByTitleContainingOrContentsContaining(new PageRequest(page-1, size), searchkeyword, searchkeyword);
    	}
    	
		return ResponseEntity.ok(result);
	}
    
    /**
	 * 게시글 등록
	 */
    @ApiOperation(value = "boards", notes = "post : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> postBoards(@ApiParam(name = "boardVO", defaultValue="{\"boardType\" : \"NOTICE_BOARD\", \"title\":\"2\",\"content\":\"3\"}", value ="board data insert", required = true)@RequestBody Board board){

    	Board boardVO = new Board();
    	boardVO.setBoardType(board.getBoardType());
    	boardVO.setTitle(board.getTitle());
    	boardVO.setContents(board.getContents());
    	boardVO.setCreatedBy(board.getCreatedBy());
    	boardVO.setCreatedTime(board.getCreatedTime());
    	boardVO.setModifiedBy(board.getModifiedBy());
    	boardVO.setModifiedTime(board.getModifiedTime());
    	
    	Board resultUserVO = boardRepository.save(boardVO);

		return ResponseEntity.ok(resultUserVO);
	}
	
    /**
     * 게시판 수정
     */
    @ApiOperation(value = "boards", notes = "put : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?> putBoards(@ApiParam(name = "boardVO", defaultValue="{\"boardType\" : \"NOTICE_BOARD\", \"title\":\"2\",\"content\":\"3\"}", value ="board data update", required = true)@RequestBody Board board){

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
    
    /**
     * 게시판 삭제
     */
    @ApiOperation(value = "boards", notes = "DELET : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/swapi/boards", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> deleteBoards(@ApiParam(name = "boardId", defaultValue="{\"id\" : \"id\"}", value ="board data delete", required = true)@RequestBody Board board){

    	boardRepository.delete(board.getId());
    	boardRepository.flush();
    	
		return ResponseEntity.ok("SUCCESS");
	}
}
