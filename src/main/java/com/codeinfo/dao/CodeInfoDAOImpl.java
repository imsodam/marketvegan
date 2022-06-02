package com.codeinfo.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.codeinfo.domain.CodeInfoVO;

@Service("codeInfoDAOImp")
public class CodeInfoDAOImpl extends SqlSessionDaoSupport implements CodeInfoDAO {
	
	//코드목록가져오기
	public List<CodeInfoVO> codeList(String group_id){
		List<CodeInfoVO> list=getSqlSession().selectList("codeList",group_id);
		return list;
	}
}