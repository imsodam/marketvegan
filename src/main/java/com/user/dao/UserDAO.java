package com.user.dao;

import java.util.List;
import java.util.Map;

import com.user.domain.UserVO;

public interface UserDAO {

	//로그인
	public UserVO loginProc(UserVO user);
	
	//아이디,비번 찾기
	public UserVO findUser(UserVO user);
	
	//아이디 중복확인
	public int idCheck(String user_id);
	
	//이메일 중복확인
	public int emailCheck(String user_email);
	
	//회원가입
	public void inserUser(UserVO user);
	
	//회원목록보기
	public List<UserVO> getUserList(Map<String,Object> map);
	
	//회원 레코드수
	public int getUserCount (Map<String,Object> map);
	
	//회원정보 
	public UserVO getUser(String user_id);
	
	//회원정보 수정
	public int updateUser(UserVO user);
	
	//회원탈퇴
	public  int endUser(String user_id);
	
	//비밀번호 수정
	public int updatePwd(UserVO user);
}

