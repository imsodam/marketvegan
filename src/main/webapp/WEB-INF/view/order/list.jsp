<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap,com.util.GetDate"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	GetDate gd=new GetDate();
	HashMap map=gd.getDate();
	String today=(String) map.get("today");
	String yearAgo=(String) map.get("yearAgo");
%>
<%
	String contextPath = request.getContextPath();
%>

<link rel="stylesheet" href="./resources/order/css/order_style.css">

							
<div class="order_container">
	<div class="order_list_page">
		<div class="title">
			<div>주문 내역</div>
			<!-- <div>지난 3년간의 주문 내역 조회가 가능합니다.</div> -->
			<div>
				
				<form name="dateForm"  id="dateForm" action="<%=contextPath%>/myOrderList.do">
					<input type="date" name="sDay"  id="sDay" value="<%=yearAgo%>"> ~
					<input type="date" name="eDay"  id="eDay" value="<%=today%>">
					<input type="button" id="dateSearch" value="조회">
				</form>
			</div>
		</div >
		<c:if test="${pgList.count==0 }">
			<div class="no_cart">주문내역이 없습니다.</div>
		</c:if>
		<ul class="order_list">
		<c:forEach var="orders" items="${orderList}">
			<li>
				<div>
					<div>
						<span class="order_date"><fmt:formatDate value="${orders.order_date}" type="both" pattern="yyyy.MM.dd (HH:mm)"/></span><br>
						${orders.order_product_name} 
						<c:if test="${orders.order_product_count>1}">
							외 ${orders.order_product_count-1} 건
						</c:if>
					</div>
					<div class="detail_bt">
						<a href="<%=contextPath%>/orderDetail.do?order_num=${orders.order_num}&pageNum=${pageNum}&sDay=${sDay}&eDay=${eDay}" 
							class="bt bt_greenline bt_block">상세보기</a>
					</div>
				</div>
				<div>
					<table class="order_list_tb">
						<tr>
							<td rowspan="3"><img src="./resources/admin/product/upload/${orders.order_product_img1}" alt="${orders.order_product_name}"></td>
							<th>주문번호</th>
							<td>${orders.order_num}</td>
						</tr>
						<tr>
							<th>결제금액</th>
							<td><fmt:formatNumber value="${orders.order_price+orders.order_delivery_charge}" pattern="#,##0" />원</td>
						</tr>
						<tr>
							<c:set var="codeName" />
							<th>주문상태</th>
							<td>${orders.order_state_name}</td>
						</tr>
					</table>
				</div>
			</li>
		</c:forEach>
		</ul>
    	<!-- 페이징처리 -->
		<div class="page_box">
			${pagingHtml } 
		</div>
	</div>
	
</div>
<script src="./resources/order/js/order.js"></script>
<c:if test="${!empty sDay}">
	<script>
		$('#sDay').val('${sDay}')
		$('#eDay').val('${eDay}')
	</script>
</c:if>