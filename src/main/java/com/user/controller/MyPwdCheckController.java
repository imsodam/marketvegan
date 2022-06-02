package com.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.dao.UserDAO;
import com.user.domain.UserVO;
import com.util.LoginId;

@Component
@Controller
public class MyPwdCheckController {
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정,this 생략 가능

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/myPwdCheck.do")
	ModelAndView process(HttpServletRequest request) {
		
		//로그인 아이디 가져오기
	    LoginId id=new LoginId(request);
	    String user_id=id.getId();	    
	    
	    UserVO user=null;
	    user=userDAO.getUser(user_id);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","myPwdCheck");
		mav.addObject("user",user);
		
		return mav;
	}
}
