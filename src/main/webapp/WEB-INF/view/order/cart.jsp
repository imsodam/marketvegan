<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String contextPath = request.getContextPath();
%>
<c:if test="${sessionScope.idKey eq null}">
	<meta http-equiv="Refresh" content="0;url=/marketvegan2/login.do">
</c:if>
<c:if test="${sessionScope.idKey ne null}">
<link rel="stylesheet" href="./resources/order/css/order_style.css">

<form id="cartForm" name="cartForm" method="post" action="<%=contextPath%>/orderForm.do">
<div class="order_container cart_page" id="cart">
	<h2>장바구니</h2>
	<div class="cart_area">
		<div class="chk_box">
			<input type="checkbox" name="checkAll" id="checkAll">
			<label for="checkAll" class="bb"></label>
			<label for="checkAll"><span>전체선택(<span class="checkedCount">${cartCount}</span>/<span class="allCount">${cartCount}</span>)</span></label>
			<!-- |
			<a href="#" id="checkNo">선택삭제</a> -->
		</div>
			<div class="no_cart">장바구니에 담긴 상품이 없습니다.</div>
			<!--S 장바구니  -->
			<ul class="cart_item">
			<c:set var="cart_price" value="0" />
			<c:set var="delivery_price" value="2500" />
			<c:set var="delivery" value="y" />
			<c:forEach var="cart" items="${cartPrdList }">
				<li id="${cart.cart_num}">
					<div class="item_chk">
						<input type="checkbox" name="checkItem" id="${cart.product_code}" value="${cart.cart_num}">
						<label for="${cart.product_code}" class="bb"></label>
					</div>
					<div class="item_img"><a href="<%=contextPath%>/showItem.do?product_code=${cart.product_code}"><img src="./resources/admin/product/upload/${cart.product_img1}" alt="${cart.product_name}"></a></div>
					<div class="item_name">
						<a href="<%=contextPath%>/showItem.do?product_code=${cart.product_code}">${cart.product_name}</a>
					</div>
					<div class="item_count">
						<button type="button" class="count_btn minus"></button>
						<input type="text" name="order_count" id="${cart.cart_num}count" readonly value="${cart.cart_count}">
						<button type="button" class="count_btn plus"></button>
						<input type="hidden" id="product_price" value="${cart.product_price}">
					</div>
					<div class="item_price">
						<span><fmt:formatNumber value="${cart.product_price*cart.cart_count}" pattern="#,##0" /></span>원
					</div>
					<div class="item_delete"><button type="button" class="count_btn delete"></button></div>
					<input type="hidden" id="product_delivery_charge" value="${cart.product_delivery_charge}">
				</li>
				<c:set var="cart_price" value="${cart_price+(cart.product_price*cart.cart_count)}" />
				<c:if test="${cart.product_delivery_charge eq 0}">
					<c:set var="delivery" value="n" />
				</c:if>
			</c:forEach>
			<c:if test="${delivery eq 'n' || cartCount==0}">
				<c:set var="delivery_price" value="0" />
			</c:if>
			
			</ul><!--E 장바구니  -->
	</div>
	<div class="price_area_warp">
		<div class="price_area">
		<!-- 
			<div class="addr">
				<i class="fas fa-map-marker-alt"></i> 배송지
				<p>서울시 강남구 테헤란로 100 ㅇㅇ아파트 101동 1004호</p>
				<a href="#" class="bt bt_greenline bt_block"><i class="fas fa-search"></i> 배송지 변경</a>
			</div>
		  -->	
			<div  class="price">
				<table class="price_tb">
					<tr>
						<td>상품금액</td>
						<td><span class="num" id="prd_price"><fmt:formatNumber value="${cart_price}" pattern="#,##0" /></span><span class="won">원</span></td>
					</tr>
					<tr>
						<td>배송비</td>
						<td><span class="num" id="dlv_price"><fmt:formatNumber value="${delivery_price}" pattern="#,##0" /></span><span class="won">원</span></td>
					</tr>
					<tr>
						<td>결제예정금액</td>
						<td><span class="num" id="tot_price"><fmt:formatNumber value="${cart_price+delivery_price}" pattern="#,##0" /></span><span class="won">원</span></td>
					</tr>
				</table>
			</div>
			<div class="bt">
				<input type="button" id="goOrder" class="bt bt_green bt_40 goOrder" value="주문하기">
			</div>
		</div>
	</div>
	
</div>
</form>
<script src="./resources/order/js/order.js"></script>
<script>
//퀵메뉴 스크롤
	var quickMenu=$('.price_area');
	var currentPosition = $('.price_area').position().top;

	$(window).scroll(function () {
		var scrollPoint = $(document).scrollTop() ,
		maxScrollPoint = $('.cart_area').height() - quickMenu.height() - 81;
		if(maxScrollPoint < 0) maxScrollPoint =0;
		quickMenu.stop();
		if (scrollPoint > maxScrollPoint) {
			quickMenu.animate({ "top": maxScrollPoint + "px" }, 500 );
		} else {
			quickMenu.animate( { "top": scrollPoint + "px" }, 500 );
		}
	});

</script>
</c:if>