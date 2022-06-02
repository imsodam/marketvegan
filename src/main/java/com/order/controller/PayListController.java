package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codeinfo.dao.CodeInfoDAO;
import com.codeinfo.domain.CodeInfoVO;
import com.order.domain.PaymentVO;
import com.pay.dao.PayDAO;
import com.util.GetDate;
import com.util.PagingUtil;

@Component
@Controller
public class PayListController {
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정,this 생략 가능

	@Autowired
	private PayDAO payDAO;
	
	@Autowired
	private CodeInfoDAO codeInfoDAO;
	
	@RequestMapping("/admin/payList.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyField",defaultValue="") String keyField,
			@RequestParam(value="keyWord",defaultValue="") String keyWord,
			@RequestParam(value="sDay",defaultValue="") String sDay,
			@RequestParam(value="eDay",defaultValue="") String eDay,
			@RequestParam(value="payment_type",defaultValue="") String payment_type) {
		
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
		
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("keyField", keyField);
		map1.put("keyWord", keyWord);
		map1.put("sDay", sDay);
		map1.put("eDay", eDay);
		map1.put("payment_type", payment_type);
		
		int count=0;
		count=payDAO.getPayCount(map1);
		//System.out.println("PayListController클래스의 count=>"+count);
		PagingUtil paging=new PagingUtil(map1,currentPage,count,5,3,"payList.do");
		//start,end구해서 map에 넣어주기
		map1.put("start", paging.getStartCount());
		map1.put("end", paging.getEndCount());
		
		//결제목록
		List<PaymentVO> payList=null;
		payList=payDAO.getPayList(map1);
		
		//결제방법목록
		List<CodeInfoVO> payTypeList=null;
		payTypeList=codeInfoDAO.codeList("payment_type");
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/templateAdmin");
		mav.addObject("DIRECTORY","order");
		mav.addObject("CONTENT", "payList");
		mav.addObject("payList",payList);
		mav.addObject("pagingHtml",paging.getPagingHtml());
		mav.addObject("sDay",sDay);
		mav.addObject("eDay",eDay);
		mav.addObject("keyField",keyField);
		mav.addObject("keyWord",keyWord);
		mav.addObject("payment_type",payment_type);
		mav.addObject("count",count);
		mav.addObject("payTypeList",payTypeList);
		
		return mav;
	}
}
