package com.order.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.change.dao.ChangeDAO;
import com.order.domain.OrdersVO;

@Component
@Controller
public class updateAddressController {
	private Logger log=Logger.getLogger(this.getClass());

	@Autowired
	private ChangeDAO changeDAO;
	
	@RequestMapping("/updateAddress.do")
	public String process(@ModelAttribute("orders") OrdersVO orders) {
		if(log.isDebugEnabled()) {
			///log.debug("orders=>"+orders);
		}
		
		changeDAO.updateAddress(orders);
		
		return "/admin/order/changeState";
	}

}
