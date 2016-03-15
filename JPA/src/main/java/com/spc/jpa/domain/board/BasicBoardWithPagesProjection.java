package com.spc.jpa.domain.board;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author lKJ
 */
@Projection(name = "withPages", types = { Board.class })
public interface BasicBoardWithPagesProjection {

	String getId();
	
	String getTitle();
	  
	String getContent();
	
	String getBoardType();
  
}
