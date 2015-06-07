<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>인사</title>
</head>
<body>



Today's Box Office<br>
<%-- <c:forEach items="${boxOffice}" var="boxMovie">
	${boxMovie.title}<br>
</c:forEach>
Top 10<br>
<br><br>
Random Movies<br>
<c:forEach items="${movie}" var="randMovie">
	${randMovie.title}<br>
	<img src=${randMovie.img} width="100" height="100"><br>
</c:forEach>--%>
<c:url value="/detail.do" var="mvDetail" />
		<a href="${mvDetail}">movie1</a>
 

</body>
</html>
