<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/marketvegan/order/css/order_style.css">

<style>
ul.imsi>li{line-height:30px;}
</style>
<div class="order_container cart_page">
	<ul class="imsi">
		<li><a href="/marketvegan/showCart.do">장바구니</a></li>
		<li id="item_01"><span>상품1 </span><input type="text" value="1"> <button  class="go_cart">장바구니 담기</button></li>
		<li id="item_02"><span>상품2 </span><input type="text" value="1"> <button  class="go_cart">장바구니 담기</button></li>
		<li id="item_03"><span>상품3 </span><input type="text" value="1"> <button  class="go_cart">장바구니 담기</button></li>
	</ul>
	
</div>

<script src="order/js/order.js?v=<%=System.currentTimeMillis()%>"></script>
<script>

var popX= (document.body.offsetWidth / 2) - (400 / 2);
var popY= (window.screen.height / 2) - (150 / 2);
popX += window.screenLeft;
//장바구니 담기
	$('.go_cart').click(function(){
		var product_code=$(this).parent().attr('id');
		var count=$(this).prev().val();
		window.open("/marketvegan/goCart.do?product_code="+product_code+"&count="+count,"go_cart","top="+popY+",left="+popX+",width=400,height=150");
	})


</script>