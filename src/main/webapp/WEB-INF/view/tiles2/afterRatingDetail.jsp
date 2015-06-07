<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>인사</title>
</head>
<body>
<form:form CommandName="MovieCommand" method="post">
Movie 상세페이지<br><br>
<table>
<tr><td>title</td><td><form:input path="title" value="avengers"/></td></tr>
<tr><td>image</td><td><form:input path="img" value="abc"/></td></tr>
<tr><td>director</td><td><form:input path="director" value="a"/></td></tr>
<tr><td>genre</td><td><form:input path="genre" value="action"/></td></tr>
<tr><td>nation</td><td><form:input path="nation" value="America"/></td></tr>
</table>
<br><br>
별점 : ${rate} <br><br>
다시 평가하기 

<form:input path="rate" value="${MovieCommand.rate}"/>
<input type="submit" value="submit">
</form:form>

</body>
</html>
