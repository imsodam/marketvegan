package com.product.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.product.domain.CategoryVO;
import com.product.domain.ProductVO;

@Service("productDAOImpl")
public class ProductDAOImpl extends SqlSessionDaoSupport implements ProductDAO {

	//카테고리 목록
	public List<CategoryVO> getCategoryList() {
		return getSqlSession().selectList("getCategoryList");
	}
	
	//상품목록보기
	public List<ProductVO> getProductList(Map<String, Object> map) {
		List<ProductVO> list=getSqlSession().selectList("productSelectList",map);
		return list;
	}
	
	//총레코드수(검색어에 맞는 레코드수까지 포함)
	public int getProductCount(Map<String, Object> map) {
		return getSqlSession().selectOne("productSelectCount",map);
	}

	//상품상세보기
	public ProductVO getProduct(Integer product_code) {
		return (ProductVO)getSqlSession().selectOne("productSelect",product_code);
	}

	//상품코드 최대값 구하기
	public int getMaxCode() {
		int newcode=(Integer)getSqlSession().selectOne("getMaxCode");
		return newcode;
	}
	
	//상품등록
	public void insertProduct(ProductVO product) {
		getSqlSession().insert("insertProduct",product);
	}
	
	//상품삭제
	public void deleteProduct(int product_code) {
		getSqlSession().update("deleteProduct",product_code);		
	}
	
	//상품수정
	public void updateProduct(ProductVO product) {
		getSqlSession().update("updateProduct",product);
		
	}
	

}
