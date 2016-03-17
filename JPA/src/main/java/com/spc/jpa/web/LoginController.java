package com.spc.jpa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {


  
  private static Logger logger = LoggerFactory
			.getLogger(LoginController.class);
  /**
   * DataContent 페이지
   *
   * @param request
   * @param response
   * @return
   * @throws Exception
   */

  @RequestMapping(value = {"/app/login"}, method = {RequestMethod.GET, RequestMethod.POST})
  public ModelAndView dataSourceView(
          HttpServletRequest request,
          HttpServletResponse response) throws Exception {

    //////////////////////////////////////////////////
    //
    // ModelAndView 반환
    //
    //////////////////////////////////////////////////

    ModelAndView model = new ModelAndView();

    // JSP포워드
    model.setViewName("/login/login");

    return model;
  }

}
