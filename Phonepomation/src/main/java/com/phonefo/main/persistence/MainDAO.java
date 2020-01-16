package com.phonefo.main.persistence;

import com.phonefo.main.domain.B_MemberVO;
import com.phonefo.main.domain.MemberVO;

public interface MainDAO {
	
	public void insertMember(MemberVO dto)throws Exception;
	//일반회원 아이디중복검사
	public boolean checkId(String userid)throws Exception;
	//기업회원 아이디중복검사
	public boolean checkBId(String userid)throws Exception;
	
	public void insertMember(B_MemberVO vo)throws Exception;
	
	//일반회원 로그인하기
	public boolean check_general_member(String userid,String userpwd)throws Exception;
	//기업회원 로그인하기
	public boolean check_business_member(String userid,String userpwd)throws Exception;
		
	
	//로그인한 일반회원 아이디의 정보 가져오기
	public MemberVO getVO(String userid)throws Exception;
	//로그인한 기업회원 아이디의 정보 가져오기
	public B_MemberVO getBVO(String userid)throws Exception;
}
