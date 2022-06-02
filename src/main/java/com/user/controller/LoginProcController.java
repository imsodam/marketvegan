package com.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.dao.UserDAO;
import com.user.domain.UserVO;

@Component
@Controller
public class LoginProcController {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	//로그인 폼으로 이동
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public ModelAndView loginForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","login");
		return mav;
	}
	
	//로그인 처리
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public ModelAndView loginProc(
			@ModelAttribute("inputUser") UserVO inputUser) {
		if(log.isDebugEnabled()) {
			//log.debug("UserVO(inputUser)=>"+inputUser);
		}
		
		UserVO user=null;
		user=userDAO.loginProc(inputUser);
		//log.debug("UserVO(user)=>"+user);
		boolean check=false;//아이디,비밀번호에 맞는 레코드 있는지
		if(user!=null) {
			check=true;
		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/loginProc");
		
		mav.addObject("user",user);
		mav.addObject("check",check);
		
		return mav;
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logout() {
		return "member/logout";
	}
	
}
