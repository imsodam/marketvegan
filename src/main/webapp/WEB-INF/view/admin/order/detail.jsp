<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Market Vegan</title>
<link rel="shortcut icon" href="../resources/img/logo/favicon.png">
<link rel="stylesheet" href="../resources/admin/order/css/order_style.css">
<script src="../resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div class="detail_wrap">
		<h3>기본정보</h3>
		<table class="detail_tb">
			<tr>
				<th>주문일</th>
				<td><fmt:formatDate value="${orders.order_date}" type="both" pattern="yyyy.MM.dd (HH:mm)"/></td>
				<th>주무번호</th>
				<td>${orders.order_num}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${orders.user_id}</td>
				<th>이름</th>
				<td>${orders.user_name}</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>${orders.user_phone}</td>
				<th>이메일</th>
				<td>${orders.user_email}</td>
			</tr>
			<tr>
				<th>취소여부</th>
				<td>${change.change_state_name} / ${change.change_reason_name}</td>
				<th>진행상태</th>
				<td>${orders.order_state_name}</td>
			</tr>
		</table>
		<h3>상품정보</h3>
		<table class="detail_tb">
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>상품가겨가격</th>
				<th>수량</th>
				<th>소계</th>
			</tr>
			<c:set var="no" value="1" /> 
			<c:set var="total" value="0" /> 
			<c:forEach var="orderPrd" items="${orderPrdList }">
			<tr>
				<td align="center">${no}</td>
				<td>${orderPrd.product_name }</td>
				<td class="price"><fmt:formatNumber value="${orderPrd.product_price}" pattern="#,##0" />원</td>
				<td>${orderPrd.cart_count }개</td>
				<td class="price"><fmt:formatNumber value="${orderPrd.product_price*orderPrd.cart_count}" pattern="#,##0" />원</td>
			</tr>
			<c:set var="no" value="${no+1}" /> 
			<c:set var="total" value="${total+orderPrd.product_price*orderPrd.cart_count}" /> 
			</c:forEach>
			<tr>
				<th colspan="4">합계</th>
				<td class="price"><fmt:formatNumber value="${total}" pattern="#,##0" />원</td>
			</tr>
		</table>
		<h3>결제정보</h3>
		<table class="detail_tb">
			<tr>
				<th>상품금액</th>
				<td class="price"><fmt:formatNumber value="${orders.order_price}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>배송비</th>
				<td class="price"><fmt:formatNumber value="${orders.order_delivery_charge}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>총결제금액</th>
				<td class="price bold"><fmt:formatNumber value="${orders.order_price+orders.order_delivery_charge}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>잔액</th>
				<td class="price"><fmt:formatNumber value="${orders.order_price+orders.order_delivery_charge-payment.payment_price}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>결제방법</th>
				<td class="price">${payment.payment_name}</td>
			</tr>
		</table>
		<h3 class="addr_info"><span class="f_left">배송정보</span>
			<div class="f_right">
				<c:if test="${orders.order_state eq 'ordr_c' || orders.order_state eq 'pymn_c' || orders.order_state eq 'prdc_r'}">
					<button type="button"  id="updateAddr">배송지 변경</button>
				</c:if>
			</div>
		</h3>
		<form name="addressForm" id="addressForm" method="post" action="<%=contextPath%>/updateAddress.do">
			<input type="hidden" name="order_num" value="${orders.order_num}" class="chan_addr">
			<table class="detail_tb delivery_tb">
				<tr>
					<th>받는사람 이름</th>
					<td>
						<span class="curr_addr">${orders.order_recipient}</span>
						<input type="text" name="order_recipient"  id="order_recipient" value="${orders.order_recipient}" class="chan_addr">
					</td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>
						<span class="curr_addr">${orders.order_phone}</span>
						<input type="text" name="order_phone"  id="order_phone" value="${orders.order_phone}" class="chan_addr" numberOnly></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<span class="curr_addr">${orders.order_zipcode}</span>
						<input type="text" name="order_zipcode"  id="zipcode" value="${orders.order_zipcode}" class="chan_addr">
						<button type="button" onclick="findAddr()"  class="chan_addr">주소찾기</button>
					</td>
				</tr>
				<tr>
					<th>배송지주소</th>
					<td>
						<span class="curr_addr">${orders.order_addr1}</span>
						<span class="curr_addr">${orders.order_addr2}</span>
						<input type="text" name="order_addr1"  id="addr1" value="${orders.order_addr1}" class="chan_addr"> <br class="chan_addr">
						<input type="text" name="order_addr2"  id="addr2" value="${orders.order_addr2}" class="chan_addr">
					</td>
				</tr>
				<tr>
					<th>송장번호</th>
					<td><span>${orders.order_invoice}</span>
						<c:if test="${orders.order_invoice ne null}">
							<button type="button" class="go_delivery">배송조회</button>
						</c:if>
					</td>
				</tr>
				<tr>
					<th>배송완료날짜</th>
					<td><fmt:formatDate value="${orders.order_delivery_date}" type="both" pattern="yyyy.MM.dd"/></td>
				</tr>
			</table>
		</form>
		<div class="bt_box">
			<!-- <button class="bt bt_green" id="updateSubmit">수정하기</button> -->
			<a href="javascript:close();" class="bt bt_garyline">닫기</a>
		</div>
	</div>
	
</body>
</html>
<script>
var popX= (document.body.offsetWidth / 2) - (400 / 2);
var popY= (window.screen.height / 2) - (150 / 2);
popX += window.screenLeft;
//배송조회창
	$('.go_delivery').click(function(){
		var invoice=$(this).prev().text();
		window.open("<%=contextPath%>/goDelivery.do?invoice="+invoice,"go_delivery","top="+popY+",left="+popX+",width=400,height=300");
	})
</script>

<script src="../resources/js/findAddr.js"></script>
<script src="../resources/order/js/order.js"></script>
<script src="../resourcesadmin/order/js/order.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>