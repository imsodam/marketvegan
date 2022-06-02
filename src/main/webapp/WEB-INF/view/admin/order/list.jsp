<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap,com.util.GetDate"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	GetDate gd=new GetDate();
	HashMap map=gd.getDate();
	String today=(String) map.get("today");
	String yearAgo=(String) map.get("yearAgo");
%>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="../resources/admin/order/css/order_style.css">
<h2 class="title">주문 목록</h2>
<div class="search_box">
	<form name="searchForm"  id="searchForm" method="get" action="<%=contextPath%>/admin/orderList.do">
		<div>
			<input type="hidden" name="page" value="admin">
			<input type="date" name="sDay"  id="sDay" value="<%=yearAgo%>"> ~
			<input type="date" name="eDay"  id="eDay" value="<%=today%>">
			<select name="order_state" id="order_state">
					<option value="all">전체</option>
				<c:forEach var="state" items="${stateList }">	
					<option value="${state.code}">${state.code_name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<select name="keyField" id="keyField">
				<option value="order_num">주문번호</option>
				<option value="user_id">아이디</option>
				<option value="user_name">주문자명</option>
				<option value="user_phone">휴대폰</option>
				<option value="user_email">이메일</option>
			</select>
			<input type="text" name="keyWord" id="keyWord">
			<input type="button" id="listSearch" value="검색">
		</div>
	</form>
	<div class="total_count"><< 총 ${count}건 >></div>
</div>
<c:if test="${count==0 }">
	<div class="no_cart">주문내역이 없습니다.</div>
</c:if>
<c:if test="${count>0 }">


<table class="list_tb">
	<tr>
		<th>주문날짜</th>
		<th>주문번호</th>
		<th>아이디</th>
		<th>주문자명</th>
		<th>휴대폰</th>
		<th>결제금액</th>
		<th>주문상태</th>
		<th>송장번호</th>
		<th>상세보기</th>
	</tr>
	<c:forEach var="orders" items="${orderList}">
	<tr id="${orders.order_num}">
		<td><fmt:formatDate value="${orders.order_date}" type="both" pattern="yyyy.MM.dd (HH:mm)"/></td>
		<td>${orders.order_num}</td>
		<td>${orders.user_id}</td>
		<td>${orders.user_name}</td>
		<td>${fn:substring(orders.user_phone,0,3)}-${fn:substring(orders.user_phone,3,7)}-${fn:substring(orders.user_phone,7,11)}</td>
		<td class="price"><fmt:formatNumber value="${orders.order_price+orders.order_delivery_charge}" pattern="#,##0" /></td>
		<td class="${orders.order_state}">
			<%-- ${orders.order_state_name} --%>
			<select name="change_state" class="change_state">
			<c:forEach var="state" items="${stateList }">	
				<option value="${state.code}" <c:if test="${state.code==orders.order_state}">selected</c:if>>${state.code_name}</option>
			</c:forEach> 
			</select>
		</td>
		<td><input type="text" name="order_invoice" value="${orders.order_invoice }" numberOnly>
				<input type="button" class="insertInvoice" value="입력">
		</td>
		<td id="${orders.order_num}" class="go_detail"><i class="fas fa-caret-down"></i></td>
	</tr>
	</c:forEach>
</table>

<!-- 페이징처리 -->
		<div class="page_box">
			
			${pagingHtml } 
		</div>
 </c:if> 
<script src="../resources/order/js/order.js"></script>
<script src="../resources/admin/order/js/order.js"></script>
<script>
<c:if test="${!empty sDay}">
		$('#sDay').val('${sDay}')
		$('#eDay').val('${eDay}')
</c:if>
<c:if test="${!empty keyField}">
		$('#keyField').val('${keyField}')
</c:if>
<c:if test="${!empty keyWord}">
		$('#keyWord').val('${keyWord}')
</c:if>
<c:if test="${!empty order_state}">
		$('#order_state').val('${order_state}')
</c:if>
		
//상세페이지 팝업창 열기
	$('.go_detail').click(function(){
		var order_num=$(this).attr('id');
		window.open("<%=contextPath%>/admin/orderDetail.do?order_num="+order_num,"member_update","top=200,left=200,width=800,height=900")
	})		

</script>
