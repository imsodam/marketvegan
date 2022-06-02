package com.order.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.CartDAO;
import com.order.domain.CartVO;

@Component
@Controller
public class OpCountController {
	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private CartDAO cartDAO;
	
	@RequestMapping("/opCount.do")
	public ModelAndView process(
			@RequestParam(value="cart_num") String cart_num,
			@RequestParam(value="operations") String op) {
		
		//넘겨줄 cart정보 담기(cart_num)
	    CartVO cart=new CartVO();
	    cart.setCart_num(cart_num);
	    
	    //해당 cart 기존 수량 구하기
	    int oldCount=cartDAO.selectCountCart(cart);
		
    	//수량변경
	    if(op.equals("plus")) {
		    cart.setCart_count(oldCount+1);
		    cartDAO.updateCountCart(cart);
	    }
	    if(op.equals("minus")) {
		    cart.setCart_count(oldCount-1);
		    cartDAO.updateCountCart(cart);
	    }
	    
	    //변경된 수량
	    int cart_count=cartDAO.selectCountCart(cart);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/order/opCount");
		mav.addObject("cart_count",cart_count);
		return mav;
	}
	
}
