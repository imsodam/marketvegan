<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap,com.util.GetDate"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="../resources/admin/order/css/order_style.css">
<h2 class="title">${board_group_name} 목록</h2>
<div class="search_box">
	<form name="searchForm"  id="searchForm" method="get" action="<%=contextPath%>/admin/list${board_group}.do">
		
		<div>
			<select name="keyField" id="keyField">
				<option value="board_title">제목</option>
				<option value="board_content">내용</option>
			</select>
			<input type="text" name="keyWord" id="keyWord">
			<input type="button" id="listSearch" value="검색">
		</div>
	</form>
	<div class="total_count"><< 총 ${count}개 >></div>
</div>
<c:if test="${count<1}">
	<div class="no_cart">${board_group}가 없습니다.</div>
</c:if>
<c:if test="${count>0}"> 
<table class="list_tb">
	<tr>
		<th>등록일</th>
		<th>제목</th>
		<th>노출여부</th>
		<th>조회수</th>
	</tr>
	 <c:forEach var="board" items="${boardList}"> 
	<tr id="">
		<td><fmt:formatDate value="${board.board_date}" type="both" pattern="yyyy.MM.dd (HH:mm)"/></td>
		<td><a href="<%=contextPath%>/admin/insert${board_group}.do?board_num=${board.board_num}">${board.board_title}</a></td>
		<td>${board.board_is_show}</td>
		<td>${board.board_views}</td>
	</tr>
	 </c:forEach> 
</table>
<div class="write_bt">
	<a href="<%=contextPath%>/admin/insert${board_group}.do" class="bt bt_green" >${board_group_name} 쓰기</a>
</div>

<!-- 페이징처리 -->
		<div class="page_box">
			${pagingHtml } 
		</div>
</c:if>  
<script src="../resources/order/js/order.js"></script>
<script src="../resources/admin/order/js/order.js"></script>
<script>
<c:if test="${!empty keyField}">
		$('#keyField').val('${keyField}')
</c:if>
<c:if test="${!empty keyWord}">
		$('#keyWord').val('${keyWord}')
</c:if>
</script>
