package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.domain.BoardVO;

public interface BoardDAO {

	//글쓰기
	public void insertBoard(BoardVO board);
	//글목록
	public List<BoardVO> getBoardList(Map<String,Object> map);
	//글 총 레코드수
	public int getBoardCount (Map<String,Object> map);
	//글상세
	public BoardVO getBoard(String board_num);
	//이전,다음 글번호 구하기
	public Map<String,Object> getBoardPrevNext(BoardVO board);
	//조회수 업
	public void udpateBoardViews(String board_num);
	//글 수정
	public void updateBoard(BoardVO board);
	//글 삭제
	public void deleteBoard(String board_num);
}
