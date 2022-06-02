<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="../resources/admin/member/css/order_style.css">
 
<h2 class="title">회원 목록</h2>
<div class="search_box">
	<form name="searchForm"  id="searchForm" method="post" action="<%=contextPath%>/admin/userList.do">
		<div>
			<select name="keyField" id="keyField">
				<option value="user_id">아이디</option>
				<option value="user_name">이름</option>
				<option value="user_phone">휴대폰</option>
				<option value="user_email">이메일</option>
			</select>
			<input type="text" name="keyWord" id="keyWord">
			<input type="submit" id="listSearch" value="검색">
		</div>
	</form>
	<div class="total_count"><< 총 ${count}명 >></div>
</div>
<c:if test="${count==0 }">
	<div class="no_cart">회원이 없습니다.</div>
</c:if>
<c:if test="${count>0 }">

<table class="list_tb">
	<tr>
		<th>가입일</th>
		<th>아이디</th>
		<th>이름</th>
		<th>핸드폰번호</th>
		<th>이메일</th>
		<th>탈퇴여부</th>
	</tr>
	<c:forEach var="user" items="${userList}">
	<tr >
		<td>${user.user_date}</td>
		<td><a href="javascript:openWin('${user.user_id}')">${user.user_id}</a></td>
		<td>${user.user_name}</td>
		<td>${user.user_phone}</td>
		<td>${user.user_email}</td>
		<td>
			<c:if test="${user.user_end eq 'y'}">
				탈퇴함
			</c:if>
		</td>
	</tr>
	</c:forEach>
</table>

<!-- 페이징처리 -->
		<div class="page_box">
			${pagingHtml } 
		</div>
 </c:if> 
<script src="../resources/admin/member/js/memberList.js"></script>
<script>
<c:if test="${!empty keyField}">
		$('#keyField').val('${keyField}')
</c:if>
<c:if test="${!empty keyWord}">
		$('#keyWord').val('${keyWord}')
</c:if>
		

</script>
