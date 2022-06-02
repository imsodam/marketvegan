package com.order.controller;

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

import com.codeinfo.dao.CodeInfoDAO;
import com.codeinfo.domain.CodeInfoVO;
import com.order.dao.OrderDAO;
import com.order.domain.OrderListVO;
import com.user.dao.UserDAO;
import com.user.domain.UserVO;
import com.util.GetDate;
import com.util.LoginId;
import com.util.PagingUtil;
import com.util.Static;

@Component
@Controller
public class OrderListController {
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정,this 생략 가능

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private CodeInfoDAO codeInfoDAO;
	
	@RequestMapping(value={"/myOrderList.do","/admin/orderList.do"})
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyField",defaultValue="") String keyField,
			@RequestParam(value="keyWord",defaultValue="") String keyWord,
			@RequestParam(value="sDay",defaultValue="") String sDay,
			@RequestParam(value="eDay",defaultValue="") String eDay,
			@RequestParam(value="order_state",defaultValue="") String order_state,
			HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		if(log.isDebugEnabled()) {
			//log.debug("sDay=>"+sDay);
			//log.debug("eDay=>"+eDay);
		}
		
		Map<String,Object> map1=new HashMap<String,Object>();

	    UserVO user=new UserVO();
	    String user_id="";
		if(requestUrl.equals("/myOrderList.do")) {
			//로그인 아이디 가져오기
		    LoginId id=new LoginId(request);
		    user_id=id.getId();	
		    //회원정보 가져오기
		    if(Static.notEmpty(user_id)) {
				user=userDAO.getUser(user_id);
				map1.put("user_id", user_id);
		    }
		}   

		List<OrderListVO> orderList=null;
		PagingUtil paging=null;
		int count=0;
		List <CodeInfoVO> stateList=null;

		//로그인 안하고 마이페이지 접근이 아닌경우만 처리한다
		if(!(Static.empty(user_id) && requestUrl.equals("/myOrderList.do"))) {
			//오늘날짜,1년전날짜구하기---------------------------
		    GetDate gd=new GetDate();
		    HashMap map=gd.getDate();
		    String today=(String) map.get("today");
		    String yearAgo=(String) map.get("yearAgo");
			//--------------------------------------------------------
		    //날자값 안넘어올때 1년전~오늘로 세팅
			if(sDay==null || "".equals(sDay)) {
				sDay=yearAgo;
				eDay=today;
			}
	
			map1.put("keyField", keyField);
			map1.put("keyWord", keyWord);
			map1.put("sDay", sDay);
			map1.put("eDay", eDay);
			map1.put("order_state", order_state);
			//log.debug("map1=>"+map1);
			//총레코드수
			count=orderDAO.getOrdersCount(map1);
			//System.out.println("OrderListController클래스의 count=>"+count);
			//넘겨줄 페이지
			String pageUrl="";
				if(requestUrl.equals("/myOrderList.do")) {
					pageUrl="myOrderList.do";
				}
				if(requestUrl.equals("/admin/orderList.do")) {
					pageUrl="orderList.do";
				}
	
			
			paging=new PagingUtil(map1,currentPage,count,5,3,pageUrl);
			//start,end구해서 map에 넣어주기
			map1.put("start", paging.getStartCount());
			map1.put("end", paging.getEndCount());
			if(count>0) {
				if(requestUrl.equals("/myOrderList.do")) {
					orderList=orderDAO.getOrderList(map1);
					for(OrderListVO orders:orderList) {
						int prdCount=orderDAO.getOrderPrdCount(orders.getOrder_num());
						orders.setOrder_product_count(prdCount);
					}
				}
				if(requestUrl.equals("/admin/orderList.do")) {
					orderList=orderDAO.getAdminOrderList(map1);
				}
			}else {
				orderList=Collections.EMPTY_LIST;
			}
			//log.debug("orderList=>"+orderList);
			//주문상태 목록 
			stateList=codeInfoDAO.codeList("order_state");
		}
		ModelAndView mav=new ModelAndView();
		if(requestUrl.equals("/myOrderList.do")) {
			mav.setViewName("/template/template");
			mav.addObject("CONTENT","mypageOrder");
			mav.addObject("DIRECTORY","member");
			mav.addObject("user",user);
			mav.addObject("pageNum",currentPage);
		}
		else if(requestUrl.equals("/admin/orderList.do")) {
			mav.setViewName("/template/templateAdmin");
			mav.addObject("DIRECTORY","order");
			mav.addObject("CONTENT","list");
		}
		mav.addObject("orderList",orderList);
		mav.addObject("sDay",sDay);
		mav.addObject("eDay",eDay);
		mav.addObject("keyField",keyField);
		mav.addObject("keyWord",keyWord);
		mav.addObject("order_state",order_state);
		mav.addObject("count",count);
		mav.addObject("stateList",stateList);
		if(!(Static.empty(user_id) && requestUrl.equals("/myOrderList.do"))) {
			mav.addObject("pagingHtml",paging.getPagingHtml());
		}
		
		return mav;
	}
}
