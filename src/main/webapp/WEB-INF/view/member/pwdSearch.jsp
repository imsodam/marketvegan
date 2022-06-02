<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="./resources/member/css/pwdSearch.css">
			
			<!-- 아이디찾기 -->
                <div id="id_search">
                    <div hidden class="id_search1"></div>
                    <div class="id_search_sub">
                        <h2 class="id_search_name">비밀번호 찾기</h2>
                    </div>
                    <div class="certification">
                        <div class="id_certification">
                            <button selected type="button" class="certification_bt">휴대폰 인증</button>
                            <button type="button" class="certification_bt">이메일 인증</button>
                        </div>
                        <form class="search" id="idSearchForm" method="post"
							  action="<%=contextPath%>/pwdSearch.do">
                            <div class="name_search">
                                <div class="name_search1">
                                    <label for="name" class="name">아이디</label>
                                    <div class="name_search2">
                                        <input type="text" data-testid="input-box" id="user_id" name="user_id" value 
                                            placeholder="아이디를 입력해주세요" class="name1">
                                    </div>
                                </div>
                            </div>
                            <div id="toggle">
	                            <div class="phone_search">
	                                <div class="phone_search1">
	                                    <label for="phone" class="phone">휴대폰 번호</label>
	                                    <div class="phone_search2">
	                                        <input type="tel" data-testid="input-box" id="user_phone" name="user_phone" value
	                                            placeholder="휴대폰 번호를 입력해주세요" class="phone1">
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="email_search">
	                                <div class="phone_search1">
	                                    <label for="email" class="phone">이메일 번호</label>
	                                    <div class="phone_search2">
	                                        <input type="tel" data-testid="input-box" id="user_email" name="user_email" value
	                                            placeholder="이메일 입력해주세요" class="phone1">
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