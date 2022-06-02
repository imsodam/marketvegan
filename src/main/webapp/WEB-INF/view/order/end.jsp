<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/order/css/order_style.css">
<link rel="stylesheet" href="./resources/order/css/gray_back.css">

<c:if test="${check==0 }">
	<script>
		alert("주문실패")
		history.back();
	</script>
</c:if>

<div class="gray_container order_end">
	${cart_num}
	<p>
		<i class="far fa-check-circle"></i><br>
		${sessionScope.nameKey}님 주문이 완료되었습니다.<br>
		감사합니다!
	</p>
	<table class="price_tb">
		<tr>
			<td>결제금액</td>
			<td><span class="num"><fmt:formatNumber value="${total_price}" pattern="#,##0" /></span><span class="won">원</span></td>
		</tr>
	</table>
	<div class="gray_notes">
		<p>· [배송준비중] 이전일 때 주문 내역 페이지에서 취소가 가능합니다.</p>
		<p>· 엘리베이터 이용이 어려운 경우 6층 이상부터는 공동현관앞 또는 경비실로 배송 될 수 있습니다.</p>
		<p>· 주문/배송 및 기타 문의가 있을 경우 연락주세요.</p>
	</div>
	<div class="order_end_bt">
		<a href="<%=contextPath %>/myOrderList.do?" class="bt bt_greenline bt_block">주문 상세보기</a>
		<a href="<%=contextPath %>/" class="bt bt_green bt_block">쇼핑 계속하기</a>
	</div>
</div>

<script src="./resources/order/js/order.js"></script>
<script>

//새로고침, 뒤로가기 막기

document.onkeydown = function(e) {

key = (e) ? e.keyCode : event.keyCode;

if(key==8 || key==116) {

if(e) {

e.preventDefault();

} else {

event.keyCode = 0;

event.returnValue = false;

}

}

}
</script>