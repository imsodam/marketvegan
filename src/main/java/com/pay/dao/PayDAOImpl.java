package com.pay.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.order.domain.PaymentVO;

@Service("payDAOImple")
public class PayDAOImpl extends SqlSessionDaoSupport implements PayDAO {
	//결제처리
		public int payUpdate(Map<String,Object> map) {
			return getSqlSession().update("payUpdate",map);
		}
		
	//결제목록 레코드수
	 public int getPayCount(Map<String,Object> map) {
		 return getSqlSession().selectOne("getPayCount",map);
	 }
	
	 //결제목록
	 public List<PaymentVO> getPayList(Map<String,Object> map) {
		 return getSqlSession().selectList("getPayList",map);
		
	 }
	
}
