package com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.util.FileUtil;

@Component
@Controller
public class BoardDeleteController {
	private Logger log=Logger.getLogger(getClass());

	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping("/admin/deleteBoard.do")
	public String process(@RequestParam("board_num") String board_num,
								  @RequestParam("board_group") String board_group) {

		if(log.isDebugEnabled()) {
			log.debug("BoardDeleteController 호출");
		}
		
		//이미지있다면 이미지 삭제
		BoardVO board=null;
		board=boardDAO.getBoard(board_num);//삭제할 레코드
		//log.debug("board=>"+board);
		if(board.getBoard_img()!=null ) {
			FileUtil.removeFile(FileUtil.BOARD_UPLOAD_PATH, board.getBoard_img());
		}
		//삭제처리
		boardDAO.deleteBoard(board_num);	
		
		return "redirect:/admin/list"+board_group+".do";
	}
}
