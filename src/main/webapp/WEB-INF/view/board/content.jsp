<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/board/css/board.css">
<link rel="stylesheet" href="./resources/order/css/order_style.css">
<!DOCTYPE html>
<div class="board_container">
	<h2>${board_group_name}</h2>
	<table class="board_content_tb">
		<tr>
			<th>제목</th>
			<td>${board.board_title }</td>
			<th>작성자</th>
			<td>MarketVegan</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${board.board_date}" type="both" pattern="yyyy-MM-dd"/></td>
			<th>조회수</th>
			<td>${board.board_views}</td>
		</tr>
	</table>
	<div class="board_content">
		<c:if test="${board.board_img ne null}">
			<div><img src="./resources/admin/board/upload/${board.board_img}"></div>
		</c:if>
		<c:if test="${board.board_img eq null }">
			<c:set var="width100" value="style='width:100%;'" />
		</c:if>
		<pre ${width100 }>${board.board_content}</pre>
	</div>
	<div class="board_list_bt">
		<div>
			<c:if	test="${prev_num ne null }">
			<a href="<%=contextPath%>/get${board_group}.do?board_num=${prev_num}&pageNum=${pageNum}&keyField=${keyField}&keyWord=${keyWord}" class="bt bt_greenline">이전</a>
			</c:if>
		</div>
		<div>
			<a href="<%=contextPath%>/list${board_group}.do?pageNum=${pageNum}" class="bt bt_green">목록</a></div>
		<div>
			<c:if	test="${next_num ne null}">
			<a href="<%=contextPath%>/get${board_group}.do?board_num=${next_num}&pageNum=${pageNum}&keyField=${keyField}&keyWord=${keyWord}" class="bt bt_greenline">다음</a>
			</c:if>
		</div>
	</div>
</div>