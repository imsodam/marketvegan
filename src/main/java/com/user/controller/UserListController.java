package com.user.controller;

import java.util.Collections;
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

import com.user.dao.UserDAO;
import com.user.domain.UserVO;
import com.util.PagingUtil;

@Component
@Controller
public class UserListController {
	
	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/admin/userList.do")
	public ModelAndView process(
		@RequestParam(value="pageNum",defaultValue="1") int currentPage,
		@RequestParam(value="keyField",defaultValue="") String keyField,
		@RequestParam(value="keyWord",defaultValue="") String keyWord
			) {
		if(log.isDebugEnabled()) {
			//log.debug("currentPage:"+currentPage);
			//log.debug("keyField:"+keyField);
			//log.debug("keyWord:"+keyWord);
		}
		
		Map<String,Object> map=new HashMap<String,Object>();
		//검색어
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		//총레코드수
		int count=userDAO.getUserCount(map);
		//System.out.println("UserListController클래스의 count=>"+count);
		PagingUtil paging=new PagingUtil(map,currentPage,count,3,3,"userList.do");
		//start,end구해서 map에 넣어주기
		map.put("start", paging.getStartCount());
		map.put("end", paging.getEndCount());
		
		List<UserVO> userList=null;
		if(count>0) {
			userList=userDAO.getUserList(map);
		}else {
			userList=Collections.EMPTY_LIST;
		}
		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/template/templateAdmin");
		mav.addObject("DIRECTORY","member");
		mav.addObject("CONTENT","list");
		mav.addObject("count",count);
		mav.addObject("userList",userList);
		mav.addObject("pagingHtml",paging.getPagingHtml());
		mav.addObject("keyWord",keyWord);
		mav.addObject("keyField",keyField);
		
		return mav;
	}
}
