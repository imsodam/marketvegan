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
		결제하시겠습니까?
		<div class="go_cart_bt">
			<a href="javascript:close();" class="bt bt_greenline">취소</a>
			<a href="#" class="bt bt_green" id="pay_proc">결제하기</a>
		</div>
	</div>
	<form id="payForm" method="post" action="<%=contextPath%>/payProc.do">
		<input type="hidden" name="order_num" id="order_num" value="">
		<input type="hidden" name="total_price" id="total_price" value="">
	</form>
</body>
<script>
$(function(){
	
	//부모창에서 결제정보 가져오기
	var order_num=opener.$('#order_num').text();
	var total_price=opener.$('#total_price').text().unComma();
	
	$('#pay_proc').click(function(e){
		e.preventDefault();
		$('#order_num').val(order_num);
		$('#total_price').val(total_price);
		$('#payForm').submit();
		//self.close();
	})
})
	
</script>
<script src="./resources/order/js/order.js"></script>
</html>