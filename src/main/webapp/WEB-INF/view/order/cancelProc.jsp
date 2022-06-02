<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/order/css/order_style.css">
<link rel="stylesheet" href="./resources/order/css/gray_back.css">

<div class="gray_container cancel_end">
	<c:if test="${change_state eq 'cncl_c'}">
		<p>
			<i class="fas fa-receipt"></i><br>
			주문 취소가 완료되었습니다.
		</p>
		
		<div class="gray_notes">
			<p>결제수단에 따라 3~7일 후 취소금액 확인이 가능합니다.</p>
		</div>
	</c:if>
	<c:if test="${change_state eq 'cncl_a'}">
		<p>
			<i class="fas fa-receipt"></i><br>
			주문 취소 신청이 완료되었습니다.
		</p>
		
		<div class="gray_notes">
			<p>판매자 승인후 주문취소가 완료됩니다.</p>
		</div>
	</c:if>
	<div class="order_end_bt">
		<a href="<%=contextPath%>/" class="bt bt_green bt_block">홈으로 이동</a>
	</div>
</div>

<script src="./resources/order/js/order.js"></script>