<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
div {
	
}

.rateInfo {
	width: 300px;
	border: 2px solid black;
	position: absolute;
	left: 150px;
	top: 400px;
}

.nation {
	width: 300px;
	border: 2px solid black;
	position: absolute;
	left: 150px;
	top: 500px;
	text-align: center;
}

.genre {
	width: 300px;
	border: 2px solid black;
	position: absolute;
	left: 570px;
	top: 400px;
	text-align: center;
}

.time {
	width: 300px;
	border: 2px solid black;
	position: absolute;
	left: 1000px;
	top: 400px;
	text-align: center;
}

.director {
	width: 300px;
	border: 2px solid black;
	position: absolute;
	left: 1000px;
	top: 500px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="rateInfo">
		별점평균 <br> 총별점수 ${userSession.member.m_totalRate }
		<br> 많이준별점 ${userSession.member.m_commonRate }
		
	</div>
	<div class="nation">
		선호국가<br><br><br><br><br><br><br> <br/>
		
	</div>
	<div class="genre">
		선호장르<br><br><br><br><br><br><br>
	</div>
	<div class="time">
		인생의 순수하게 영화 본 시간<br><br>
		${userSession.member.m_totalTime }<br><br>
		
	</div>
	<div class="director">
		선호감독<br><br><br><br><br>
	</div>
</body>
</html>
