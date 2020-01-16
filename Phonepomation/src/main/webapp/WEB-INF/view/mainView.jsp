<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="./css.jsp"></jsp:include>
<jsp:include page="./jquery.jsp"></jsp:include>

</head>
<body>
<div id="container">
         <jsp:include page="./header.jsp" flush="true"/>
         <jsp:include page="${body}" flush="true"/>
         <jsp:include page="./footer.jsp" flush="true"/>
   </div>
</body>
</html>