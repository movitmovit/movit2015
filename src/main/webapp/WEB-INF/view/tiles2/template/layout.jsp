
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>

<html>
<head>
<title><tiles:getAsString name="title" /></title>
<!--<title>JPetStore Demo</title>-->
<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
<META HTTP-EQUIV="Cache-Control" CONTENT="max-age=0">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<meta http-equiv="expires" content="0">
<META HTTP-EQUIV="Expires" CONTENT="Tue, 01 Jan 1980 1:00:00 GMT">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
</head>
<body>
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="user" />
<tiles:insertAttribute name="menu" />
<tiles:insertAttribute name="body" />

<%-- <tiles:insertAttribute name="footer" /> --%>
</body>
</html>
