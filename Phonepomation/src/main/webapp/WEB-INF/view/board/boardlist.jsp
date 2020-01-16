<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

   function check(){
      
      <%if (session.getAttribute("id") != null){ %>
      document.frm.submit();
      <%}else{ %>
         alert("로그인을 해야 글을 작성할 수 있습니다");   
      <%}%>
         

   }
   
</script>

</head>
<body>
<center>
	<div class="container">
	<div id="content">
		<div class="box-header with-border">
			<h3 class="box-title">${title}</h3>
		</div>
		<div class="box-body">
			<table class="table table-bordered">
				<tr>
					<th style="width: 10px">BNO</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th style="width: 40px">VIEWCNT</th>
				</tr>
				<c:forEach items="${list}" var="boardVO">
					<tr>
						<td>${boardVO.bno}</td>
						<td><a href='/phonefo/readPage${pageMaker.makeSearch(pageMaker.cri.page) }&bno=${boardVO.bno}&tno=${tno}'>
										${boardVO.title} </a></td>
						<td>${boardVO.writer}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></td>
						<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<form role="form" action="boardinput" method="get">
			<input type="submit" value="글쓰기"/>			<!-- submit으로하면 css적용되고 button으로하면안됨 머임? -->
			<input type='hidden' name='tno' value="${tno}">
			<input type='hidden' name='page' value="${cri.page}">
			<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
			<input type='hidden' name='searchType' value="${cri.searchType}">
			<input type='hidden' name='keyword' value="${cri.keyword}">
		</form>
		<!-- /.box-body -->
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
						<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>
						<c:forEach begin="${pageMaker.startPage }"	end="${pageMaker.endPage }" var="idx">
							<li	<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>
							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<!-- /.box-footer-->
			</div>
			</div>
	</center>
</body>
</html>