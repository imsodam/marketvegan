package com.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.change.dao.ChangeDAO;
import com.order.dao.OrderDAO;
import com.order.domain.CartPrdVO;
import com.order.domain.ChangeVO;
import com.order.domain.OrdersVO;
import com.order.domain.PaymentVO;
import com.user.dao.UserDAO;
import com.user.domain.UserVO;
import com.util.LoginId;

@Component
@Controller
public class OrderDetailController {
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ChangeDAO changeDAO;
	
	@RequestMapping(value={"/orderDetail.do","/admin/orderDetail.do"})
	public ModelAndView precess(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="sDay",defaultValue="") String sDay,
			@RequestParam(value="eDay",defaultValue="") String eDay,
			@RequestParam(value="order_num",defaultValue="") String order_num,		
			HttpServletRequest request
			) {
		
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		if(log.isDebugEnabled()) {
			//log.debug("order_num=>"+order_num);
		}
		
		UserVO user=new UserVO();
		if(requestUrl.equals("/orderDetail.do")) {
			//로그인 아이디 가져오기
		    LoginId id=new LoginId(request);
		    String user_id=id.getId();	
		    //회원정보 가져오기
			user=userDAO.getUser(user_id);
		}   
		
		//주문상세
		OrdersVO orders=null;
		try {
			orders=orderDAO.getOrders(order_num);
		}catch(Exception e) {
			log.debug("getOrders에러=>"+e);
		}
		//log.debug("orders=>"+orders);
		//결제상세
		PaymentVO payment=null;
		try {
			payment=orderDAO.getPayment(order_num);
		}catch(Exception e) {
			log.debug("getPayment에러=>"+e);
		}
		//log.debug("payment=>"+payment);
		//주문 상품목록		
		List<CartPrdVO> orderPrdList=null;
		try {
			orderPrdList=orderDAO.getOrderPrdList(order_num);
		}catch(Exception e) {
			log.debug("getOrderPrdList에러=>"+e);
		}
		//log.debug("orderPrdList=>"+orderPrdList);
		
		//취소여부
		ChangeVO change=null;
		change=changeDAO.getChange(order_num);
		
		ModelAndView mav=new ModelAndView();
		if(requestUrl.equals("/orderDetail.do")) {
			mav.setViewName("/template/template");
			mav.addObject("DIRECTORY","member");
			mav.addObject("CONTENT","mypageOrderDetail");
			mav.addObject("sDay",sDay);
			mav.addObject("eDay",eDay);
			mav.addObject("pageNum",currentPage);
			mav.addObject("user",user);
		}
		if(requestUrl.equals("/admin/orderDetail.do")) {
			mav.setViewName("/admin/order/detail");
		}
		
		mav.addObject("orders",orders);
		mav.addObject("payment",payment);
		mav.addObject("orderPrdList",orderPrdList);
		mav.addObject("change",change);
		return mav;
		
	}
}
