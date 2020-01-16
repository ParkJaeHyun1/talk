package com.phonefo.admin.persistence;

import java.util.List;

import com.phonefo.admin.domain.AdminMemberVO;
import com.phonefo.admin.domain.AdminOnoBoardVO;
import com.phonefo.admin.domain.SearchCriteria;


public interface AdminDAO {

	   //��� ī�װ���/�˻���/����¡/����Ʈ
	   public List<AdminMemberVO> listMember(SearchCriteria cri)throws Exception; 
	  
	   //����˻�� ���� ��ü ���ڵ�� 
	   public int memberSearchCount(SearchCriteria cri)throws Exception;
	   
	   
	   //1��1���� ī�װ���/�˻���/����¡/����Ʈ
	   public List<AdminOnoBoardVO> listOno(SearchCriteria cri)throws Exception; 
	   
	   //1��1���� �˻�� ���� ��ü ���ڵ�� 
	   public int OnoSearchCount(SearchCriteria cri)throws Exception;
	   
	   
	   
}