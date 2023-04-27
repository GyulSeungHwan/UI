package com.yedam.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.mapper.ProdMapper;

public class ProdServiceImpl implements ProdService {
	
	SqlSession session = DataSource.getInstance().openSession(true);
	ProdMapper mapper = session.getMapper(ProdMapper.class);
	
	@Override
	public List<ProdVO> prodList() {
		return mapper.prodList();
	}
	
	
}
