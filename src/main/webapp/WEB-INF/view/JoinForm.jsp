<!DOCTYPE html>
<!-- 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 -->
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
   <title>Movit</title>
   <link rel=stylesheet href="css/join.css" type="text/css">
</head>
<body>

<div class="Join">
  <div class="heading">
    <h2><center><font color="white">Join</font></center></h2>
    <!-- <form name="JoinForm" action="join.do"> -->
    <form method="POST">

      <div class="input-group input-group-lg">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
        <input type="text" name="m_id" class="form-control" placeholder="Username or email">
          </div>

        <div class="input-group input-group-lg">
          <span class="input-group-addon"><i class="fa fa-lock"></i></span>
          <input type="password" name="m_pw"class="form-control" placeholder="Password">
        </div>
        
        <div class="input-group input-group-lg">
          <span class="input-group-addon"><i class="fa fa-lock"></i></span>
          <input type="text" name="m_name"class="form-control" placeholder="name">
        </div>

        <button type="submit" class="float">JOIN</button>	
       </form>
      
 		</div>
 </div>



</body>
</html>