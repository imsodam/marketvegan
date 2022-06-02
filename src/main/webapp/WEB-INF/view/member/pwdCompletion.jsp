<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/member/css/pwdCompletion.css">


<c:if test="${check > 0}">
	<script>
		alert("비밀번호가 재설정 되었습니다. 새로운 비밀번호로 로그인 해주세요.");
		location.href="<%=contextPath%>/login.do"
	</script>
</c:if>
<c:if test="${check < 1}">
	<script>
		alert("비밀번호 재설정에 실패했습니다");
		history.back();
	</script>
</c:if>