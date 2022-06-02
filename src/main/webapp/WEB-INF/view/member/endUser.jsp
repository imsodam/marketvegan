<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String contextPath = request.getContextPath();
%>
<c:if test="${check}">
	<script>
		alert("탈퇴되었습니다..");
		location.href="<%=contextPath%>/";
	</script>
	<%
	//세션 연결상태=>바로 종료=>메모리상의 데이터를 삭제
	//session.invalidate();
	session.removeAttribute("idKey");
	%>
</c:if>
<c:if test="${check}">
	<script>
		alert("회원탈퇴를 실패했습니다.");
		history.back();
	</script>
</c:if>