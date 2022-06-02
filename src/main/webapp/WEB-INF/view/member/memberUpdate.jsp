<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check}">
	<script>
		alert("회원정보 수정을 성공했습니다.");
		location.href="/marketvegan/orderList.do?page=mypage";
	</script>
</c:if>
<c:if test="${check}">
	<script>
		alert("회원정보 수정을 실패했습니다.");
		history.back();
	</script>
</c:if>