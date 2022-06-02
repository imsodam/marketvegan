<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

    String user_id=(String)session.getAttribute("idKey");
    System.out.println("login.jsp의 user_id=>"+user_id);
%>
<link rel="stylesheet" href="./resources/member/css/login.css">
<script type=text/javascript src="./resources/member/js/login.js"></script>


<div id="content">
	<div class="section_login">
		<h3 class="tit_login">로그인</h3>

		<div class="write_form">
			<div class="write_view login_view">
				<form method="post" name="form" id="form" method="post"
					action="<%=contextPath%>/login.do">
					<input type="hidden" name="request_url" value="<%=request.getHeader("referer") %>">

					<input type="text" name="user_id" id="user_id" size="20" tabindex="1"
						value placeholder="아이디를 입력해주세요"> 
					<input type="password" name="user_pwd" id="user_pwd" size="20" tabindex="2" placeholder="비밀번호를 입력해주세요">
					<div class="checkbox_save">
						<div class="login_search">
							<a class="link"
								href="<%=contextPath%>/idSearch.do">아이디 찾기</a> 
							<span class="bar"></span> 
							<a class="link" 
							   href="<%=contextPath%>/pwdSearch.do">비밀번호 찾기</a>
						</div>
					</div>
					<a class="btn_type1" id="btn_type1" href="javascript:void(0)" onclick="loginCheck()">
					<span class="txt_type">로그인</span>
					</a>

				</form>
				<a class="btn_type2 btn_member"
					href="<%=contextPath%>/agree.do">
					<span class="txt_type">회원가입</span>
				</a>
			</div>
		</div>
	</div>
</div>