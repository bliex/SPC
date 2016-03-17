package com.spc.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.jpa.common.Constant.Code;
import com.spc.jpa.common.Constant.Message;
import com.spc.jpa.domain.board.Board;
import com.spc.jpa.domain.board.BoardRepository;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class ApiBoardController {
	
	@Autowired
	BoardRepository boardRepository;
	
    /**
	 * 게시판 조회 (검색, 페이징)
	 */
    @ApiOperation(value = "boards", notes = "find : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/boards", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> findBoards(@ApiParam(name = "paramMap", defaultValue="{\"page\" : \"1\", \"size\":\"10\",\"searchtype\":\"TITLE/CONTENT\",\"keyword\":\"keywords..\"}", value ="paging and searching data", required = true)@RequestBody Map<String, Object> paramMap) {
    	
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
			
	    	int page = (int) paramMap.get("page");
	    	int size = (int) paramMap.get("size");
	    	String searchtype = (String) paramMap.get("searchtype");
	    	String keyword = (String) paramMap.get("keyword");
	    	
	    	Page<Board> result;
	    	if( keyword.equals( "" )){
	    			result = boardRepository.findAll(new PageRequest(page-1, size));
	    	}else{
	    		if ( searchtype.equals("TITLE") ) {
	    			result = boardRepository.findByTitleContaining(new PageRequest(page-1, size), keyword);
	    		} else {
	    			result = boardRepository.findByContentsContaining(new PageRequest(page-1, size), keyword);
	    		}
	    	}
	    	if (result != null) {
	    		resultMap.put("resultCode", Code.CODE_SUCCESS);
				resultMap.put("resultMessage", Message.MSG_SUCCESS);
	    		resultMap.put("data", result);
	    	}
    	} catch (Exception e) {
    		resultMap.put("resultCode", Code.CODE_SERVER_ERR);
			resultMap.put("resultMessage", Message.MSG_SERVER_ERR);
    		return resultMap;
		}
		return resultMap;
	}
    
    /**
	 * 게시글 등록
	 */
    @ApiOperation(value = "boards", notes = "insert : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/boards", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveBoards(@ApiParam(name = "boardVO", defaultValue="{\"boardType\" : \"NOTICE_BOARD/FREE_BOARD/ALERT_BOARD/GALLERY_BOARD\", \"title\":\"제목\",\"contents\":\"내용\",\"createdBy\":\"작성자\"}", value ="board data insert", required = true)@RequestBody Board board){
    	
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
	    	Board boardVO = new Board();
	    	boardVO.setBoardType(board.getBoardType());
	    	boardVO.setTitle(board.getTitle());
	    	boardVO.setContents(board.getContents());
	    	boardVO.setCreatedBy(board.getCreatedBy());
	    	boardVO.setModifiedBy(board.getCreatedBy());
	    	
	    	Board result = boardRepository.save(boardVO);
	    	if (result != null) {
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
     * 게시판 수정
     */
	@ApiOperation(value = "boards", notes = "update : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/boards", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> updateBoards(@ApiParam(name = "boardVO", defaultValue="{\"boardType\" : \"NOTICE_BOARD/FREE_BOARD/ALERT_BOARD/GALLERY_BOARD\", \"title\":\"제목\",\"contents\":\"내용\"}", value ="board data update", required = true)@RequestBody Board board){

    	Map<String, Object> resultMap = new HashMap<>();
    	try {
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
    			Board result = boardRepository.save(boardVO);
				boardRepository.flush();
				resultMap.put("resultCode", Code.CODE_SUCCESS);
				resultMap.put("resultMessage", Message.MSG_SUCCESS);
				resultMap.put("data", result);
    		} else {
    			resultMap.put("resultCode", Code.CODE_BOARD_NON_VALID);
    			resultMap.put("resultMessage", Message.MSG_BOARD_NON_VALID);
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", Code.CODE_SERVER_ERR);
			resultMap.put("resultMessage", Message.MSG_SERVER_ERR);
		}
    	return resultMap;
    	
	}
    
    /**
     * 게시판 삭제
     */
    @ApiOperation(value = "boards", notes = "delete : boards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success request")})
	@RequestMapping(path = "/api/boards", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> deleteBoards(@ApiParam(name = "boardId", defaultValue="{\"id\" : \"id\"}", value ="board data delete", required = true)@RequestBody Board board){

    	Map<String, Object> resultMap = new HashMap<>();
    	try {
    		Board boardVO = boardRepository.findOne(board.getId());
    		if (null != boardVO) {
	    		boardRepository.delete(board.getId());
	    		boardRepository.flush();
	    		resultMap.put("resultCode", Code.CODE_SUCCESS);
				resultMap.put("resultMessage", Message.MSG_SUCCESS);
    		} else {
    			resultMap.put("resultCode", Code.CODE_BOARD_NON_VALID);
    			resultMap.put("resultMessage", Message.MSG_BOARD_NON_VALID);
    		}
		} catch (Exception e) {
			resultMap.put("resultCode", Code.CODE_SERVER_ERR);
			resultMap.put("resultMessage", Message.MSG_SERVER_ERR);
		}
		return resultMap;
		
	}
}
