<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="../resources/admin/product/css/product_style.css">

<c:if test="${product.product_code eq null }">
 	<c:set var="product_code" value="0" />
 	<c:set var="str" value="등록" />
</c:if>
<c:if test="${product.product_code ne null }">
 	<c:set var="product_code" value="${product.product_code}" />
 	<c:set var="str" value="수정" />
</c:if>



<table class="product_tb">
  <tr>
	<td>
   		<form name="productForm" id="productForm" method="post" enctype="multipart/form-data" action="<%=contextPath%>/admin/insertProduct.do">
    	<input type="hidden" name="product_code" value="${product_code}">
    	<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>   
				<td class="item_res">상품${str} </td>
		   </tr>
    	</table>
   
   <table>
     <tr>
      	<td class="item_res2">노출여부  </td>
      	<td>
	      	<input type="radio" name="product_is_show" value='y' checked>노출
			<input type="radio" name="product_is_show" value='n'>미노출
		</td>
     </tr>
   	<tr>
      <td class="item_res2">상품명 </td>
      <td><input type="text" name="product_name" value="${product.product_name}" id="product_name"></td>
     </tr>
    <tr>
	<tr>
      <td class="item_res2">상품설명  </td>
      <td><input type="text" name="product_content" value="${product.product_content}" id="product_content"></td>
     </tr>
    <tr>
      <td class="item_res2">상품가격 </td>
      <td><input type="text" name="product_price" value="${product.product_price}" id="product_price" numberOnly></td>
     </tr>
     <tr>
      <td class="item_res2">배송비 </td>
      <td> 
		<input type="radio" name="product_delivery_charge" value='2500' checked>2,500
		<input type="radio" name="product_delivery_charge" value='0'>0
      </td>
     </tr>
    <tr>
      <td class="item_res2">할인율 </td>
      <td> 
      	<input type="text" name="product_discount" value="${product.product_discount}" id="product_discount" numberOnly>
      </td>
     </tr>
     <tr>
      <td class="item_res2">이미지1 </td>
      <td> 
      	<input type="file" multiple="multiple" name="upload" id="product_img1">${product.product_img1} 
      </td>
     </tr>
     <tr>
      <td class="item_res2">이미지2 </td>
      <td> 
      	<input type="file" multiple="multiple" name="upload" id="product_img2">${product.product_img2}
      </td>
     </tr>
     <tr>
      <td class="item_res2">이미지3 </td>
      <td> 
      	<input type="file" multiple="multiple" name="upload"  id="product_img3">${product.product_img3}
      </td>
     </tr>
     <tr>
      <td class="item_res2">이미지4 </td>
      <td> 
      	<input type="file" multiple="multiple" name="upload" id="product_img4">${product.product_img4}
      </td>
     </tr>
      <tr>
      <td class="item_res2">카테고리 코드 </td>
      <td> 
      	<select name="category_code" id="category_code">
      		<c:forEach var="category" items="${ categoryList}">
				<option value="${category.category_code}">${category.category_name}</option>
			</c:forEach>
		</select>
      </td>
     </tr>
     
     <tr align="center">
      <td class="item_res3" colspan="2">
      	<input type="button" value="${str}" onClick="productSubmit();">
       <%-- <input type="button"  value="취소" onClick="location.href='<%=contextPath%>/admin/itemList.do'"> --%>
     	<input type="button"  value="취소" onClick="history.back();">
       </td>
     </tr>
    </table>
     </form>
   </td>
  </tr>
 </table>
</body> 
</html>

<script>
/*  노출여부 */
$('input[name=product_is_show][value=${product.product_is_show}]').attr('checked', true);
/* 카테고리코드 기본선택*/
$('#category_code').val('${product.category_code}')
/* 배송비 기본선택 */
$('input:radio[name="product_delivery_charge"]:input[value="${product.product_delivery_charge}"]').prop('checked',true);

</script>
<script src="../resources/admin/product/js/product.js"></script>

