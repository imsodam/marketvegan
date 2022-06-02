<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/marketvegan/order/css/order_style.css">

<form id="cartForm" name="cartForm" method="post" action="../template/template.jsp?DIRECTORY=order&CONTENT=order">
<div class="order_container cart_page">
	<h2>장바구니222</h2>
	<div class="cart_area">
		<div class="chk_box">
			<input type="checkbox" name="checkAll" id="checkAll">
			<label for="checkAll" class="bb"></label>
			<label for="checkAll"><span>전체선택(2/2)</span></label>
			|
			<a href="#" id="checkNo">선택삭제</a>
		</div>
		<ul class="cart_item">
			<li>
				<div class="item_chk">
					<input type="checkbox" name="checkItem" id="item01">
					<label for="item01" class="bb"></label>
				</div>
				<div class="item_img"><a href="#"><img src="../order/img/item01.jpg" alt="상품1"></a></div>
				<div class="item_name">
					<a href="#">수제 비건 아이스크림</a>
				</div>
				<div class="item_count">
					<button type="button" class="count_btn minus"></button>
					<input type="text" name="order_count" id="order_count_item01" readonly value="1">
					<button type="button" class="count_btn plus"></button>
				</div>
				<div class="item_price">9,500원</div>
				<div class="item_delete"><button type="button" class="count_btn delete"></button></div>
			</li>
			<li>
				<div class="item_chk">
					<input type="checkbox" name="checkItem" id="item02">
					<label for="item02" class="bb"></label>
				</div>
				<div class="item_img"><a href="#"><img src="../order/img/item02.png" alt="상품2"></a></div>
				<div class="item_name">
					<a href="#">비건만두 800g [냉동] / 긴모양 / 청구만두</a>
				</div>
				<div class="item_count">
					<button type="button" class="count_btn minus"></button>
					<input type="text" name="order_count" id="order_count_item02" readonly value="1">
					<button type="button" class="count_btn plus"></button>
				</div>
				<div class="item_price">10,500원</div>
				<div class="item_delete"><button type="button" class="count_btn delete"></button></div>
			</li>
		</ul>
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
						<td><span class="num">20,000</span><span class="won">원</span></td>
					</tr>
					<tr>
						<td>배송비</td>
						<td><span class="num">2,500</span><span class="won">원</span></td>
					</tr>
					<tr>
						<td>결제예정금액</td>
						<td><span class="num">22,500</span><span class="won">원</span></td>
					</tr>
				</table>
			</div>
			<div class="bt">
				<input type="button" id="goOrder" class="bt bt_green bt_40 bt_block" value="주문하기">
			</div>
		</div>
	</div>
	
</div>
</form>
<script src="../order/js/order.js?v=<%=System.currentTimeMillis()%>"></script>
<script>
//퀵메뉴 스크롤
	var quickMenu=$('.price_area');
	var currentPosition = $('.price_area').position().top;
	
	$(window).scroll(function () {
		var scrollPoint = $(document).scrollTop() ,
		maxScrollPoint = $('.cart_page').height() - quickMenu.height()- currentPosition;
		
		quickMenu.stop();
		if (scrollPoint > maxScrollPoint) {
			quickMenu.animate({ "top": maxScrollPoint + "px" }, 500 );
		} else {
			quickMenu.animate( { "top": scrollPoint + "px" }, 500 );
		}
	});

</script>