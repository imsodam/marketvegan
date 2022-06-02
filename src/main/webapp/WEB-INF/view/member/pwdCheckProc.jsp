<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%System.out.println("updatePass.jsp의 request_url=>"+request.getParameter("request_url")); %>

<c:if test="${check==true}">
	<c:set var="idKey" value="${user_id}" scope="session" />
	<c:set var="nameKey" value="${user.user_name}" scope="session" />
	<c:set var="url" value="${param.request_url}" />
	<c:if test="${param.request_url.contains('mypage.do') }">
		<c:set var="url" value="${param.request_url}${sessionScope.idKey}" />
	</c:if>
	<script>
		location.href="${url}";
	</script>
</c:if>
<c:if test="${check==false}">
	<script>
		alert("아이디 또는 비밀번호가 틀립니다. 다시 입력해주세요");
		history.go(-1);
	</script>
</c:if>