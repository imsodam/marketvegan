<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
<c:if test="${check}">
	<c:set var="adminIdKey" value="${admin_id}" scope="session" />
	<script>
		location.href="<%=contextPath%>/admin/index.do"
	</script>
</c:if>
<c:if test="${!check}">
	<script>
	alert("아이디 또는 비밀번호가 틀립니다. 다시 입력해주세요");
	history.go(-1);
	</script>
</c:if>
