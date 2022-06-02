<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
<c:if test="${user.user_pwd ne null}">

<link rel="stylesheet" href="./resources/member/css/pwdSearch.css">
			
			<!-- 아이디찾기 -->
                <div id="id_search">
                    <div hidden class="id_search1"></div>
                    <div class="id_search_sub">
                        <h2 class="id_search_name">새 비밀번호 입력</h2>
                    </div>
                    <div class="certification">
                        <form class="search" id="idSearchForm" method="post"
							  action="<%=contextPath%>/pwdUpdatePro.do">
                            <div class="name_search">
                                <div class="name_search1">
                                    <label for="name" class="name">아이디</label>
                                    <div class="name_search2">
                                        <input type="text" data-testid="input-box" id="user_id" name="user_id" class="name1" value="${user.user_id}" readonly>
                                    </div>
                                </div>
                            </div>
                            <div id="">
	                            <div class="phone_search">
	                                <div class="phone_search1">
	                                    <label for="phone" class="phone">새 비밀번호</label>
	                                    <div class="phone_search2">
	                                        <input type="password" data-testid="input-box" id="user_pwd" name="user_pwd" 
	                                            placeholder="새 비밀번호를 입력해주세요" class="phone1">
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="email_search">
	                                <div class="phone_search1">
	                                    <label for="email" class="phone">새 비밀번호 확인</label>
	                                    <div class="phone_search2">
	                                        <input type="password" data-testid="input-box" id="user_repwd" name="user_repwd" 
	                                            placeholder="새 비밀번호를 재입력해주세요" class="phone1">
	                                    </div>
	                                </div>
	                            </div>
                            </div>
                            <div class="find_id">
                                <button class="find_id1" id="find_id1" type="button" radius="4" style="cursor:pointer">
                                    <span class="find_id2">Find PassWord</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                
<script type=text/javascript src="./resources/member/js/idSearch.js"></script>
</c:if>
<c:if test="${user.user_pwd eq null}">
	<script>
		alert("해당하는 정보가 없습니다.");
		history.back();
	</script>
</c:if>