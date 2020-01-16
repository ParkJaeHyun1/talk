package com.phonefo.admin.domain;

public class SearchCriteria extends Criteria{
   private String searchType;
   private String keyword;
   
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
   
	 @Override
     public String toString() {
       return "Search Critera [현페이지="+ getPage() 
                         +", 페이지당 출력행="+ getPerPageNum()
    		             + ", 검색조건="+searchType+ ", 검색어="+ keyword+ "]";
     }
	
}



