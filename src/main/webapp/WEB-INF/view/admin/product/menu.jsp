<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet"
	href="../resources/admin/product/css/product_style.css">


<%-- <div class="goods_list_item">
        <div class="goods_list_item_tit">
       	 	<c:if test="${page ne 'discount' }" >
            <h2 class="category">${category_name}</h2>
            </c:if>
        </div>
     </div>  --%>

<%-- 
<div class="slideMenu">
	<ul>
		<li><a
			class="link1 <c:if test="${category_code eq null || category_code eq '' }">current</c:if>"
			href="<%=contextPath%>/admin/itemList.do">전체 </a></li>
		<li><a
			class="link2 <c:if test="${category_code eq 'meat'}">current</c:if>"
			href="<%=contextPath%>/admin/itemList.do?category_code=meat">정육 </a></li>
		<li><a
			class="link3 <c:if test="${category_code eq 'milk'}">current</c:if>"
			href="<%=contextPath%>/admin/itemList.do?category_code=milk">유제품 </a></li>
		<li><a
			class="link4 <c:if test="${category_code eq 'bakery'}">current</c:if>"
			href="<%=contextPath%>/admin/itemList.do?category_code=bakery">베이커리 </a></li>
		<li><a
			class="link5 <c:if test="${category_code eq 'other'}">current</c:if>"
			href="<%=contextPath%>/admin/itemList.do?category_code=other">기타 </a></li>
	</ul>
</div>
--%>
<h2 class="title">상품 목록</h2>
<div class="search_box">
	<form name="searchForm"  id="searchForm" method="get" action="<%=contextPath%>/admin/itemList.do">
		<div>
			<div>
				상품명 : 
				<input type="text" name="keyWord" id="keyWord">
			</div>
			<div>
				카테고리 : 
				<select name="category_code" id="category_code">
					<option value="">전체</option>
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.category_code}">${category.category_name}</option>
					</c:forEach>
				</select>
				<input type="submit" id="listSearch" value="검색">
			</div>
		</div>
	</form>
	<div class="total_count"><< 총 ${count}개 >></div>
</div>

<%-- <div id="side_search" class="gnb_search">
	<form id="searchForm" action="<%=contextPath%>/admin/itemList.do">
		<input name="keyWord" type="text" id="keyWord" value=""
			required="required" label="검색어" placeholder="" class="inp_search">
		<input type="image" src="../resources/img/logo/search2.webp"
			class="btn_search" onclick="search()">
	</form>
</div> --%>



<table class="list_tb">
	<tr>
		<th>선택 </th>
		<th>상품번호 </th>
		<th>이미지  </th>
		<th>상품명 </th>
		<th>가격 </th>
		<th>삭제 </th>
	</tr>

<c:forEach var="product" items="${productList}">
<tr >
		<td><input type="checkbox" name="buy" value="260" checked=""
					onclick="javascript:basket.checkItem();">&nbsp;</td>
		<td><a href="<%=contextPath%>/admin/getProduct.do?product_code=${product.product_code}">${product.product_code}</a></td>
		<td><img src="../resources/admin/product/upload/${product.product_img1}" width="60"></td>
		<td>${product.product_name}</td>
		<td>
			<input type="hidden" name="p_price" id="p_price1" class="p_price"
			value="20000"><fmt:formatNumber value="${product.product_price}" pattern="#,##0" />원
		</td>
		<td><a id="${product.product_code}" href="javascript:void(0)"
					class="abutton" onclick="deleteProduct(this.id);">삭제</a></td>
		
	</tr>		
</c:forEach>
</table>

<div class="right-align basketrowcmd">
	<!-- <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delCheckedItem();">선택상품삭제</a> -->
	<a
		href="<%=contextPath%>/admin/getProduct.do"
		class="abutton">상품등록 </a>
</div>

<!-- 페이징처리 -->
<div class="page_box">
	${pagingHtml } 
</div>

<script src="../resources/admin/product/js/product.js"></script>
<script>
/* 상품 삭제  */
function deleteProduct(product_code){
	if(confirm("삭제하시겠습니까?")){
		//alert(product_code);
		location.href="<%=contextPath%>/admin/deleteProduct.do?product_code="+product_code;
	}else{
		return false;
	}
} 
</script>

<script>
function search(){
	$('#searchForm').submit();
}
	
<c:if test="${!empty keyWord}">
	$('#keyWord').val('${keyWord}')
</c:if>
<c:if test="${!empty category_code}">
	$('#category_code').val('${category_code}')
</c:if>
</script>