package com.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.dao.UserDAO;

@Component
@Controller
public class CheckUserController {
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value={"/idCheck.do","/emailCheck.do"})
	public ModelAndView idCheck(@RequestParam(value="user_id",defaultValue="") String user_id,
											  @RequestParam(value="user_email",defaultValue="") String user_email,
										    HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		int result=0;
		
		if(requestUrl.equals("/idCheck.do")){
			result=userDAO.idCheck(user_id);
		}
		if(requestUrl.equals("/emailCheck.do")){
			result=userDAO.emailCheck(user_email);
		}
		
		
		ModelAndView mav=new ModelAndView("member/userCheck");
		mav.addObject("result",result);
		
		return mav;
	}

}
