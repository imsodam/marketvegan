<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap,com.util.GetDate"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String contextPath = request.getContextPath();
%>
<c:if test="${board.board_num eq null }">
 	<c:set var="board_num" value="0" />
 	<c:set var="str" value="등록" />
</c:if>
<c:if test="${board.board_num ne null }">
 	<c:set var="board_num" value="${board.board_num}" />
 	<c:set var="str" value="수정" />
</c:if>

<link rel="stylesheet" href="../resources/admin/order/css/order_style.css">
<div class="write_form">
	<h3>${board_group_name} ${str}</h3>
	<form name="boardForm" id="boardForm" method="post" enctype="multipart/form-data" action="<%=contextPath%>/admin/insert${board_group}.do">
		<input type="hidden" name="board_group" value="${board_group}">
		<input type="hidden" name="board_num" value="${board.board_num}">
		<table class="detail_tb">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="board_title" id="board_title" value="${board.board_title }">
				</td>
			</tr>
			<tr>
				<th>노출여부</th>
				<td>
			      	<input type="radio" name="board_is_show" value='y' checked>노출
					<input type="radio" name="board_is_show" value='n'>미노출
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td>
					<input type="file" name="upload"> 
					<c:if test="${board.board_img ne null}">
						<br><br>
						<img src="../resources/admin/board/upload/${board.board_img}" height="100px;">
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="board_content" id="board_content">${board.board_content}</textarea>
				</td>
			</tr>
		</table>
		<div class="write_bt">
			<a href="javascript:history.back();" class="bt bt_green">목록</a>
			<input type="button" id="boardSubmit" class="bt bt_green" value="${str}">
			<c:if test="${board.board_num ne null}">
				<input type="button" id="boardDelete" data-num="${board.board_num}" data-group="${board_group}" class="bt bt_green" value="삭제">
			</c:if>
		</div>
	</form>
</div>
<script src="../resources/admin/board/js/script.js"></script>
<script>
//노출여부
$('input[name=board_is_show][value=${board.board_is_show}]').attr('checked', true);
</script>