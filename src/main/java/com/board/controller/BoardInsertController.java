package com.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.util.FileUtil;
import com.util.Static;

@Component
@Controller
public class BoardInsertController {
	private Logger log=Logger.getLogger(getClass());

	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping(value= {"/admin/insertNotice.do","/admin/insertMagazine.do","/getNotice.do","/getMagazine.do"},method=RequestMethod.GET)
	public ModelAndView form(
			@RequestParam(value="board_num",defaultValue="0") String board_num,
			@RequestParam(value="pageNum",defaultValue="1") String pageNum,
			@RequestParam(value="keyField",defaultValue="") String keyField,
			@RequestParam(value="keyWord",defaultValue="") String keyWord,
			HttpServletRequest request) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		if(log.isDebugEnabled()) {
			//log.debug("BoardInsertController 호출");
			//log.debug("board_num=>"+board_num);
		}
		
		//공지,매거진 분류
		String board_group="";
		String board_group_name="";
		if(requestUrl.contains("Notice.do")) {
			board_group="Notice";
			board_group_name="공지사항";
		}
		if(requestUrl.contains("Magazine.do")) {
			board_group="Magazine";
			board_group_name="매거진";
		}
		
		//사용자 조회시 조회수 올리기
		if(!requestUrl.contains("/admin")) {
			boardDAO.udpateBoardViews(board_num);
		}
		
		//글 상세 보기
		BoardVO board=null;
		board=boardDAO.getBoard(board_num);
		//log.debug("board=>"+board);
		
		//글 이전,다음 번호 구하기
		//먼저 키워드 키필드 board에 넣어주기
		board.setKeyField(keyField);
		board.setKeyWord(keyWord);
		Map<String,Object> map=null;
		map=boardDAO.getBoardPrevNext(board);
		Object prev_num=map.get("PREV_NUM");
		Object next_num=map.get("NEXT_NUM");
		
		ModelAndView mav=new ModelAndView();
		if(requestUrl.contains("admin")) {
			mav.setViewName("template/templateAdmin");
			mav.addObject("CONTENT","insertForm");
		}else {
			mav.setViewName("template/template");
			mav.addObject("CONTENT","content");
		}
		mav.addObject("DIRECTORY","board");
		mav.addObject("board_group",board_group);
		mav.addObject("board_group_name",board_group_name);
		mav.addObject("board",board);
		mav.addObject("prev_num",prev_num);
		mav.addObject("next_num",next_num);
		mav.addObject("pageNum",pageNum);
		if(Static.notEmpty(keyWord)) {
			mav.addObject("keyField",keyField);
			mav.addObject("keyWord",keyWord);
		}
		
		return mav;
	}
	@RequestMapping(value= {"/admin/insertNotice.do","/admin/insertMagazine.do"},method=RequestMethod.POST)
	public String submit(
			@ModelAttribute("board") BoardVO board) {
		
	
		board.setAdmin_id("admin1");//작성자 - 나중에 세션에서 받아와야함

		if(log.isDebugEnabled()) {
			log.debug("board=>"+board);
		}
		try {
			String newName="";
			//파일 업로드 했으면
			if(!board.getUpload().isEmpty()) {
				//파일이름 바꾸기
				newName=FileUtil.rename(board.getUpload().getOriginalFilename());
				System.out.println("newName=>"+newName);
				board.setBoard_img(newName);
				//파일저장
				File file=new File(FileUtil.BOARD_UPLOAD_PATH+"\\"+newName);
				board.getUpload().transferTo(file);
			}

			//log.debug("board_num=>"+board.getBoard_num());
			//DB에 반영
			if(Static.empty(board.getBoard_num())) {//글번호가 비어있다면 신규글등록
				log.debug("신규");
				boardDAO.insertBoard(board);
			}else {//글번호가 있다면 글 수정
				BoardVO oldBoard=null;
				oldBoard=boardDAO.getBoard(board.getBoard_num());//수정전 정보
				if(board.getBoard_img()!=null && oldBoard.getBoard_img()!=null) {
					FileUtil.removeFile(FileUtil.BOARD_UPLOAD_PATH, oldBoard.getBoard_img());
				}
				
				log.debug("수정");
				log.debug("board=>"+board);
				boardDAO.updateBoard(board);
			}	
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
		return "redirect:/admin/list"+board.getBoard_group()+".do";
	}
}