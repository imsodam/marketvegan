<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
	String DIRECTORY=(String)request.getAttribute("DIRECTORY");
	String CONTENT=(String)request.getAttribute("CONTENT");

	//System.out.println("template.jsp의 DIRECTORY=>"+DIRECTORY+", CONTENT=>"+CONTENT);
	if (DIRECTORY==null) DIRECTORY="view";
	if (CONTENT==null) CONTENT="main";
	
	String content="/WEB-INF/view/"+DIRECTORY+"/"+CONTENT+".jsp";
	//System.out.println("content=>"+content);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Market Vegan</title>
    
    <!-- 부트스트랩 -->
    <link rel="stylesheet" href="./resources/css/common.css">
    <link rel="stylesheet" href="./resources/css/content.css">
    <link rel="shortcut icon" href="./resources/img/logo/favicon.png">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">

    <script src="./resources/js/jquery-3.4.1.min.js"></script>
    <!-- <script src="./mainjs/mainpopup.js"></script> -->
    <!-- <script src="common/js/prefixfree.min.js"></script> -->
    
    <!--[if IE 9]>  
          <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
    <![endif]-->

</head>
<body>
    <div class="wrap">
    <header id="headerArea">
        <jsp:include page="/WEB-INF/view/module/header.jsp" flush="false" /> 
	</header>
	<!-- <div style="height:240px;"></div> -->

<% if(content.contains("/view/main.jsp")){  %>
    <div class="visual">
   		 <jsp:include page="/WEB-INF/view/module/visual.jsp" flush="false" /> 
    </div>
<%} %>


   <article id="content">
   		 <jsp:include page="<%=content %>" flush="false" /> 
   </article>

        <!-- 하단푸터영역 -->
    <footer id="footerArea">
		 <jsp:include page="/WEB-INF/view/module/footer.jsp" flush="false" /> 
    </footer>
    </div>

      <!-- JQuery -->
      <script src="./resources/js/fullnav.js"></script>
     
    </body>
</html>