package com.phonefo.main.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phonefo.main.domain.B_MemberVO;
import com.phonefo.main.domain.MemberVO;



@Repository
public class MainDAOImpl implements MainDAO{

	@Inject
	SqlSession sql;
	
	@Override
	public void insertMember(MemberVO dto) throws Exception {
		sql.insert("member.insertMember",dto);
		
	}

	@Override
	public boolean checkId(String userid) throws Exception {
		boolean result;
		 int t = sql.selectOne("member.checkId",userid);
		 if(t==1)result=false;
		 else result=true;
		return result;
	}

	@Override
	public void insertMember(B_MemberVO vo)throws Exception {
		sql.insert("member.insertMemberB",vo);
		
	}

	@Override
	public boolean check_general_member(String userid, String userpwd) throws Exception {
		Map<String, String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("userpwd", userpwd);
		
		int t = sql.selectOne("member.check_general_memeber", map);
		if(t==1)
			return true;
		else
			return false;
		
		
	}

	@Override
	public MemberVO getVO(String userid) throws Exception {
		
		return sql.selectOne("member.getVO", userid);

	}

	@Override
	public boolean check_business_member(String userid, String userpwd) throws Exception {
		Map<String, String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("userpwd", userpwd);
		
		int t = sql.selectOne("member.check_business_memeber", map);
		if(t==1)
			return true;
		else
			return false;
	}

	@Override
	public B_MemberVO getBVO(String userid) throws Exception {
		return sql.selectOne("member.getBVO", userid);

	}

	@Override
	public boolean checkBId(String userid) throws Exception {
		boolean result;
		 int t = sql.selectOne("member.checkBId",userid);
		 if(t==1)result=false;
		 else result=true;
		return result;
	}

}
