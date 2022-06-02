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
<link rel="stylesheet" href="../resources/admin/order/css/order_style.css">
 
<h2 class="title">결제 목록</h2>
<div class="search_box">
	<form name="searchForm"  id="searchForm" method="post" action="<%=contextPath%>/admin/payList.do">
		<div>
			<input type="hidden" name="page" value="admin">
			<input type="date" name="sDay"  id="sDay" value="<%=yearAgo%>"> ~
			<input type="date" name="eDay"  id="eDay" value="<%=today%>">
			<select name="payment_type" id="payment_type">
					<option value="all">전체</option>
				<c:forEach var="payType" items="${payTypeList }">	
					<option value="${payType.code}">${payType.code_name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<select name="keyField" id="keyField">
				<option value="order_num">주문번호</option>
				<option value="user_id">아이디</option>
				<option value="user_name">주문자명</option>
				<option value="user_phone">휴대폰</option>
				<option value="user_email">이메일</option>
			</select>
			<input type="text" name="keyWord" id="keyWord">
			<input type="button" id="listSearch" value="검색">
		</div>
	</form>
	<div class="total_count"><< 총 ${count}건 >></div>
</div>
<c:if test="${count==0 }">
	<div class="no_cart">결제내역이 없습니다.</div>
</c:if>
<c:if test="${count>0 }">


<table class="list_tb">
	<tr>
		<th>결제일</th>
		<th>주문번호</th>
		<th>주문상태</th>
		<th>결제금액</th>
		<th>결제수단</th>
		<th>아이디</th>
		<th>이름</th>
		<th>휴대폰</th>
		<th>이메일</th>
	</tr>
	<c:forEach var="pay" items="${payList}">
	<tr>
		<td><fmt:formatDate value="${pay.payment_date}" type="both" pattern="yyyy.MM.dd (HH:mm)"/></td>
		<td>${pay.order_num}</td>
		<td>${pay.order_state_name}</td>
		<td class="price"><fmt:formatNumber value="${pay.payment_price}" pattern="#,##0" /></td>
		<td>${pay.payment_name}</td>
		<td>${pay.user_id}</td>
		<td>${pay.user_name}</td>
		<td>${pay.user_phone}</td>
		<td>${pay.user_email}</td>
	</tr>
	</c:forEach>
</table>

<!-- 페이징처리 -->
		<div class="page_box">
			${pagingHtml } 
		</div>
 </c:if> 
<script src="../resources/admin/order/js/order.js"></script>
<script>
<c:if test="${!empty sDay}">
		$('#sDay').val('${sDay}')
		$('#eDay').val('${eDay}')
</c:if>
<c:if test="${!empty keyField}">
		$('#keyField').val('${keyField}')
</c:if>
<c:if test="${!empty keyWord}">
		$('#keyWord').val('${keyWord}')
</c:if>
<c:if test="${!empty payment_type}">
		$('#payment_type').val('${payment_type}')
</c:if>
</script>
