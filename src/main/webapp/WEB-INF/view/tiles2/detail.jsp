<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>인사</title>
</head>
<body>

<form:form CommandName="MovieCommand" method="post" action="/com/dongduk/movit/controller/viewWishController.java">
Movie 상세페이지<br><br>
<table>
<tr><td>title</td><td><form:input path="title" value="avengers"/></td></tr>
<tr><td>image</td><td><form:input path="img" value="abc"/></td></tr>
<tr><td>director</td><td><form:input path="director" value="a"/></td></tr>
<tr><td>genre</td><td><form:input path="genre" value="action"/></td></tr>
<tr><td>nation</td><td><form:input path="nation" value="America"/></td></tr>
</table>
<br><br>
평가하기 

<form:input path="rate"/>
<input type="submit" value="평가하기">
<br>
<a href="<c:url value="/addWish.do"/>"> <img border="0" src="../images/button_addwish.gif"/> </a>
</form:form>

</body>
</html>
