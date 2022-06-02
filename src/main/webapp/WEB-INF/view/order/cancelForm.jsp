<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/order/css/order_style.css">
<link rel="stylesheet" href="./resources/order/css/gray_back.css">

<div class="gray_container order_cancel">
	<div class="title">
		<p>
			주문취소
		</p>
		<p>
			${orderPrdList[0].product_name }외 ${fn:length(orderPrdList)-1}개 상품의 주문을 취소합니다.
		</p>
	</div>
	
	<form id="cancelForm" name="cancelForm" method="post" action="<%=contextPath%>/orderCancel.do">
	<input type="hidden" name="order_num" value="${orders.order_num}">
	<input type="hidden" name="order_state" value="${orders.order_state}">
	<input type="hidden" name="page" value="mypage">
	<div class="select_box">
		<p>취소 사유 선택</p>
		<c:forEach var="cancelType" items="${cancelTypeList}">
			<label><input type="radio" name="cancel_type" value="${cancelType.code}"> ${cancelType.code_name}</label>
		</c:forEach>
	</div>
	<div class="refund_info">
		<p>환불 정보</p>
		<table class="order_info_tb pay">
			<tr>
				<th>상품금액</th>
				<td><fmt:formatNumber value="${orders.order_price}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>배송비</th>
				<td><fmt:formatNumber value="${orders.order_delivery_charge}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>결제금액</th>
				<td><fmt:formatNumber value="${orders.order_price+orders.order_delivery_charge}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>결제방법</th>
				<td>${payment.payment_name}</td>
			</tr>
			<tr>
				<th>환불 예정 금액</th>
				<td><fmt:formatNumber value="${orders.order_price+orders.order_delivery_charge}" pattern="#,##0" />원</td>
			</tr>
		</table>
	</div>
	<div class="bt_box">
		<label><input type="checkbox" name="agree"> 주문취소 내역에 동의합니다.(전자상거래법 제8조 제2항)<span>(필수)</span></label>
		<input type="button" id="orderCancel" class="bt bt_green bt_block bt_40" value="주문 취소하기">
	</div>
	</form>
</div>

<script src="./resources/order/js/order.js"></script>