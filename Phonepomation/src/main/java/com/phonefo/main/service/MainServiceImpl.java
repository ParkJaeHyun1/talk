package com.phonefo.main.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phonefo.main.domain.B_MemberVO;
import com.phonefo.main.domain.MemberVO;
import com.phonefo.main.persistence.MainDAO;

@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	MainDAO dao;
	
	@Override
	public void insertMember(MemberVO dto) throws Exception {
		
		dao.insertMember(dto);
	}

	@Override
	public boolean checkId(String userid) throws Exception {
		boolean result=false;
		result=dao.checkId(userid);
		return result;
	}

	@Override
	public void insertMemberB(B_MemberVO vo) throws Exception {
		dao.insertMember(vo);
		
	}

	@Override
	public boolean check_general_member(String userid, String userpwd) throws Exception {
		
		
		boolean result = dao.check_general_member(userid, userpwd);
		return result;
	}

	@Override
	public MemberVO getVO(String userid) throws Exception {
		return dao.getVO(userid);
		
	}

	@Override
	public boolean check_business_member(String userid, String userpwd) throws Exception {
		boolean result = dao.check_business_member(userid, userpwd);
		return result;
	}

	@Override
	public boolean checkBId(String userid) throws Exception {
		boolean result=false;
		result=dao.checkBId(userid);
		return result;
	}

	@Override
	public B_MemberVO getBVO(String userid) throws Exception {
		return dao.getBVO(userid);
	}

	




}
