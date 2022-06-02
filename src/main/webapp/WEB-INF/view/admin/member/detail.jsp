<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Market Vegan</title>
<link rel="shortcut icon" href="../resources/img/logo/favicon.png">
<link rel="stylesheet" href="../resources/admin/member/css/order_style.css">
<script src="../resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div class="detail_wrap">
		
		<h3>회원정보</h3>
		<table class="detail_tb">
			<tr>
				<th>가입일</th>
				<td>${user.user_date}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${user.user_id}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${user.user_pwd}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${user.user_name}</td>
			</tr>
			<tr>
				<th>핸드폰번호</th>
				<td>${user.user_phone}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${user.user_email}</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>${user.user_zipcode}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${user.user_addr1}</td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td>${user.user_addr2}</td>
			</tr>
			<tr>
				<th>탈퇴여부</th>
				<td>${user.user_end}</td>
			</tr>
			<tr>
				<th>탈퇴일</th>
				<td>${user.user_end_date}</td>
			</tr>
		</table>
		
		<div class="bt_box">
			<a href="javascript:close();" class="bt bt_garyline">닫기</a>
		</div>
	</div>
	
</body>
</html>