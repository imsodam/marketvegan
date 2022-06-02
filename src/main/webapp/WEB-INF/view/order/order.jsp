<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/order/css/order_style.css">

<form id="orderForm"  name="orderForm" method="post" action="<%=contextPath%>/orderProc.do">
<div class="order_container order_page">
	<h2>주문서</h2>
<!--상품정보 -->	
	<h3>주문상품</h3>
	<ul class="cart_item">
	<c:set var="cart_price" value="0" />
	<c:set var="delivery_price" value="2500" />
	<c:set var="delivery" value="y" />
	<c:forEach var="cart" items="${cartPrdList }">
		<li>
			<div class="item_img"><img src="./resources/admin/product/upload/${cart.product_img1}" alt="${cart.product_name}"></div>
			<div class="item_name">${cart.product_name}</div>
			<div class="item_count">
				${cart.cart_count}개
			</div>
			<div class="item_price"><fmt:formatNumber value="${cart.product_price*cart.cart_count}" pattern="#,##0" />원</div>
			<input type="hidden" name="cart_num" value="${cart.cart_num }">
		</li>	
		<c:set var="cart_price" value="${cart_price+(cart.product_price*cart.cart_count)}" />
		<c:if test="${cart.product_delivery_charge eq 0}">
			<c:set var="delivery" value="n" />
		</c:if>
	</c:forEach>	
	<c:if test="${delivery eq 'n'}">
		<c:set var="delivery_price" value="0" />
	</c:if>
	</ul>
<!--주문자정보  -->
	<h3>주문자정보</h3>
	<table class="info_tb">
		<tr>
			<th>보내는분</th>
			<td>${user.user_name }</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td class="phone_num1">${user.user_phone}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${user.user_email }</td>
		</tr>
	</table>
<!--배송정보  -->
	<h3>
		<span>배송정보</span>
	</h3>
	<table class="info_tb recipient_tb">
		<tr>
			<th>받는사람 이름</th>
			<td>
				<input type="text" name="order_recipient"  id="order_recipient" value="${user.user_name}">
			</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>
				<input type="text" name="order_phone"  id="order_phone" value="${user.user_phone}" numberOnly>
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
				<input type="text" name="order_zipcode"  id="zipcode" value="${user.user_zipcode}" class="zipcode">
				<button type="button" class="del_bt bt bt_green"  onclick="findAddr()">주소검색</button>
			</td>
		</tr>
		<tr>
			<th>배송지 주소</th>
			<td>
				<input type="text" name="order_addr1"  id="addr1" value="${user.user_addr1}">
			</td>
		</tr>
		<tr>
			<th>상세주소입력</th>
			<td>
				<input type="text" name="order_addr2"  id="addr2" value="${user.user_addr2}">
			</td>
		</tr>
	</table>
<!--결제정보  -->
	<div class="ovf_hidden">
		<div class="cart_area">
			<h3>결제수단</h3>
			<div>
				<div>결제수단 선택</div>
				<div>
					<ul class="pay_type">
					<c:forEach var="pay" items="${payList}">
						<li id="${pay.code}">${pay.code_name}</li>
					</c:forEach>
					</ul>
					<input type="hidden" name="payment_type" id="payment_type" value="card">
					<div class="pay_content">
						<div class="pay_card">
							<select name="card_type" id="card_type">
							<c:forEach var="card" items="${cardList}">
								<option value="${card.code}">${card.code_name}</option>
							</c:forEach>
							</select>
							<select name="card_month" id="card_month">
							<c:forEach var="month" items="${monthList}">
								<option value="${month.code}">${month.code_name}</option>
							</c:forEach>
							</select>
						</div>
						<div>
							무통장입급 정보
						</div>
						<div>
							휴대폰 정보
						</div>
					</div>
				</div>
			</div>
			<p>
				※환불하시는 경우 결제하신 수단으로만 환불되는 점 양해부탁드립니다.<br>
				※고객님은 안전거래를 위해 현금 등으로 결제시 저희 쇼핑몰에서 가입한 토스 페이먼츠의 구매안전(에스크로)서비스를 이용하실 수 있습니다.
			</p>
		</div>
		<div class="price_area_warp">
			<h3>결제금액</h3>
			<table class="price_tb">
				<tr>
					<td>상품금액</td>
					<td><span class="num"><fmt:formatNumber value="${cart_price}" pattern="#,##0" /></span><span class="won">원</span></td>
				</tr>
				<tr>
					<td>배송비</td>
					<td><span class="num"><fmt:formatNumber value="${delivery_price}" pattern="#,##0" /></span><span class="won">원</span></td>
				</tr>
				<tr>
					<td>최종결제금액</td>
					<td><span class="num"><fmt:formatNumber value="${cart_price+delivery_price}" pattern="#,##0" /></span><span class="won">원</span></td>
				</tr>
			</table>
		</div>
	</div>
	<input type="hidden" name="order_price" value="${cart_price}">
	<input type="hidden" name="delivery_price" value="${delivery_price}">

<!--개인정보 수집/제공 동의  -->	
	<h3>개인정보 수집/제공</h3>
	<div class="private_agree">
		<input type="checkbox" name="private_agree" id="private_agree">
		<label for="private_agree" class="bb"></label>
		<label for="private_agree"><span>결제 진행 필수 동의</span></label>
		<p>
			개인정보 수집·이용 및 처리 동의<span>(필수)</span><br>
			결제대행 서비스 약관동의<span>(필수)</span><br>
		</p>
	</div>
	<div class="pay_bt">
		<input type="button" id="orderEnd" class="bt bt_green bt_40" value="결제하기">
	</div>
</div>

</form>
<script src="./resources/order/js/order.js"></script>
<script src="./resources/js/findAddr.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(document).ready(function(){
	var phone_num1=$('.phone_num1').text();
	phone_num1=$('.phone_num1').text(phone_num1.addHyphen());
})

</script>