package com.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.CartDAO;
import com.order.domain.CartPrdVO;
import com.util.LoginId;
import com.util.Static;

@Component
@Controller
public class CartListController {
	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private CartDAO cartDAO;
	
	@RequestMapping("/cartList.do")
	public ModelAndView process(HttpServletRequest request) {
		
		//로그인 아이디 가져오기
	    LoginId id=new LoginId(request);
	    String user_id=id.getId();	    
	    
	    int cartCount=0;
	    List<CartPrdVO> cartPrdList=null;

	    if(Static.notEmpty(user_id)) {
	    	//장바구니 갯수
		    cartCount=cartDAO.cartListCount(user_id);
		    
		    //장바구니 목록
		    cartPrdList=cartDAO.cartAllList(user_id);
	    }
		
	    
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","order");
		mav.addObject("CONTENT","cart");
		mav.addObject("cartCount",cartCount);
		mav.addObject("cartPrdList",cartPrdList);
		return mav;
	}
}
