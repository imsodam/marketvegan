<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Market Vegan</title>
<link rel="shortcut icon" href="./resources/img/logo/favicon.png">
<link rel="stylesheet" href="./resources/order/css/order_style.css">
<script src="./resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div class="go_cart_wrap">
		상품을 장바구니에 담았습니다.
		<div class="go_cart_bt">
			<a href="<%=contextPath%>/cartList.do" class="bt bt_greenline show_cart">장바구니 보기</a>
			<a href="<%=contextPath%>/" class="bt bt_green go_shopping">쇼핑 계속하기</a>
		</div>
	</div>
	
</body>
<script>
$(function(){
	$('.show_cart').click(function(e){
		e.preventDefault();
		var url=$(this).attr('href');
		top.opener.location.href=url;
		self.close();
		
	})
	$('.go_shopping').click(function(e){
		e.preventDefault();
		self.close();
	})
})
	
</script>
</html>