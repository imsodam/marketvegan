package com.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.dao.UserDAO;
import com.user.domain.UserVO;

@Component
@Controller
public class JoinController {
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	
	//회원가입동의로 이동
	@RequestMapping("/agree.do")
	public ModelAndView agreeForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","agree");
		return mav;
	}
	
	//회원가입폼으로 이동
	@RequestMapping(value="/join.do",method=RequestMethod.GET )
	public ModelAndView joinForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","join");
		return mav;
	}
	
	//회원가입처리
	@RequestMapping(value="/join.do",method=RequestMethod.POST)
	public ModelAndView joinProc(@ModelAttribute("user") UserVO user) {
		if(log.isDebugEnabled()) {
			log.debug("UserVO(user)=>"+user);
		}
		
		userDAO.inserUser(user);		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","joinProc");
		return mav;
	}

}
