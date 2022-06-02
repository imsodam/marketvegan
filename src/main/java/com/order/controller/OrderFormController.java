package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.CartDAO;
import com.codeinfo.dao.CodeInfoDAO;
import com.codeinfo.domain.CodeInfoVO;
import com.order.domain.CartPrdVO;
import com.user.dao.UserDAO;
import com.user.domain.UserVO;
import com.util.ArrToCom;
import com.util.LoginId;

@Component
@Controller
public class OrderFormController {
	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CodeInfoDAO codeInfoDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/orderForm.do")
	public ModelAndView process(
			@RequestParam(value="checkItem") String[] cartNumArr,
			HttpServletRequest request) {
		
		LoginId id=new LoginId(request);
		String user_id=id.getId();	 
		
		ArrToCom atc=new ArrToCom(cartNumArr);
		String cart_num=atc.getComString();
		if(log.isDebugEnabled()) {
			//log.debug("user_id=>"+user_id);
			//log.debug("cart_num=>"+cart_num);
		}
		
		List <CartPrdVO> cartPrdList=null;
		List <CodeInfoVO> payList=null;
		List <CodeInfoVO> cardList=null;
		List <CodeInfoVO> monthList=null;	
		UserVO user=null;
		
		//선택된 장바구니 목록 불러오기 위한 맵
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id",user_id);
		map.put("cart_num",cart_num);
		
		cartPrdList=cartDAO.cartCheckedList(map);//선택한 장바구니 목록
		payList=codeInfoDAO.codeList("payment_type");//결제방법
		cardList=codeInfoDAO.codeList("card_type");//카드종류
		monthList=codeInfoDAO.codeList("card_month");//카드개월수
		user=userDAO.getUser(user_id);//로그인된 회원정보
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","order");
		mav.addObject("CONTENT","order");
		mav.addObject("cartPrdList", cartPrdList);
		mav.addObject("payList", payList);
		mav.addObject("cardList", cardList);
		mav.addObject("monthList", monthList);
		mav.addObject("user", user);
		mav.addObject("cart_num", cart_num);
		return mav;
	}
	


}
