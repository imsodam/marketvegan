<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/member/css/idCompletion.css">

<c:if test="${user.user_id ne null}">

<div id="content">
	<div class="section_login">
		<div class="tit_login">
			고객님의 마켓비건 계정을 찾았습니다.
			<div class="tit_login2">
				아이디 확인 후 로그인해주세요.
			</div>
		</div>
		<ul class="complete_form">
			<li class="complete">
				<img class="ico_complete" src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNDAiIGhlaWdodD0iNDAiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CiAgICA8ZyBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxjaXJjbGUgZmlsbD0iI0Y1RjVGNSIgY3g9IjIwIiBjeT0iMjAiIHI9IjIwIi8+CiAgICAgICAgPHBhdGggZD0iTTIwIDE5YzQuNjUzIDAgOC41IDMuNDc2IDguNSA3LjcyIDAgLjQzLS4zNDYuNzgtLjc3My43OEgxMi4yNzNhLjc3Ni43NzYgMCAwIDEtLjc3My0uNzhjMC00LjI4NSAzLjgyNC03LjcyIDguNS03Ljcyem0wLTguNWEzLjQgMy40IDAgMSAxIDAgNi44IDMuNCAzLjQgMCAwIDEgMC02Ljh6IiBzdHJva2U9IiNDQ0MiIGZpbGw9IiNDQ0MiLz4KICAgIDwvZz4KPC9zdmc+Cg=="
					 alt="정보보기">
				<div class="user_id_complete">
					<div class="id_complete">${user.user_id}</div>
				</div>
			</li>
		</ul>
		<div class="write_form">
			<a class="btn_type1 btn_member" onclick="" href="<%=contextPath%>/pwdSearch.do"> 
				<span class="txt_type">비밀번호 찾기</span>
			</a> 
			<a class="btn_type2 btn_member" onclick="" href="<%=contextPath%>/login.do"> 
				<span class="txt_type">로그인</span>
			</a>
		</div>
	</div>
</div>
</c:if>
<c:if test="${user.user_id eq null}">
	<script>
		alert("해당하는 정보가 없습니다.");
		history.back();
	</script>
</c:if>