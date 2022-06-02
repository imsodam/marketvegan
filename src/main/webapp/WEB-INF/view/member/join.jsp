<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/member/css/join.css">
<script type=text/javascript src="./resources/member/js/join.js"></script>
<script src="./resources/js/findAddr.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<div id="join_page">
	<div class="join_sub">
		<h2 class="join">회원가입</h2>
	</div>
	<div id="join_main">
		<p class="page_sub">
			<span class="ico">*</span> 필수입력사항
		</p>

		<form name="joinForm" id="joinForm" method="post"
			action="<%=contextPath%>/join.do">

			<table id="tbl_comm">

				<!-- 아이디 -->
				<tr class="fst">
					<th>아이디 <span class="ico">* <span class="screen_out">필수항목</span>
					</span>
					</th>
					<td><input type="text" name="user_id" id="user_id" value
						maxlength="16" label="아이디" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합">
						<input type="hidden" name="chk_id" label="아이디중복체크"> <a
						class="btn default" href="javascript:void(0)" id="chk_id">중복확인</a>

						<p class="txt_guide square">
							<span id="check_id" class=""> </span> <span id="check_id2"
								class=""> </span>
						</p></td>
				</tr>

				<!-- 비밀번호 -->
				<tr>
					<th>비밀번호 <span class="ico">* <span class="screen_out">필수항목</span>
					</span>
					</th>
					<td><input class="reg_pw" type="password" name="user_pwd"
						id="user_pwd" maxlength="16" label="비밀번호"
						placeholder="비밀번호를 입력해주세요">

						<p class="txt_guide square">
							<span id="check_pwd" class=""> </span>
						</p></td>
				</tr>

				<!-- 비밀번호확인 -->
				<tr>
					<th>비밀번호확인 <span class="ico">* <span class="screen_out">필수항목</span>
					</span>
					</th>
					<td><input class="confirm_pw" type="password"
						name="user_repwd" id="user_repwd" maxlength="16" label="비밀번호"
						placeholder="비밀번호를 한번 더 입력해주세요">

						<p class="txt_guide square">
							<span id="check_repwd" class=""> </span>
						</p></td>
				</tr>

				<!-- 이름 -->
				<tr>
					<th>이름 <span class="ico">* <span class="screen_out">필수항목</span>
					</span>
					</th>
					<td><input type="text" name="user_name" id="user_name"
						label="이름" placeholder="이름을 입력해주세요">
						<p class="txt_guide square">
							<span id="check_username" class=""> </span>
						</p></td>
				</tr>

				<!-- 이메일 -->
				<tr>
					<th>이메일 <span class="ico">* <span class="screen_out">필수항목</span>
					</span>
					</th>
					<td><input type="text" name="user_email" id="user_email" value
						data-email size="30" label="이메일"
						placeholder="예: marketvegan@began.com"> <input
						type="hidden" name="chk_email" label="이메일 중복체크"> <a
						class="btn default" href="javascript:void(0)" id="chk_email">중복확인</a>

						<p class="txt_guide square">
							<span id="check_email" class=""> </span> <span id="check_email2"
								class=""> </span>
						</p></td>
				</tr>

				<!-- 휴대폰 -->
				<tr>
					<th>휴대폰 <span class="ico">* <span class="screen_out">필수항목</span>
					</span>
					</th>
					<td><input type="text" name="user_phone" id="user_phone"
						label="휴대폰" placeholder="숫자만 입력해주세요">
						<p class="txt_guide square">
							<span id="check_phone" class=""> </span>
						</p></td>
				</tr>

				<!-- 주소 -->
				<tr>
					<th>주소 <span class="ico">* <span class="screen_out">필수항목</span>
					</span>
					</th>
					<td class="field_address"><input type="text" name="user_zipcode"
						id="zipcode" label="우편번호"> <a href="javascript:void(0)"
						onclick="findAddr()" id="addressSearch" class="btn default"> <i
							class="fas fa-search"> 주소검색 </i></a>
						<div id="selectAddress">
							<input type="text" name="user_addr1" id="addr1" label="주소">
						</div>
						<div id="selectAddressSub">
							<input type="text" name="user_addr2" id="addr2" label="상세주소">
						</div></td>
				</tr>

				</tbody>
			</table>

			<!-- 가입버튼 -->
			<div id="formSubmit" class="form_footer">
				<button type="button" class="btn_join" id="btn_join">가입하기</button>
				<button type="button" onclick="join_cancel()" class="cancel">취소</button>
			</div>

		</form>
	</div>

</div>
