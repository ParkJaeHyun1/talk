package com.phonefo.admin.service;

import java.util.List;

import com.phonefo.admin.domain.AdminMemberVO;
import com.phonefo.admin.domain.AdminOnoBoardVO;
import com.phonefo.admin.domain.SearchCriteria;

public interface AdminService {

	//맴버검색어를 통한 리스트 조회
    public List<AdminMemberVO> memberSearchCriteria(SearchCriteria cri)throws Exception;
    //멤버검색 카운트
    public int memberSearchCount(SearchCriteria cri)throws Exception;
    
    //1대1검색어를 통한 리스트 조회
    public List<AdminOnoBoardVO> onoSearchCriteria(SearchCriteria cri)throws Exception;
    //1대1검색 카운트
    public int onoSearchCount(SearchCriteria cri)throws Exception;
}
