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
public class FindController {
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	//아이디찾기 폼
	@RequestMapping(value="/idSearch.do",method=RequestMethod.GET)
	public ModelAndView idForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","idSearch");
		return mav;
	}
	//비밀번호찾기 폼
	@RequestMapping(value="/pwdSearch.do",method=RequestMethod.GET)
	public ModelAndView pwdForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","pwdSearch");
		return mav;
	}
	
	//아이디 찾기,비밀번호 찾기
	@RequestMapping(value={"/idSearch.do","/pwdSearch.do"},method=RequestMethod.POST)
	public ModelAndView searchProc(@ModelAttribute("inputUser") UserVO inputUser,
												HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		if(log.isDebugEnabled()) {
			//log.debug("UserVO(inputUser)=>"+inputUser);
		}
		UserVO user=null;
		user=userDAO.findUser(inputUser);
		//log.debug("UserVO(user)=>"+user);
		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		if(requestUrl.equals("/idSearch.do")) {
			mav.addObject("CONTENT","idCompletion");
		}
		if(requestUrl.equals("/pwdSearch.do")) {
			mav.addObject("CONTENT","pwdChange");
		}
		mav.addObject("user",user);
		return mav;
	}		
	
	//비밀번호 변경
	@RequestMapping("/pwdUpdatePro.do")
	public ModelAndView pwdUpdate(@ModelAttribute("user") UserVO user) {
		
		if(log.isDebugEnabled()) {
			log.debug("비밀번호 변경 UserVO(user)=>"+user);
		}
		int check=userDAO.updatePwd(user);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","pwdCompletion");
		mav.addObject("check",check);
		
		return mav;
	}
	
}
