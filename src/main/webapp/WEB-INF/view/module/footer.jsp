<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<footer id="footerArea">
	<div class="footer_inner">
		<img class="footer_logo" src="./resources/img/logo/logo2.png" alt="로고">
	       <div class="footer_menu">
	       		<ul>
	                <li><a href="<%=contextPath%>/info.do?page=terms">이용약관</a></li>
	                <li><a href="<%=contextPath%>/info.do?page=privacy">개인정보처리방침</a></li>
	                <li class="last"><a href="<%=contextPath%>/info.do?page=guide">이용안내</a></li>
	            </ul>
	 
	            <div class="addr_detail">
	                <span class="addr">서울특별시 강남구 역삼동<span class="addr_bar">ㅣ</span>Tel : 070-7011-3131<span class="addr_bar">ㅣ</span>E-mail : info@marketvegan.kr
	            </div>
	
	            <p>Copyright &copy; Market Vegan. All rights reserved.</p>
            </div>
	</div>
</footer>