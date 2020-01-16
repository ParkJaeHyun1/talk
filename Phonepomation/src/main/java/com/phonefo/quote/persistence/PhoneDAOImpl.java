package com.phonefo.quote.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phonefo.quote.domain.PhoneVO;

@Repository
public class PhoneDAOImpl implements PhoneDAO{

	@Inject
	SqlSession sql;
	
	@Override
	public List<PhoneVO> samsung(String manufacture) throws Exception {
		
		List<PhoneVO> list=null;
		list =sql.selectList("quote.samsung",manufacture);
		
		return list;
	}

}
