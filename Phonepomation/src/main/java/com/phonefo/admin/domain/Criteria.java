package com.phonefo.admin.domain;

public class Criteria {
   private int page; //현재페이지정보
   private int perPageNum; //한 화면에 보여줄 행의 수
   
   public Criteria() {
	   page=1;
	   perPageNum=10;
   }//생성자

	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {//페이지 변경
		this.page = page;
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
   
    public int getPageStart(){
    	return (page-1) * perPageNum;
    }
   
    @Override
     public String toString() {
       return "Critera [현페이지="+page+", 페이지당 출력행="+perPageNum+"]";
     }
}



