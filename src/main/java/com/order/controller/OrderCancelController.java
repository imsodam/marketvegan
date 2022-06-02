package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.change.dao.ChangeDAO;
import com.codeinfo.dao.CodeInfoDAO;
import com.codeinfo.domain.CodeInfoVO;
import com.order.dao.OrderDAO;
import com.order.domain.CartPrdVO;
import com.order.domain.ChangeVO;
import com.order.domain.OrdersVO;
import com.order.domain.PaymentVO;
import com.pay.dao.PayDAO;

@Component
@Controller
public class OrderCancelController {

	Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private ChangeDAO changeDAO;
	@Autowired 
	private OrderDAO orderDAO;
	@Autowired
	private CodeInfoDAO codeInfoDAO;
	@Autowired
	private PayDAO payDAO;
	
	//취소폼
	@RequestMapping(value="/orderCancel.do",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("order_num") String order_num) {
		
		List<CodeInfoVO> cancelTypeList=null;
		List<CartPrdVO> orderPrdList=null;
		OrdersVO orders=null;
		PaymentVO payment=null;
		
		cancelTypeList=codeInfoDAO.codeList("cancel_type");
		orderPrdList=orderDAO.getOrderPrdList(order_num);
		orders=orderDAO.getOrders(order_num);
		payment=orderDAO.getPayment(order_num);
	
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/template");
		mav.addObject("DIRECTORY","order");
		mav.addObject("CONTENT","cancelForm");
		mav.addObject("cancelTypeList",cancelTypeList);
		mav.addObject("orderPrdList",orderPrdList);
		mav.addObject("orders",orders);
		mav.addObject("payment",payment);
		
		return mav;
	}
	//취소처리
		@RequestMapping(value={"/orderCancel.do","/admin/orderCancel.do"})
		@Transactional(rollbackFor = Exception.class) 
		public ModelAndView process(
				@RequestParam(value="order_num",defaultValue="") String order_num,
				@RequestParam(value="order_state",defaultValue="") String order_state,
				@RequestParam(value="cancel_type",defaultValue="") String cancel_type,
				HttpServletRequest request
				) {
			String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

			if(log.isDebugEnabled()) {
				log.debug("order_num=>"+order_num);
				log.debug("order_state=>"+order_state);
				log.debug("cancel_type=>"+cancel_type);
			}
			String change_state="";//처리상태
			OrdersVO orders=new OrdersVO();
			ChangeVO change=new ChangeVO();
			Map<String,Object> map=new HashMap<String,Object>();//DAO넘길 맵
			map.put("order_num", order_num);		
			map.put("payment_price",0);	//결제금액 0으로 설정

			//주문완료,결제완료, 관리자취소신청처리
			if(order_state.equals("ordr_c") || order_state.equals("pymn_c") ||order_state.equals("cncl_a")) {
				change_state="cncl_c";// 취소완료
			//상품준비중	
			}else if(order_state.equals("prdc_r")) {
				change_state="cncl_a";// 취소신청
			}
			map.put("order_state", change_state);//취소상태 걸정

			//change 테이블에 insert정보 담기
			change.setDelivery_date(null);
			change.setChange_content("cncl");
			change.setChange_state(change_state);
			change.setChange_reason(cancel_type);
			change.setOrder_num(order_num);
			if(requestUrl.equals("/admin/orderCancel.do")) {
				change.setChange_reason("other");
			}
			//orders 테이블 주문상태 변경
			try {
				changeDAO.updateOrderState(map);
			}catch(Exception e) {
				log.debug("updateOrderState 에러 "+e);
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
			}
			//주문완료,결제완료->취소완료
			if(order_state.equals("ordr_c") || order_state.equals("pymn_c") ) {
				try {
					changeDAO.insertChange(change);
				}catch(Exception e) {
					log.debug("insertChange 에러 "+e);
				}
				//결제완료만 결제 취소
				if(order_state.equals("pymn_c")) {
					payDAO.payUpdate(map);
				}
			//상품준비중->취소신청
			}else if(order_state.equals("prdc_r")) {
				changeDAO.insertChange(change);
			//취소신청->취소완료(관리자)
			}else if(order_state.equals("cncl_a")) {
				changeDAO.updateChange(map);
				payDAO.payUpdate(map);
			}else {}

			ModelAndView mav=new ModelAndView();
			if(requestUrl.equals("/orderCancel.do")) {
				mav.setViewName("/template/template");
				mav.addObject("DIRECTORY","order");
				mav.addObject("CONTENT","cancelProc");
			}
			if(requestUrl.equals("/admin/orderCancel.do")) {
				mav.setViewName("admin/order/changeState");
			}
			mav.addObject("change_state",change_state);
			return mav;
		}
}