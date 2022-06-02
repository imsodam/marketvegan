package com.change.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.order.domain.ChangeVO;
import com.order.domain.OrdersVO;

@Service("changeDAOImple")
public class ChangeDAOImpl extends SqlSessionDaoSupport implements ChangeDAO {
	
	
	//주문상태 변경
	public int updateOrderState(Map<String,Object> map) {
		return getSqlSession().update("updateOrderState",map);
	}
	
	//송장번호 입력
	public int updateInvoice(Map<String,Object> map) {
		return getSqlSession().update("updateInvoice",map);
	}
	
	//배송완료날짜 입력 
	public int updateDeliveryDate(String order_num) {
		return getSqlSession().update("updateDeliveryDate",order_num);
	}
	
	//배송지 변경
	public int updateAddress(OrdersVO orders) {
		return getSqlSession().update("updateAddress",orders);
	}
	
	//변경테이블 정보 가져오기
	public ChangeVO getChange(String order_num) {
		return getSqlSession().selectOne("getChange",order_num);
	}
	
	//변경테이블 입력
	public int insertChange(ChangeVO change) {
		return getSqlSession().update("insertChange",change);
	}
	
	//변경테이블 수정
	public int updateChange(Map<String,Object> map) {
		return getSqlSession().update("updateChange",map);
		
	}
}
