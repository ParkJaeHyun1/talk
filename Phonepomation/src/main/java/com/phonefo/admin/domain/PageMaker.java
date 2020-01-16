package com.phonefo.admin.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
   private int totalCount;//전체 레코드 수
   private int startPage;//화면에 출력되는 시작 넘버
   private int endPage;//화면에 출력되는 끝 넘버
   //예) startPage:1 endPage:10 ====> 1 2 3 4 5 6 7 8 9 10
   //예) startPage:1 endPage:5 ====> 1 2 3 4 5
   //예) startPage:11 endPage:20 ====> 11 12 13 14 15 16 17 18 19 20
      
   private int displayPageNum=10;//화면에 출력할 최대 숫자 갯수
   private boolean prev;//   '<<'버튼 출력여부
   private boolean next;//   '>>'버튼 출력여부
   
   private Criteria cri;
   
   //페이지 번호 출력에 관련된 계산
   public void calcData(){
	   //Math.ceil(double a)  : 무조건 올림  1.1 --> 2   1.9 ---> 2
	   //Math.round(doublc a)   : 반올림    1.1 ---> 1     1.5 ---> 2
	  endPage =   (int)( Math.ceil((cri.getPage()/(double)displayPageNum)) 
			        * displayPageNum);
	  startPage = (endPage - displayPageNum) +1;
	  
	  int tempEndPage= (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
      //tempEndPage : 전체 총 페이지수
	  
	  if(endPage > tempEndPage){
    	  endPage = tempEndPage;
      }
      
      prev = (startPage==1) ? false : true;
         //====> 만약 1~10페이지를 출력할 때는   좌측의 '<<'버튼 생략 
      next = (endPage * cri.getPerPageNum()) >= totalCount ? false: true;
         //====> 총 100페이지, 출력하는 페이지가 90~100일때   우측의 '>>'버튼 생략 
   }//calcData

   
   public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	    calcData();//totalCount를 기준으로 페이징의 필요한 데이터를 초기화
   }
   
   public String makeQuery(int page){
	   UriComponents uriComponents=
		   UriComponentsBuilder.newInstance()
		   .queryParam("page", page) //page=3
		   .queryParam("perPageNum", cri.getPerPageNum())//perPageNum=10
		   .build();//?page=3&perPageNum=10
	   System.out.println("makeQuery:::::"+ uriComponents.toUriString());
	  return uriComponents.toUriString();
   }
   
   public String makeSearch(int page){
	   UriComponents uriComponents=
			   UriComponentsBuilder.newInstance()
			   .queryParam("page", page) //page=3
			   .queryParam("perPageNum", cri.getPerPageNum())//perPageNum=10
			   .queryParam("searchType", ((SearchCriteria)cri).getSearchType()) 
			   .queryParam("keyword", ((SearchCriteria)cri).getKeyword())
			   .build();//?page=3&perPageNum=10
	   System.out.println("makeSearch:::::"+ uriComponents.toUriString());
	   return uriComponents.toUriString();
   }
   
   
public int getTotalCount() {
	return totalCount;
}



public int getStartPage() {
	return startPage;
}

public void setStartPage(int startPage) {
	this.startPage = startPage;
}

public int getEndPage() {
	return endPage;
}

public void setEndPage(int endPage) {
	this.endPage = endPage;
}

public int getDisplayPageNum() {
	return displayPageNum;
}

public void setDisplayPageNum(int displayPageNum) {
	this.displayPageNum = displayPageNum;
}

public boolean isPrev() {
	return prev;
}

public void setPrev(boolean prev) {
	this.prev = prev;
}

public boolean isNext() {
	return next;
}

public void setNext(boolean next) {
	this.next = next;
}

public Criteria getCri() {
	return cri;
}

public void setCri(Criteria cri) {
	this.cri = cri;
}
   
   
   
}



