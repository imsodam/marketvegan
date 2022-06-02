package com.product.dao;

import java.util.List;
import java.util.Map;

import com.product.domain.CategoryVO;
import com.product.domain.ProductVO;

public interface ProductDAO {
	
	//카테고리 목록
	public List<CategoryVO> getCategoryList();
	
	//상품목록보기
	public List<ProductVO> getProductList(Map<String,Object> map);
	
	//총레코드수(검색어에 맞는 레코드수까지 포함)
	public int getProductCount(Map<String,Object> map);
	
	//상품상세보기
	public ProductVO getProduct(Integer product_code);
	
	//상품코드 최대값 구하기
	public int getMaxCode() ;
	
	//상품등록
	public void insertProduct(ProductVO product);

	//상품삭제
	public void deleteProduct(int product_code);
	
	//상품수정
	public void updateProduct(ProductVO product);
}
