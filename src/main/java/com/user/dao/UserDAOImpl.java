package com.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.user.domain.UserVO;

@Service("userDAOImple")
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {
	//로그인
	public UserVO loginProc(UserVO user) {
		return (UserVO)getSqlSession().selectOne("selectLogin",user);
	}
	
	//아이디,비번 찾기
	public UserVO findUser(UserVO user) {
		return (UserVO)getSqlSession().selectOne("findUser",user);
	}
	
	//아이디중복확인
	public int idCheck(String user_id) {
		return getSqlSession().selectOne("idCheck",user_id);
	}
	
	//이메일중복확인
	public int emailCheck(String user_email) {
		return getSqlSession().selectOne("emailCheck",user_email);
	}
	//회원가입
	public void inserUser(UserVO user) {
		getSqlSession().insert("insertUser",user);		
	}
	
	//회원목록
	public List<UserVO> getUserList(Map<String, Object> map) {
		List<UserVO> list=getSqlSession().selectList("userSelectList",map);
		return list;
	}
	
	//회원레코드수
	public int getUserCount(Map<String, Object> map) {
		return getSqlSession().selectOne("userListCount",map);
	}
	
	//회원 상세
	public UserVO getUser(String user_id) {
		return (UserVO)getSqlSession().selectOne("getUser",user_id);
	}
	

	//회원정보 수정
	public int updateUser(UserVO user) {
		return getSqlSession().update("updateUser",user);
	}

	//회원탈퇴
	public  int endUser(String user_id) {
		return getSqlSession().update("endUser",user_id);
	}
	
	//비밀번호 수정
	public int updatePwd(UserVO user) {
		return getSqlSession().update("updatePwd",user);
	}
}