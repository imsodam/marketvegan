package com.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/index.do")
	public ModelAndView process() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		return mav;
	}
	
	@RequestMapping("/admin/index.do")
	public ModelAndView process2() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/templateAdmin");
		return mav;
	}
}
