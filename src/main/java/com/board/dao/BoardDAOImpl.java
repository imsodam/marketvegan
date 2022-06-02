package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.BoardVO;

@Service("boardDAOImple")
public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {

	//글쓰기
	public void insertBoard(BoardVO board) {
		getSqlSession().insert("insertBoard",board);
	}
	//글목록
	public List<BoardVO> getBoardList(Map<String,Object> map) {
		return getSqlSession().selectList("getBoardList", map);
	}
	//글 총 레코드수
	public int getBoardCount (Map<String,Object> map) {
		return getSqlSession().selectOne("getBoardCount",map);
	}
	//글상세
	public BoardVO getBoard(String board_num) {
		return getSqlSession().selectOne("getBoard",board_num);
	}
	//이전,다음 글번호 구하기
	public Map<String,Object> getBoardPrevNext(BoardVO board) {
		return getSqlSession().selectOne("getBoardPrevNext",board);
	}
	//조회수 업
	public void udpateBoardViews(String board_num) {
		getSqlSession().update("udpateBoardViews",board_num);
	}
	//글 수정
	public void updateBoard(BoardVO board) {
		getSqlSession().update("updateBoard",board);
	}
	//글 삭제
	public void deleteBoard(String board_num) {
		getSqlSession().update("deleteBoard",board_num);
	}
}
