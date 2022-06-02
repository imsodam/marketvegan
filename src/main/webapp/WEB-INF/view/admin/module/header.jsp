<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
<div class="wrap">
<c:if test="${sessionScope.adminIdKey eq null}">
	<a href="<%=contextPath%>/admin/login.do">관리자로그인</a>
</c:if>
<c:if test="${sessionScope.adminIdKey ne null}">
	<a href="<%=contextPath%>/admin/logout.do">로그아웃</a>
</c:if>
</div>