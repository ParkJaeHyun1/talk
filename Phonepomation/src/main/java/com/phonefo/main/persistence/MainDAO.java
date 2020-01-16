package com.phonefo.main.persistence;

import com.phonefo.main.domain.B_MemberVO;
import com.phonefo.main.domain.MemberVO;

public interface MainDAO {
	
	public void insertMember(MemberVO dto)throws Exception;
	//�Ϲ�ȸ�� ���̵��ߺ��˻�
	public boolean checkId(String userid)throws Exception;
	//���ȸ�� ���̵��ߺ��˻�
	public boolean checkBId(String userid)throws Exception;
	
	public void insertMember(B_MemberVO vo)throws Exception;
	
	//�Ϲ�ȸ�� �α����ϱ�
	public boolean check_general_member(String userid,String userpwd)throws Exception;
	//���ȸ�� �α����ϱ�
	public boolean check_business_member(String userid,String userpwd)throws Exception;
		
	
	//�α����� �Ϲ�ȸ�� ���̵��� ���� ��������
	public MemberVO getVO(String userid)throws Exception;
	//�α����� ���ȸ�� ���̵��� ���� ��������
	public B_MemberVO getBVO(String userid)throws Exception;
}