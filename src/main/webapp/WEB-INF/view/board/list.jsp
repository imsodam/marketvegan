<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/board/css/board.css">
<div class="board_container">
	<h2>${board_group_name} 목록</h2>
	
	<table class="board_list_tb">
		<tr>
			<th width="80px">번호</th>
			<th>제목</th>
			<th width="120px">작성자</th>
			<th width="120px">작성일</th>
			<th width="80px">조회</th>
		</tr>
		<c:set var="num" value="${count-(pageNum-1)*3}" />
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${num}</td>
			<td><a href="<%=contextPath%>/get${board_group}.do?board_num=${board.board_num}&pageNum=${pageNum}&keyField=${keyField}&keyWord=${keyWord}">${board.board_title}</a></td>
			<td>MarketVegan</td>
			<td><fmt:formatDate value="${board.board_date}" type="both" pattern="yyyy-MM-dd"/></td>
			<td>${board.board_views}</td>
			<c:set var="num" value="${num-1}" />
		</tr>
		</c:forEach> 
	</table>
	<!-- 페이징처리 -->
	<div class="page_box">
		${pagingHtml } 
	</div>
	<div class="search_box">
		<form name="searchForm"  id="searchForm" method="get" action="<%=contextPath%>/list${board_group}.do">
			<label><input type="radio" name="keyField" value="board_title" checked> 제목</label>
			<label><input type="radio" name="keyField" value="board_content"> 내용</label>
			<input type="text" name="keyWord"><input type="image" src="./resources/img/logo/search2.webp">
		</form>
		
	</div>
</div>