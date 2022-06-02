<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
    
<c:if test="${check}">
	<script>
		alert("회원정보 수정을 성공했습니다.");
		location.href="<%=contextPath%>/myOrderList.do";
	</script>
</c:if>
<c:if test="${!check}">
	<script>
		alert("회원정보 수정을 실패했습니다.");
		history.back();
	</script>
</c:if>