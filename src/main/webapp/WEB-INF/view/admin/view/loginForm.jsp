<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<div class="loginForm">
	<form name="loginForm"  id="loginForm" method="post" action="<%=contextPath%>/admin/login.do">
		<h3>관리자 로그인</h3>
		<input type="text" name="admin_id" size="20" tabindex="1" placeholder="아이디를 입력해주세요"><br>
		<input type="password" name="admin_pwd" size="20" tabindex="2" placeholder="비밀번호를 입력해주세요"><br>
		<input type="submit" value="로그인">
	</form>
</div>