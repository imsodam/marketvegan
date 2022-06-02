<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<div class="wrap">
	<div class="main_logo">
		<a href="<%=contextPath%>/admin/index.do">
			<img src="../resources/img/logo/logo2.png" alt="메인로고">
		</a>
	</div>
	<nav class="main_nav">
		<ul class="nav_menu">
			<li><a href="<%=contextPath%>/admin/userList.do">회원관리</a></li>
			<li><a href="<%=contextPath%>/admin/itemList.do">상품관리</a></li>
			<li><a href="#">상품리뷰관리</a></li>
			<li><a href="#">상품문의관리</a></li>
			<li><a href="<%=contextPath%>/admin/orderList.do">주문관리</a></li>
			<li><a href="<%=contextPath%>/admin/payList.do">결제관리</a></li>
			<li><a href="<%=contextPath%>/admin/listNotice.do">공지관리</a></li>
			<li><a href="<%=contextPath%>/admin/listMagazine.do">매거진</a></li>
		</ul>
	</nav>
</div>