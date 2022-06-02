package com.cart.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.order.domain.CartPrdVO;
import com.order.domain.CartVO;

@Service("cartDAOImple")
public class CartDAOImpl extends SqlSessionDaoSupport implements CartDAO {

	
	//장바구니 담기
	public void insertCart(CartVO cart) {
		getSqlSession().insert("insertCart",cart);
	};
	
	//장바구니 수량 변경
	public void updateCountCart(CartVO cart) {
		getSqlSession().update("updateCountCart",cart);
	};
	
	//장바구니 해당 상품 있는지 조회
	public int selectCartProduct(CartVO cart) {
		return getSqlSession().selectOne("selectCartProduct",cart);
	};
	
	//장바구니 갯수 가져오기
	public int cartListCount(String user_id) {
		return getSqlSession().selectOne("cartListCount",user_id);
	};
	
	//장바구니 목록(아이디별)
	public List<CartPrdVO> cartAllList(String user_id) {
		List<CartPrdVO> list=getSqlSession().selectList("cartAllList",user_id);
		return list;
	};
	
	//장바구니 선택 상품목록 가져오기
	public List<CartPrdVO> cartCheckedList(Map<String,Object> map) {
		List<CartPrdVO> list=getSqlSession().selectList("cartCheckedList",map);
		return list;
	};

	//장바구니 수량 조회
	public int selectCountCart(CartVO cart) {
		return getSqlSession().selectOne("selectCountCart",cart);
	};

	//장바구니 삭제
	public void deleteCart(String cart_num) {
		getSqlSession().update("deleteCart",cart_num);
	};
}
