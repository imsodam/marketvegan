<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/member/css/updatepwd.css">
<script type=text/javascript src="./resources/member/js/updatepwd.js"></script>

<div class="order_container">
	<div class="order_list_page">
		<div class="title">
			<div class="title_sub2">개인 정보 수정</div>
			<div>비밀번호 재확인</div>
			<div class="title_sub">회원님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인해주세요.</div>
		</div>
		<form name="form" method="post" action="<%=contextPath%>/myUpdateForm.do">
		<table id="tbl_comm">
		
				<!-- 아이디 -->
				<tr class="fst">
					<th>아이디 </th>
					<td>
						<input type="text" name="user_id" id="user_id" value="${user.user_id}" readonly>
					</td>
				</tr>

				<!-- 비밀번호 -->
				<tr>
					<th>
						비밀번호 
					</th>
					<td>
						<input class="reg_pw" type="password" name="user_pwd" id="user_pwd">
					</td>
				</tr>
				
		</table>
		</form>
		
		<!-- 확인 -->
		<div id="formSubmit" class="formSubmit">
			<button type="submit" class="btn_pwd" id="btn_pwd" onclick="pwdCheck()">확인</button>
		</div>
		
		
	</div>
</div>