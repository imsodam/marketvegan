package com.order.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.dao.CartDAO;

@Component
@Controller
public class DeleteCartController {
	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private CartDAO cartDAO;
	
	@RequestMapping("/delCart.do")
	public String process(@RequestParam(value="cart_num") String cart_num) {
		
		//삭제
		cartDAO.deleteCart(cart_num);
		
		return "/order/delCart";
	}
	
}
