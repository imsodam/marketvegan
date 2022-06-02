<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/order/css/order_style.css">

<div class="order_container">
	<div class="order_detail_page">
		<div class="title">주문 내역 상세</div>
		<div class="sub_title">주문번호 <span id="order_num">${orders.order_num }</span></div >
		<ul class="cart_item">
		<c:forEach var="orderPrd" items="${orderPrdList }">
			<li>
				<div class="item_img"><a href="#"><img src="./resources/admin/product/upload/${orderPrd.product_img1 }" alt="상품1"></a></div>
				<div class="item_name">
					<a href="#">${orderPrd.product_name}</a><br>
					<span><fmt:formatNumber value="${orderPrd.product_price*orderPrd.cart_count}" pattern="#,##0" />원 | ${orderPrd.cart_count}개</span>
				</div>
				<div id="${orderPrd.product_code}">
					<button class="bt bt_greenline bt_block go_cart2">장바구니담기</button>
				</div>
				<c:if test="${orders.order_state eq 'dlvr_c'}">
				<div class="review_bt">
					<a href="#" class="bt bt_green bt_block">후기쓰기</a>
				</div>
				</c:if>
				<div class="order_state">${orders.order_state_name}</div>
			</li>
			</c:forEach>
		</ul>
		<c:if test="${orders.order_state eq 'ordr_c' || orders.order_state eq 'pymn_c' || orders.order_state eq 'prdc_r'}">
			<div class="cancel_bt">
				<a href="<%=contextPath%>/orderCancel.do?order_num=${orders.order_num }" class="bt bt_garyline bt_block">전체 상품 주문 취소</a>
			</div>
		</c:if>
		<p class="cancel_info">주문취소는 "배송준비중" 이전 상태일 경우에만 가능합니다.</p>
		
		<div class="sub_title recipient">
			<span class="f_left">배송정보</span>
			<div class="f_right">
				<c:if test="${orders.order_state eq 'ordr_c' || orders.order_state eq 'pymn_c' || orders.order_state eq 'prdc_r'}">
					<button type="button" class="bt bt_greenline bt_block" id="updateAddr">배송지 변경</button>
				</c:if>
			</div>
		</div>
		<form name="addressForm" id="addressForm" method="post" action="<%=contextPath%>/updateAddress.do">
		<input type="hidden" name="order_num" value="${orders.order_num }">
		<table class="order_info_tb recipient_tb">
			<tr>
				<th>받는사람이름</th>
				<td>
					<span class="curr_addr">${orders.order_recipient}</span>
					<input type="text" name="order_recipient" value="${orders.order_recipient}" class="chan_addr">
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>
					<span class="curr_addr phone_num1">${orders.order_phone}</span>
					<input type="text" name="order_phone" value="${orders.order_phone}" class="chan_addr" numberOnly>
				</td>
			</tr>
			<tr>
				<th valign="top">주소</th>
				<td>
					<span class="curr_addr">(${orders.order_zipcode})</span>
					<span class="curr_addr">${orders.order_addr1}</span>
					<span class="curr_addr">${orders.order_addr2}</span>
					<input type="text" name="order_zipcode" id="zipcode" value="${orders.order_zipcode}" class="chan_addr zipcode">
					<div class="chan_addr addr"><button type="button" class="del_bt bt bt_green"  onclick="findAddr()">주소검색</button></div><br class="chan_addr addr">
					<input type="text" name="order_addr1" id="addr1" value="${orders.order_addr1}" class="chan_addr addr">
					<input type="text" name="order_addr2" id="addr2" value="${orders.order_addr2}" class="chan_addr addr">
				</td>
			</tr>
			<c:if test="${orders.order_invoice ne null}">
			<tr>
				<th>송장번호</th>
				<td><span>${orders.order_invoice}</span>
					<button type="button" class="del_bt bt bt_green go_delivery">배송조회</button>
				</td>
			</tr>
			</c:if>
		</table>
		</form>
		
		<div class="sub_title">결제정보</div>
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
				<td id="total_price"><fmt:formatNumber value="${orders.order_price + orders.order_delivery_charge}" pattern="#,##0" />원</td>
			</tr>
			<tr>
				<th>결제방법</th>
				<td>${payment.payment_name}</td>
			</tr>
			<tr>
				<th>결제상태</th>
				<td>
					<c:if test="${(orders.order_price + orders.order_delivery_charge - payment.payment_price) == 0}">
						결제완료
					</c:if>
					<c:if test="${(orders.order_price + orders.order_delivery_charge - payment.payment_price)  > 0}">
						<c:if test="${orders.order_state eq 'cncl_c'}">
							환불완료
						</c:if>
						<c:if test="${orders.order_state ne 'cncl_c'}">
							<div class="pay_bt"><button class="bt bt_green go_pay">결제하기</button></div>
						</c:if>
					</c:if>
				</td>
			</tr>
		</table>
		<div class="list_bt">
			<a href="<%=contextPath%>/myOrderList.do?&pageNum=${pageNum}&sDay=${sDay}&eDay=${eDay}" class="bt bt_greenline bt_block">주문목록보기</a>
		</div>
		
	</div>
</div>
<script src="./resources/order/js/order.js"></script>
<script>

var popX= (document.body.offsetWidth / 2) - (400 / 2);
var popY= (window.screen.height / 2) - (150 / 2);
popX += window.screenLeft;

//결제창 열기
$(function(){
	$('.go_pay').click(function(){
		window.open("<%=contextPath%>/payForm.do","go_pay","top="+popY+",left="+popX+",width=400,height=150");
	})
})

//장바구니 담기
	$('.go_cart2').click(function(){
		var product_code=$(this).parent().attr('id');
		var count=1;
		window.open("<%=contextPath%>/goCart.do?product_code="+product_code+"&count="+count,"go_cart","top="+popY+",left="+popX+",width=400,height=150");
	})
	
//배송조회창
	$('.go_delivery').click(function(){
		var invoice=$(this).prev().text();
		window.open("<%=contextPath%>/goDelivery.do?invoice="+invoice,"go_delivery","top="+popY+",left="+popX+",width=400,height=300");
	})
	
//폰번호 하이픈
	var phone_num1=$('.phone_num1').text();
	phone_num1=$('.phone_num1').text(phone_num1.addHyphen());
	
</script>
<script src="./resources/js/findAddr.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>