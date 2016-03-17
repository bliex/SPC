package com.spc.jpa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spc.jpa.common.Session;
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
		if( user == null ){
			return false;
		}
		return true;
    }
    
    @Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	
	}

}
