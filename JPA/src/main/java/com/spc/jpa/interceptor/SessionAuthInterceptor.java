package com.spc.jpa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spc.jpa.common.Session;
import com.spc.jpa.domain.board.Board;
import com.spc.jpa.domain.user.User;

@Component
public class SessionAuthInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionAuthInterceptor.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 세션에 로그인 정보가 있는지 체크
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Session.LOGIN_KEY);
		
		// 로그인이 되어있지 않다면 
		// 1. 값을 Session 에 저장하지 말고, DB로 항상 조회해서 처리한다.
		if( user == null ){
			//user 값이 없을 경우 화면에 보내주어야 할 페이지로 전환 한다.
			String url = "";
			throw new ModelAndViewDefiningException(new ModelAndView(url));
		}
		return true;
    }
    
    @Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	
	}

}
