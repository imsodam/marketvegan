<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	String contextPath = request.getContextPath();
%>
<%
	String DIRECTORY=(String)request.getAttribute("DIRECTORY");
	String CONTENT=(String)request.getAttribute("CONTENT");
	if (DIRECTORY==null) DIRECTORY="view";
	if (CONTENT==null) CONTENT="main";
	//System.out.println("template.jsp의 DIRECTORY=>"+DIRECTORY+", CONTENT=>"+CONTENT);
	
	String content="/WEB-INF/view/admin/"+DIRECTORY+"/"+CONTENT+".jsp";
	//System.out.println("content=>"+content);


%>
<% if(!CONTENT.equals("loginForm") && !CONTENT.equals("main")){ 
%>
<c:if test="${sessionScope.adminIdKey eq null}">
	<meta http-equiv="Refresh" content="0;url=<%=contextPath%>/admin/index.do">
	<script>
		alert("관리자 아이디로 로그인후 이용할 수 있습니다.")
	</script>
</c:if>
<%}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Market Vegan</title>
<link rel="shortcut icon" href="../resources/img/logo/favicon.png">
<link rel="stylesheet" href="../resources/admin/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
<script src="../resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div>
		<header>
			<jsp:include page="/WEB-INF/view/admin/module/header.jsp" flush="false" />	
		</header>
		<div class="nav">
			<jsp:include page="/WEB-INF/view/admin/module/nav.jsp" flush="false" />	
		</div>
		<article>
			<jsp:include page="<%=content %>" flush="false" />
		</article>
	</div>
</body>
</html>

 	