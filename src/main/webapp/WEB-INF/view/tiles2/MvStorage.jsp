<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>본 영화 보관함</h2>
 <br><br>
 
<table>

<c:forEach var="movie" items="${movieList}" varStatus="i">

<c:if test="${i.index % 4 == 0}"> 
<tr> 
</c:if>

<!-- <tr><td>memberIdx: </td><td><c:out value= "${storage.memberIdx}"/></td></tr>
<tr><td>movieIdx: </td><td><c:out value= "${storage.movieIdx}"/></td></tr>  -->
<td>
<table border=1>
<tr><td>index: </td><td><c:out value= "${i.index + 1}"/></td></tr>
<tr><td>image: </td><td><img src= "<c:out value= "${movie.img}"/>" width="200" height="200"/></td></tr>
<tr><td>title: </td><td><c:out value= "${movie.title}"/></td></tr>
<tr><td>director: </td><td><c:out value= "${movie.director}"/></td></tr>
<tr><td>rating: </td><td><c:out value= "${storageList.get(i.index).rate}"/></td></tr>
</table>
</td>

<c:choose>
	<c:when test="${movieList.size() % 4 == 0}">
		<c:if test="${i.index % 4 == 3}">
			</tr> 
		</c:if>
	</c:when>
	
	<c:when test="${movieList.size() % 4 != 0}">
		<c:if test="${movieList.size() > 4}">
			<c:if test="${i.index % 4 == 3}">
				</tr> 
			</c:if>
			<c:if test="${i.index == i.end}">
				</tr> 
			</c:if>
		</c:if>
	
		<c:if test="${movieList.size() < 4}">
			<c:if test="${i.index == i.end}">
				</tr> 
			</c:if>
		</c:if>
	</c:when>
</c:choose>

</c:forEach>

</table>
</body>
</html>