<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();

//세션 연결상태=>바로 종료=>메모리상의 데이터를 삭제
//session.invalidate();
session.removeAttribute("adminIdKey");
%>
<script>
	alert("로그아웃 되었습니다");
	location.href="<%=contextPath%>/admin/login.do"
</script>