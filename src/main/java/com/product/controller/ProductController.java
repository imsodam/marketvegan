package com.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.product.dao.ProductDAO;
import com.product.domain.CategoryVO;
import com.product.domain.ProductVO;

@Component
@Controller
public class ProductController {
	
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정,this 생략 가능
	
	@Autowired
	private ProductDAO productDAO;	
	
	@RequestMapping(value={"/showItem.do","/admin/getProduct.do"})
	public ModelAndView process(
		@RequestParam(value="product_code",defaultValue="0") int product_code,
		HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		//상품정보
		ProductVO product=null;
		product=productDAO.getProduct(product_code);
		
		////카테고리 목록
		List<CategoryVO> categoryList=null;
		categoryList=productDAO.getCategoryList();
		
		ModelAndView mav=new ModelAndView();
		if(requestUrl.equals("/showItem.do")) {
			mav.setViewName("/template/template");
		}
		else if(requestUrl.equals("/admin/getProduct.do")) {
			mav.setViewName("/template/templateAdmin");
		}
		mav.addObject("DIRECTORY","product");
		mav.addObject("CONTENT","item");
		mav.addObject("product",product);
		mav.addObject("categoryList",categoryList);
		
		return mav;
		
	}

}
