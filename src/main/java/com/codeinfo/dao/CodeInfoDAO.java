package com.codeinfo.dao;

import java.util.List;

import com.codeinfo.domain.CodeInfoVO;

public interface CodeInfoDAO {
	//코드목록가져오기
		public List<CodeInfoVO> codeList(String group_id);
}
