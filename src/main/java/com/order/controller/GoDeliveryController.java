package com.order.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@Controller
public class GoDeliveryController {
	@RequestMapping("goDelivery.do")
	public ModelAndView go(@RequestParam(value="invoice") String invoice) {
		
		ModelAndView mav=new ModelAndView("/order/go_delivery");
		mav.addObject("invoice",invoice);
		return mav;
		
	}
}
