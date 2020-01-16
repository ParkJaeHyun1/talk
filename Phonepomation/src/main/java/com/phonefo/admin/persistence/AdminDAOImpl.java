package com.phonefo.admin.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.phonefo.admin.domain.AdminMemberVO;
import com.phonefo.admin.domain.AdminOnoBoardVO;
import com.phonefo.admin.domain.SearchCriteria;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Inject
	private SqlSession sqlSession;	
	
	@Override
	public List<AdminMemberVO> listMember(SearchCriteria cri) throws Exception {
		
		return sqlSession.selectList("admin.listMember", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int memberSearchCount(SearchCriteria cri) throws Exception {
		
		return sqlSession.selectOne("admin.memberSearchCount",cri);
	}

	@Override
	public List<AdminOnoBoardVO> listOno(SearchCriteria cri) throws Exception {
		
		return sqlSession.selectList("admin.listOno",cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int OnoSearchCount(SearchCriteria cri) throws Exception {
		
		return sqlSession.selectOne("admin.onoSearchCount",cri);
	}




}
