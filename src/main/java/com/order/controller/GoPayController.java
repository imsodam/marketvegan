package com.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.change.dao.ChangeDAO;
import com.pay.dao.PayDAO;


@Component
@Controller
public class GoPayController {
	
	@Autowired
	private PayDAO payDAO;
	
	@Autowired
	private ChangeDAO changeDAO;

	@RequestMapping("/payForm.do")
	public String form() {
		return "/order/payForm";
	}
	
	@RequestMapping("/payProc.do")
	@Transactional(rollbackFor = Exception.class) 
	public String proc(@RequestParam(value="order_num") String order_num,
			@RequestParam(value="total_price") int total_price) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("order_num", order_num);
		map.put("payment_price", total_price);
		map.put("order_state", "pymn_c");
		
		payDAO.payUpdate(map);
		changeDAO.updateOrderState(map);
		
		return "/order/pay";
	}
}
