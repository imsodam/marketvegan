<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/product/css/sub3.css">
<script src="./resources/js/jquery-3.4.1.min.js"></script>

<div class="product_view">
	<h2>${product.product_name}</h2>            
   		<table>
         	<caption>
              <details class="hidden">
              	<summary>상품정보</summary>
                  판매가, 상품코드, 옵션 및 결제금액안내
             </details>
           </caption>
                
        	<tbody>
	            <tr>
	                <th>판매가</th>
	                <td class="price"><fmt:formatNumber value="${product.product_price}" pattern="#,##0" />원</td>
	            </tr>
	            
	            <tr>
	                <th>구매수량</th>
	                <td>
	                	<div class="qty"> 
	                		<div class="plus">
	                			<a href="javascript:change_qty2('p')">
	                			<img src="./resources/product/img/up.png" alt="+"></a>
	               			</div> 
	               				<input type="hidden" id="basic_amount" value=${product.product_price}>
	               				<input type="text" name="ct_qty" id="ct_qty" value="1" readonly="readonly"> 
	             			<div class="minus">
	             				<a href="javascript:change_qty2('m')">
	             				<img src="./resources/product/img/down.png" alt="-"></a>
	            			</div> 
	            		</div>
	                </td>
	            </tr>
	            
	            <tr>
                	<th>배송비</th>
                		<td>
               				<c:if test="${product.product_delivery_charge==0}">
               					무료배송 
               				</c:if>
              				<c:if test="${product.product_delivery_charge>0}">
               				<fmt:formatNumber value="${product.product_delivery_charge}" pattern="#,##0" />원 
               				</c:if>
               			</td>
          		</tr>
            
            	<tr>
                	<th>총 상품금액</th>
                		<td><span id="total_amount"><fmt:formatNumber value="${product.product_price}" pattern="#,##0" /></span>원 </td> 
            	</tr>
        </tbody>
    </table>
    
    <div class="img">
    	<div class="bigimg">
        	<img src="./resources/admin/product/upload/${product.product_img1}" alt="${product.product_name}" id="display">
        </div>
        	<ul class="thumb">
	            <li><img class="thumb_img on" src="./resources/admin/product/upload/${product.product_img1}" ></li>
	            <li><img class="thumb_img" src="./resources/admin/product/upload/${product.product_img2}" ></li>
				<li><img class="thumb_img" src="./resources/admin/product/upload/${product.product_img3}" ></li>
        	</ul>
   	</div> 
    
    <script>    
        $('.thumb_img').click(function(){
            var src = $(this).attr('src');
            $('#display').attr('src',src);

            $('.thumb_img').removeClass('on');
            $(this).addClass('on');
        });
	</script>
    
    <div class="btns">
        <a href="javascript:go_cart('${product.product_code}')">장바구니 담기</a>
    </div>
</div>

<div class="tabs">
    <input id="all" type="radio" name="tab_item" checked>
    <label class="tab_item" for="all">상품설명</label>
    <input id="programming" type="radio" name="tab_item">
    <label class="tab_item" for="programming">상세정보</label>
    <input id="design" type="radio" name="tab_item">
    <label class="tab_item" for="design">후기</label>
    <input id="ask" type="radio" name="tab_item">
    <label class="tab_item" for="ask">문의</label>
    
    <div class="tab_content" id="all_content">
    	<div class="good_point">
    		<h3>MarketVegan's Check Point</h3>
    	
        	<div class="context last">
				<div class="pic">
					<img src="./resources/admin/product/upload/info4.webp" alt="상품설명1">
				</div>
				<div class="pic2">
					<img src="./resources/admin/product/upload/info3.png" alt="상품설명2">
				</div>
			</div>
    	</div>
   	</div>
   	
    <div class="tab_content2" id="programming_content">
        	<div class="context last">
				<div class="pic">
					<img src="./resources/admin/product/upload/${product.product_img4}" alt="상품설명3">
				</div>
			</div>
	</div>
    <div class="tab_content3" id="design_content">후기</div>
	<div class="tab_content4" id="ask_content">문의</div>	

<script src="./resources/product/js/product.js"></script>
<script>
//장바구니 담기
var popX= (document.body.offsetWidth / 2) - (400 / 2);
var popY= (window.screen.height / 2) - (150 / 2);
popX += window.screenLeft;
function go_cart(product_code){
	<c:if test="${sessionScope.idKey eq null}">
		alert("로그인후 이용가능합니다.");
		location.href="<%=contextPath%>/login.do";
	</c:if>

	<c:if test="${sessionScope.idKey ne null}">
		var count=$('#ct_qty').val();
		window.open("<%=contextPath%>/goCart.do?product_code="+product_code+"&count="+count,"go_cart","top="+popY+",left="+popX+",width=400,height=150");
	</c:if>
}

</script>