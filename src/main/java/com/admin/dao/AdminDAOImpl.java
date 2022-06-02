package com.admin.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.admin.domain.AdminVO;

@Service("adminDAOImpl")
public class AdminDAOImpl extends SqlSessionDaoSupport implements AdminDAO {

	//관리자로그인
	public AdminVO adminLogin(AdminVO admin) {
		return (AdminVO)getSqlSession().selectOne("adminLogin",admin);
	}
}
