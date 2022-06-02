package com.board.controller;

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

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.util.PagingUtil;

@Component
@Controller
public class BoardListController {
	
	private Logger log=Logger.getLogger(getClass());

	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping(value= {"/admin/listNotice.do","/admin/listMagazine.do","/listNotice.do","/listMagazine.do"})
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyField",defaultValue="") String keyField,
			@RequestParam(value="keyWord",defaultValue="") String keyWord,
			HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		if(log.isDebugEnabled()) {
			//log.debug("BoardListController 호출");
		}

		//공지,매거진 분류
		String board_group="";
		String board_group_name="";
		if(requestUrl.contains("/listNotice.do")) {
			board_group="Notice";
			board_group_name="공지사항";
		}
		if(requestUrl.contains("/listMagazine.do")) {
			board_group="Magazine";
			board_group_name="매거진";
		}
		
		//DAO에 넘기기위한 맵
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		map.put("board_group", board_group);
		//총 레코드수
		int count=boardDAO.getBoardCount(map);
		//System.out.println("BoardListController클래스의 count=>"+count);
		PagingUtil paging=new PagingUtil(map,currentPage,count,3,3,"list"+board_group+".do");
		map.put("start", paging.getStartCount());
		map.put("end", paging.getEndCount());
		
		//log.debug("map=>"+map);
		//글 목록
		List<BoardVO> boardList=null;
		if(count>0) {
			boardList=boardDAO.getBoardList(map);
		}else {
			boardList=Collections.EMPTY_LIST;
		}
		
		ModelAndView mav=new ModelAndView();
		if(requestUrl.contains("admin")) {
			mav.setViewName("template/templateAdmin");
		}else {
			mav.setViewName("template/template");
		}
		mav.addObject("DIRECTORY","board");
		mav.addObject("CONTENT","list");
		mav.addObject("board_group",board_group);
		mav.addObject("board_group_name",board_group_name);
		mav.addObject("keyWord",keyWord);
		mav.addObject("keyField",keyField);
		mav.addObject("boardList",boardList);
		mav.addObject("pagingHtml",paging.getPagingHtml());
		mav.addObject("count",count);
		mav.addObject("pageNum",currentPage);
		
		return mav;
	}
}
