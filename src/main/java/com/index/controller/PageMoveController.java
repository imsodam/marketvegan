package com.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageMoveController {
	
	@RequestMapping("/info.do")
	public ModelAndView info(@RequestParam(value="page") String page) {
		ModelAndView mav=new ModelAndView("/template/template");
		mav.addObject("DIRECTORY", "info");
		mav.addObject("CONTENT", page);
		return mav;
	}

}
