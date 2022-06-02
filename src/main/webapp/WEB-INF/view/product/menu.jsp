<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/product/css/sub1.css">

<div>
	<div id="content">
				
                <div class="goods_list_item">
                   	 	 <c:if test="${page eq 'discount'}" >
                        <h2 class="category">비건특가</h2>
                        </c:if>  
                         <c:if test="${page eq 'best'}" >
                        <h2 class="category">베스트 </h2>
                        </c:if>  
                    </div>
                 </div> 
                 
                <div class="content_area">
                <c:if test="${page ne 'discount' && page ne 'best'}" >
                	<div class="slideMenu">
                        <ul>
                        	<li><a class="<c:if test="${category_code eq null || category_code eq '' }">current</c:if>" href="<%=contextPath%>/itemList.do">전체 </a></li>
			                <c:forEach var="category" items="${categoryList }">
			          	 		<li>
                        			<a class="<c:if test="${category_code eq category.category_code}">current</c:if>" href="<%=contextPath%>/itemList.do?category_code=${category.category_code}">${category.category_name} </a>
                        		</li>
			                </c:forEach>
                        </ul>
                      </div>
                     </c:if>
                      <div class="operate">
                      		<div class="boxMove1">
                      		<c:forEach var="product" items="${productList}">
                      		<ul class="items">
                      			<li><a href="<%=contextPath%>/showItem.do?product_code=${product.product_code }"><img src="./resources/admin/product/upload/${product.product_img1}"></a></li>
                            	<li class="a">${product.product_name}</li>
                            	<li class="b"><fmt:formatNumber value="${product.product_price}" pattern="#,##0" />원 &nbsp;&nbsp;<span>${product.product_discount}%</span></li>
                            	<li class="c">${product.product_content}</li>
                      		</ul>
                      		</c:forEach>
                      	</div>
                      	
                          	<!-- 페이징처리 -->
						<div class="page_box">
                     	${pagingHtml } 
							
						</div>
                     	
                     	
       				<div id="topButton"> 
        					<img src="./resources/product/img/top.webp" id="topButtonImg">
        			</div>  
								     
			</div>
		</div>
	</div>
</div>

<script src="./resources/product/js/product.js"></script>
