package com.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.change.dao.ChangeDAO;
import com.util.Static;

@Component
@Controller
public class ChangeStateController {

	Logger log=Logger.getLogger(getClass());

	@Autowired
	private ChangeDAO changeDAO;
	
	@RequestMapping("/admin/changeState.do")
	public String process(
			@RequestParam(value="order_num",defaultValue="") String order_num,
			@RequestParam(value="change_state",defaultValue="") String change_state,
			@RequestParam(value="invoice",defaultValue="") String invoice) {
		
		if(log.isDebugEnabled()) {
			log.debug("ChangeStateController호출됨");
		}
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("order_num", order_num);
		map.put("order_state", change_state);
		map.put("order_invoice", invoice);
		log.debug(map);
		//주문상태 변경
		changeDAO.updateOrderState(map);
		
		//송장번호 입력
		if(!Static.empty(invoice)) {
			changeDAO.updateInvoice(map);
		}
		
		//배송완료시
		if(change_state.equals("dlvr_c")) {
			changeDAO.updateDeliveryDate(order_num);
		}
		
		return "admin/order/changeState";
	}
}
