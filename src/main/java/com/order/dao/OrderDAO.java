package com.order.dao;

import java.util.List;
import java.util.Map;

import com.order.domain.CartPrdVO;
import com.order.domain.OrderListVO;
import com.order.domain.OrdersVO;
import com.order.domain.PaymentVO;

public interface OrderDAO {
	//주문번호 중복확인
	public int orderNumCheck(String order_num);
	
	//주문1 orders insert
	public void insertOrders(OrdersVO orders);
	
	//주문2 payment insert
	public void insertPayment(PaymentVO payment);
	
	//주문3 orderPrd insert
	public void insertOrderPrd(List<CartPrdVO> cartPrd);
	
	//주문4 product update(판매수)
	public void updateSalesCount(Map<String,Object> map);
	
	//주문5 cart delete
	public void deleteCarts(Map<String,Object> map);
	
	//주문목록 마이페이지
	public List<OrderListVO> getOrderList(Map<String,Object> map);
	
	//주문목록 총 레코드수
	public int getOrdersCount(Map<String,Object> map);
	
	//주문목록 어드민
	public List<OrderListVO> getAdminOrderList(Map<String,Object> map);
	
	//주문번호에 해당하는 주문상품수
	public int getOrderPrdCount(String order_num);
	
	//주문상세(1건)
	public OrdersVO getOrders(String order_num);
	
	//주문상품목록
	public List<CartPrdVO> getOrderPrdList(String order_num);
	
	//결제상세
	public PaymentVO getPayment(String order_num);
}
