<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<div id="snb" class="snb_my">
		<h2 class="tit_snb">마이비건</h2>
		<div class="inner_sub">
			<ul class="list_menu">
				<li id="orderList"><a href="<%=contextPath%>/myOrderList.do">주문 내역</a></li>
				<li id="review"><a href="#">상품 후기</a></li>
				<li id="qna"><a href="#">상품 문의</a></li>
				<li id="update"><a href="<%=contextPath%>/myPwdCheck.do">개인 정보 수정</a></li>
			</ul>
		</div>
</div>

<script>
$(function(){
	var url=window.location.href; //현재페이지값
	if(url.indexOf('rder')>0){ //현재페이지에 rder 단어가 있으면 여기에 on을 줌
		console.log(url)
		$('.list_menu>li').removeClass('on');
		$('#orderList').addClass('on');
	}
	if(url.indexOf('review')>0){
		$('.list_menu>li').removeClass('on');
		$('#review').addClass('on');
	}
	if(url.indexOf('qna')>0){
		$('.list_menu>li').removeClass('on');
		$('#qna').addClass('on');
	}
	if(url.indexOf('PwdCheck')>0 || url.indexOf('UpdateForm')>0){
		$('.list_menu>li').removeClass('on');
		$('#update').addClass('on');
	}
})		
</script>