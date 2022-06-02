package com.admin.dao;

import com.admin.domain.AdminVO;

public interface AdminDAO {
	//관리자로그인
	public AdminVO adminLogin(AdminVO admin);
}
