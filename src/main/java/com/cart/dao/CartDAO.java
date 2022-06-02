package com.cart.dao;

import java.util.List;
import java.util.Map;

import com.order.domain.CartPrdVO;
import com.order.domain.CartVO;

public interface CartDAO {
	//장바구니 담기
	public void insertCart(CartVO cart);
	
	//장바구니 수량 변경
	public void updateCountCart(CartVO cart);
	
	//장바구니 해당 상품 있는지 조회
	public int selectCartProduct(CartVO cart);
	
	//장바구니 갯수 가져오기
	public int cartListCount(String user_id);
	
	//장바구니 목록(아이디별)
	public List<CartPrdVO> cartAllList(String user_id);
	
	//장바구니 선택 상품목록 가져오기
	public List<CartPrdVO> cartCheckedList(Map<String,Object> map);

	//장바구니 수량 조회
	public int selectCountCart(CartVO cart);

	//장바구니 삭제
	public void deleteCart(String cart_num);
}
