<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
 <div id="container">
            <div id="header">
                <div id="userMenu">
                    <ul class="list_menu">
                        <c:if test="${not empty sessionScope.idKey}">
                    	<li>${sessionScope.nameKey}님</li>
                   		</c:if>
                       	<c:if test="${empty sessionScope.idKey}">
                        <li class="menu none_sub menu_join">
                       	 	<a href="<%=contextPath%>/agree.do" class="link_menu">Join</a>
                        </li> 
                        </c:if>
                        <li class="menu none_sub menu_login">
                        	<c:if test="${empty sessionScope.idKey}">
                        		<a href="<%=contextPath%>/login.do" class="link_menu">Login</a>
                        	</c:if> 
                        	<c:if test="${not empty sessionScope.idKey}">
                        		<a href="<%=contextPath%>/logout.do" class="link_menu">Logout</a>
                        	</c:if> 
                        </li> 
                        
                        <li class="menu lst"><a href="<%=contextPath%>/myOrderList.do" class="link_menu">Mypage</a></li>
                        
                        <li class="menu lst"><a href="<%=contextPath%>/listNotice.do" >CS Center</a></li>
                    </ul>  
                </div>
            </div>

            <div id="headerLogo" class="layout-wrapper">
                <h1 class="logo">
	                <a href="/marketvegan2/">
	                	<img src="./resources/img/logo/logo2.png" alt="마켓비건">
	               	</a>
                </h1>
            </div>
            <div id="gnb">
				<div class="nav_area"></div>
                <div class="fixed_container">
                    <div id="gnbMenu" class="gnb_kurly">
                        <div class="inner_gnbkurly">
                            <div class="gnb_main">
                                <ul class="gnb">
                                    <li class="menu1"><a href="<%=contextPath%>/itemList.do" class=""><span class="ico"></span><span class="txt">비건메뉴</span></a>
	                    			</li>
	                    
                                    <li class="menu2"><a href="<%=contextPath%>/info.do?page=vegan" class="link new"><span class="txt">비건소개</span></a>
	                    			</li>	

                                    <li class="menu3"><a href="<%=contextPath%>/itemList.do?page=discount" class="link best"><span class="txt">비건특가</span></a>
	                    			</li>

                                    <li class="menu4"><a href="<%=contextPath%>/itemList.do?page=best" class="link bargain"><span class="txt">베스트</span></a>
	                    			</li>

                                    <li class="lst"><a href="<%=contextPath%>/listMagazine.do" class="link event"><span class="txt">매거진</span></a>
	                    			</li>
                                </ul>

                                <div id="side_search" class="gnb_search">
                                    <form id="searchForm" action="<%=contextPath%>/itemList.do">
                                        <input name="keyWord" type="text" id="keyWord" value="" placeholder="검색어를 입력해주세요." class="inp_search"> 
                                        <input type="image" src="./resources/img/logo/search2.webp" class="btn_search" onclick="search()"> 
                                    </form>
                            	</div>
								
	                            <div class="cart_count">
	                                <div class="inner_cartcount">
	                                    <a href="<%=contextPath%>/cartList.do" class="btn_cart">
	                                    	<img src="./resources/img/logo/cart.png" alt="장바구니" class="thumb">
	                                    </a>
	                                </div>
	                            </div>
                        	</div>
                    </div>
                </div>
            </div>
        </div>
<script>

//검색폼 submit
function search(){
	$('#searchForm').submit();
}
//키워드 검색시 input 창 입력
<c:if test="${!empty keyWord}">
		$('#keyWord').val('${keyWord}')
</c:if>

//네비상단고정
$( document ).ready( function() {
	var nav_off = $('.fixed_container').offset()
	
	window.addEventListener('scroll',function(){

		if (this.scrollY > nav_off.top){
			$('.fixed_container').addClass('nav_fix');
			$('.nav_area').addClass('nav_area_fix');
		}else{
			$('.fixed_container').removeClass('nav_fix');
			$('.nav_area').removeClass('nav_area_fix');
		}
	})
});

</script>

