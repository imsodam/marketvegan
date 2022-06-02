package com.admin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admin.dao.AdminDAO;
import com.admin.domain.AdminVO;

@Component
@Controller
public class AdminLoginController {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private AdminDAO adminDAO;
	
	@RequestMapping(value="/admin/login.do",method=RequestMethod.GET)
	public ModelAndView loginForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/templateAdmin");
		mav.addObject("DIRECTORY","view");
		mav.addObject("CONTENT","loginForm");
		return mav;
	}
	
	@RequestMapping(value="/admin/login.do",method=RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute("inputAdmin") AdminVO inputAdmin ) {
		if(log.isDebugEnabled()) {
			log.debug("inputAdmin=>"+inputAdmin);
		}
		
		AdminVO admin=null;
		admin=adminDAO.adminLogin(inputAdmin);
		boolean check=false;//아이디,비밀번호에 맞는 레코드 있는지
		if(admin!=null) {
			check=true;
		}
		String admin_id=admin.getAdmin_id();
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/admin/view/loginPro");
		mav.addObject("check",check);
		mav.addObject("admin_id",admin_id);
		return mav;
	}
	
	//로그아웃
		@RequestMapping("/admin/logout.do")
		public String logout() {
			return "/admin/view/logout";
		}
	
}
