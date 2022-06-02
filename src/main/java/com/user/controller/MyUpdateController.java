package com.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.dao.UserDAO;
import com.user.domain.UserVO;

@Component
@Controller
public class MyUpdateController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/myUpdateForm.do")
	ModelAndView form(@ModelAttribute("inputUser") UserVO inputUser) {
		

	    UserVO user=null;
		user=userDAO.loginProc(inputUser);
		boolean check=false;//아이디,비밀번호에 맞는 레코드 있는지
		if(user!=null) {
			check=true;
		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","myUpdateForm");
		mav.addObject("user",user);
		mav.addObject("check",check);
		return mav;
	}
	
	@RequestMapping("/myUpdatePro.do")
	ModelAndView update(@ModelAttribute("user") UserVO user) {
		
		if(log.isDebugEnabled()) {
			//log.debug("UserVO(user)=>"+user);
		}
		
		int update=userDAO.updateUser(user);
		boolean check=false;
		if(update>0) check=true;
		
		//log.debug("회원 수정 여부 리턴값=>"+check);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/updatePro");
		mav.addObject("check",check);
		return mav;
	}
	
	@RequestMapping("/userEnd.do")
	ModelAndView end(@RequestParam(value="user_id") String user_id) {
		
		if(log.isDebugEnabled()) {
			log.debug("user_id=>"+user_id);
		}
		
		int update=userDAO.endUser(user_id);
		boolean check=false;
		if(update>0) check=true;
		
		log.debug("회원 탈퇴 여부 리턴값=>"+check);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/endUser");
		mav.addObject("check",check);
		return mav;
	}
}
