<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>

<table align="center">
<img src="../images/user.gif" >
<tr>
	<td>영화 본 시간 ${userSession.member.m_totalTime } <br/>
	총 별점 수 ${userSession.member.m_totalRate } <br/>
	${userSession.member.m_name } <br/>
	</td>
	</tr>
</table>


<%-- <c:if test="${userSession.account.bannerOption}">
	<table align="center" background="../images/bkg-topbar.gif" cellpadding="5" width="100%">
	<tr><td>
	<center>
			<c:out value="${userSession.account.bannerName}" escapeXml="false"/>
			&nbsp;
	</center>
	</td></tr>
	</table>
</c:if>
 --%>