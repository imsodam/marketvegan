package com.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.CartDAO;
import com.order.dao.OrderDAO;
import com.order.domain.CartPrdVO;
import com.order.domain.OrdersVO;
import com.order.domain.PaymentVO;
import com.util.ArrToCom;
import com.util.CreateOrderNum;
import com.util.LoginId;

@Component
@Controller
public class OrderProcController {
	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping("/orderProc.do")
	@Transactional(rollbackFor = Exception.class) 
	public ModelAndView process(
			@RequestParam(value="cart_num") String[] cartNumArr,
			@RequestParam(value="order_price") int order_price,
			@RequestParam(value="delivery_price") int order_delivery_charge,
			@RequestParam(value="order_recipient") String order_recipient,
			@RequestParam(value="order_phone") String order_phone,
			@RequestParam(value="order_zipcode") String order_zipcode,
			@RequestParam(value="order_addr1") String order_addr1,
			@RequestParam(value="order_addr2") String order_addr2,
			@RequestParam(value="payment_type") String payment_type,
			@RequestParam(value="card_type",defaultValue="") String card_type,
			@RequestParam(value="card_month",defaultValue="") String card_month,
			HttpServletRequest request,Exception e) {
		
		LoginId id=new LoginId(request);
		String user_id=id.getId();	 
		
		if(log.isDebugEnabled()) {
			log.debug("payment_type=>"+payment_type);
			log.debug("OrderProcController호출됨!");
		}
		
		//주문번호 생성해서 중복체크
        int check=0;
        String order_num="";
		CreateOrderNum con=new CreateOrderNum();
	    do{
			order_num=con.getOrderNum();
	    	check=orderDAO.orderNumCheck(order_num);
	        //System.out.println("주문번호중복체크(있으면 1)=>"+check);
	    }while(check==1);

	    //orders 테이블
	    OrdersVO orders=new OrdersVO();
	    String order_state="";
	    int paidPrice=0;
	  //주문상태를 은행선택시 주문완료, 카드/폰 선택시 결제완료
	    if(payment_type.equals("bank")) {
			order_state="ordr_c";
		}else {
			order_state="pymn_c";
			paidPrice=order_price+order_delivery_charge;
		}
	    orders.setOrder_num(order_num);		
	    orders.setOrder_price(order_price);
	    orders.setOrder_delivery_charge(order_delivery_charge);
	    orders.setOrder_recipient(order_recipient);
	    orders.setOrder_phone(order_phone);
	    orders.setOrder_zipcode(order_zipcode);
	    orders.setOrder_addr1(order_addr1);
	    orders.setOrder_addr2(order_addr2);
	    orders.setOrder_state(order_state);
		orders.setUser_id(user_id);
	    //log.debug("orders=>"+orders);
	    orderDAO.insertOrders(orders);
	    
	    //payment 테이블
	    PaymentVO payment=new PaymentVO();
	    payment.setPayment_type(payment_type);
	    payment.setPayment_price(paidPrice);
	    payment.setCard_type(card_type);
	    payment.setCard_month(card_month);
	    payment.setOrder_num(order_num);	
	    //log.debug("payment=>"+payment);
	    orderDAO.insertPayment(payment);
	    
	    //order_product 테이블
	    ArrToCom atc=new ArrToCom(cartNumArr);
		String cart_num=atc.getComString();
		List <CartPrdVO> cartPrdList=null;
		//선택된 장바구니 목록 불러오기 위한 맵
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id",user_id);
		map.put("cart_num",cart_num);
		cartPrdList=cartDAO.cartCheckedList(map);//선택한 장바구니 목록
		for(CartPrdVO cart:cartPrdList) {
			cart.setOrder_num(order_num);
			//log.debug("cart=>"+cart);
		}
		orderDAO.insertOrderPrd(cartPrdList);
		
		
		//판매수 올리기
		List<Integer>  productList = new ArrayList();
		for(CartPrdVO op :  cartPrdList) {
			productList.add(op.getProduct_code());
		}
	    ArrToCom atc2=new ArrToCom(productList);
	    String product_code=atc2.getComString();
	    //log.debug("product_code=>"+product_code);
	    Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("product_code",product_code);
	    orderDAO.updateSalesCount(map2);
		
	    //주문한거 cart테이블에서 삭제
	    //log.debug("cart_num=>"+cart_num);
	    Map<String,Object> map3=new HashMap<String,Object>();
		map3.put("cart_num",cart_num);
		
		
		orderDAO.deleteCarts(map3);
	    
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","order");
		mav.addObject("CONTENT","end");
		mav.addObject("total_price", order_price+order_delivery_charge);
		return mav;
	}
}
