<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/member/css/join2.css">
<div id="content">
	<div class="section_login">
		<h3 class="tit_login">회원가입완료</h3>
		<div class="write_form">
			<div class="complete">
				<div class="ico_complete">
				<i class="fas fa-user-check"></i>
					환영합니다!
					<small>회원가입이 완료 되었습니다!</small>
				</div>
			</div>
			<a class="btn_type1 btn_member" onclick="" href="<%=contextPath%>/login.do"> 
				<span class="txt_type">로그인</span>
			</a> 
			<a class="btn_type2 btn_member" onclick="" href="<%=contextPath%>/"> 
				<span class="txt_type">홈</span>
			</a>
		</div>
	</div>
</div>