<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!check}">
   <script>
      alert("비밀번호가 틀립니다.")
      history.back();
   </script>
</c:if>
<c:if test="${sessionScope.idKey eq null}">
	<meta http-equiv="Refresh" content="0;url=/marketvegan2/login.do">
</c:if>
<c:if test="${sessionScope.idKey ne null}">
<link rel="stylesheet" href="./resources/member/css/mypage.css">

<!-- mypage -->
<div id="myPageTop" class="page_aticle mypage_top">
	<div class="mypagetop_user">
		<div class="inner_mypagetop">
			<div class="grade_user">
				<div class="grade_wrap">
					<strong class="name">${user.user_name}님</strong>
				</div>
				<div class="grade_wrap2">
					<strong class="tit">마이페이지 입니다.</strong>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 마이비건 -->
<div class="page_aticle mypage">
	<jsp:include page="/WEB-INF/view/member/leftmenu.jsp" flush="false" />
	<jsp:include page="/WEB-INF/view/member/updateForm.jsp" flush="false" />
</div>
</c:if>


