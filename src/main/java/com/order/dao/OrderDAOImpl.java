package com.order.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.order.domain.CartPrdVO;
import com.order.domain.OrderListVO;
import com.order.domain.OrdersVO;
import com.order.domain.PaymentVO;

@Service("orderDAOImple")
public class OrderDAOImpl extends SqlSessionDaoSupport implements OrderDAO {
	//주문번호 중복확인
	public int orderNumCheck(String order_num) {
		return getSqlSession().selectOne("orderNumCheck",order_num);
	}
	
	//주문1 orders insert
	public void insertOrders(OrdersVO orders){
		getSqlSession().insert("insertOrders", orders);
	}
	
	//주문2 payment insert
	public void insertPayment(PaymentVO payment){
		getSqlSession().insert("insertPayment", payment);
		
	}
	
	//주문3 orderPrd insert
	public void insertOrderPrd(List<CartPrdVO> cartPrd){
		getSqlSession().insert("insertOrderPrd", cartPrd);
		
	}
	
	//주문4 product update(판매수)
	public void updateSalesCount(Map<String,Object> map){
		getSqlSession().update("updateSalesCount",map);
	}
	
	//주문5 cart delete
	public void deleteCarts(Map<String,Object> map){
		getSqlSession().update("deleteCarts", map);
	}

	//주문목록 마이페이지
	public List<OrderListVO> getOrderList(Map<String,Object> map){
		List<OrderListVO> list=getSqlSession().selectList("getOrderList",map);
		return list;
	}
	
	//주문목록 총 레코드수
	public int getOrdersCount(Map<String,Object> map) {
		return getSqlSession().selectOne("getOrdersCount",map);
	}
	
	//주문목록 어드민
	public List<OrderListVO> getAdminOrderList(Map<String,Object> map){
		List<OrderListVO> list=getSqlSession().selectList("getAdminOrderList",map);
		return list;
	}
	//주문번호에 해당하는 주문상품수
	public int getOrderPrdCount(String order_num) {
		return getSqlSession().selectOne("getOrderPrdCount",order_num);
	}
	//주문상세(1건)
	public OrdersVO getOrders(String order_num) {
		return getSqlSession().selectOne("getOrders",order_num);
	}
	
	//주문상품목록
	public List<CartPrdVO> getOrderPrdList(String order_num) {
		return getSqlSession().selectList("getOrderPrdList",order_num);
	}
	
	//결제상세
	public PaymentVO getPayment(String order_num) {
		return getSqlSession().selectOne("getPayment",order_num);
	}
}
