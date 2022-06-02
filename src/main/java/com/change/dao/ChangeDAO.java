package com.change.dao;

import java.util.Map;

import com.order.domain.ChangeVO;
import com.order.domain.OrdersVO;

public interface ChangeDAO {

	
	//주문상태 변경
	public int updateOrderState(Map<String,Object> map);
	
	//송장번호 입력
	public int updateInvoice(Map<String,Object> map);
	
	//배송완료날짜 입력 
	public int updateDeliveryDate(String order_num);
	
	//배송지 변경
	public int updateAddress(OrdersVO orders);
	
	//변경테이블 정보 가져오기
	public ChangeVO getChange(String order_num);
	
	//변경테이블 입력
	public int insertChange(ChangeVO change);
	
	//변경테이블 수정
	public int updateChange(Map<String,Object> map);
	
}
