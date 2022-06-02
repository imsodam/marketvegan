package com.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.dao.UserDAO;
import com.user.domain.UserVO;

@Component
@Controller
public class UserController {

	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/admin/userDetail.do")
	public ModelAndView process(
			@RequestParam(value="user_id",defaultValue="") String user_id) {
		
		if(log.isDebugEnabled()) {
			//log.debug("user_id:"+user_id);
		}
		
		UserVO user=null;
		user=userDAO.getUser(user_id);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/admin/member/detail");
		mav.addObject("user",user);
		return mav;
	}
}
