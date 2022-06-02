package com.pay.dao;

import java.util.List;
import java.util.Map;

import com.order.domain.PaymentVO;

public interface PayDAO {

	//결제처리
	public int payUpdate(Map<String,Object> map);
	
	//결제목록 레코드수
	 public int getPayCount(Map<String,Object> map);
	
	 //결제목록
	 public List<PaymentVO> getPayList(Map<String,Object> map);
}

