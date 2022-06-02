<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   

<c:if test="${sessionScope.adminIdKey ne null}">
	<h3 class="main_contant">로그인 되었습니다. 관리자 페이지를 이용할 수 있습니다.</h3>
</c:if>
<c:if test="${sessionScope.adminIdKey eq null}">
	<h3 class="main_contant">로그인 후 관리자 페이지를 이용할 수 있습니다.</h3>
</c:if>
