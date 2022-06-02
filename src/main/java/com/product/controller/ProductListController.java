package com.product.controller;

import java.util.Collections;
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
import com.util.PagingUtil;

@Component
@Controller
public class ProductListController {
	
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정,this 생략 가능
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/itemList.do","/admin/itemList.do"})
	public ModelAndView process(
		@RequestParam(value="pageNum",defaultValue="1") int currentPage,
		@RequestParam(value="keyField",defaultValue="product_name") String keyField,
		@RequestParam(value="keyWord",defaultValue="") String keyWord,
		@RequestParam(value="category_code",defaultValue="") String category_code,
		@RequestParam(value="page",defaultValue="") String page,
		HttpServletRequest request
			) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
			
			//log.debug("currentPage:"+currentPage);//sql문의 ? 을 출력함 
			//log.debug("keyField:"+keyField);
			//log.debug("keyWord:"+keyWord);
			//log.debug("category_code:"+category_code);
		}
		
		//카테고리 목록
		List<CategoryVO> categoryList=null;
		categoryList=productDAO.getCategoryList();
		
		//검색분야,검색어를->parameterType="map"(Map객체)
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		map.put("category_code", category_code);
		map.put("page", page);
		
		//총 레코드수
		int count=productDAO.getProductCount(map);
		//System.out.println("ProductListController클래스의 count=>"+count);
		
		PagingUtil paging=new PagingUtil(map,currentPage,count,3,3,"itemList.do");
		//start=>페이지당 맨 첫번째 나오는 게시물 번호, end=>마시막 게시물번호
		map.put("start", paging.getStartCount());//<->map.get("start")=>#{start}
		map.put("end", paging.getEndCount());
		
		List<ProductVO> productList=null;
		if(count>0) {
			productList=productDAO.getProductList(map);
		}else {
			productList=Collections.EMPTY_LIST;
		}
		
		ModelAndView mav=new ModelAndView();
		if(requestUrl.equals("/itemList.do")) {
			mav.setViewName("/template/template");
		}
		else if(requestUrl.equals("/admin/itemList.do")) {
			mav.setViewName("/template/templateAdmin");
		}
		mav.addObject("DIRECTORY","product");
		mav.addObject("CONTENT","menu");
		mav.addObject("count",count);
		mav.addObject("productList",productList);
		mav.addObject("pagingHtml",paging.getPagingHtml());
		mav.addObject("category_code",category_code);
		mav.addObject("page",page);
		mav.addObject("keyWord",keyWord);
		mav.addObject("keyField",keyField);
		mav.addObject("categoryList",categoryList);
		
		return mav;
	}
}

