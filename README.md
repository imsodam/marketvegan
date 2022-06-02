# marketvegan
비건 쇼핑몰 프로젝트
<br><br>

# 개발 환경 및 개발 언어
* 개발 환경
    * 이클립스, Tomcat/9.0.56
* 개발 언어
    * HTML, CSS, javascript, Jquery, JAVA 8, JSP, Oracle, Spring
<br><br>

# 모델링
![erd](https://user-images.githubusercontent.com/98933092/171592311-3a63d3c6-db58-48c6-8a9b-14a9671b19b3.png)
<br><br>

# 구현기능
* 회원 관리
    * 회원 가입/수정/탈퇴
    * 로그인/로그아웃
    * 마이페이지
    * 아이디/비밀번호 찾기
    * 관리자 페이지 회원 목록, 검색 조회

* 상품 관리
    * 상품 목록, 카테고리별 상품 조회, 검색 조회, 페이징
    * 베스트(많이 팔린 순), 특가(할인률 높은 상품)
    * 상품 상세페이지
    * 관리자 페이지 상품 목록, 페이징
    * 관리자 페이지 상품 등록/수정/삭제

* 장바구니
    * 추가(장바구니 담기)
    * 수량 변경, 삭제 비동기 처리
    * 선택주문(전체선택 or 개별선택)

* 주문 기능
    * 주문 처리/취소
    * 배송지 수정
    * 마이페이지 주문 목록, 기간 조회, 페이징
    * 관리자 페이지 주문 목록, 기간/주문상태/키워드검색(주문번호,주문자명,아이디 등) 조회
    * 관리자 페이지 주문상태 변경, 송장번호 입력

* 공지/매거진 게시판
    * 게시글 작성, 수정, 삭제
    * 글 목록, 글 상세, 이전글/다음글 버튼, 페이징

* 관리자
    * 모든 관리자 페이지는 관리자 로그인 했을때만 접근 가능
<br><br>

# 캡쳐 이미지
* 회원 가입
    * 각 항목 유효성 검사
    * ![01join](https://user-images.githubusercontent.com/98933092/171577565-b2a3d24d-6100-4ed2-8204-b8be9815222b.png)

* 상품 목록
    * 카테고리별 상품조회
    * 베스트, 특가상품 목록
    * 네비게이션의 검색기능으로 모든페이지에서 상품 검색
    * ![02product](https://user-images.githubusercontent.com/98933092/171577572-819b6384-dfd3-48c3-a8f2-02fddf67f49a.png)

* 상품 상세 및 장바구니
    * 상품 상세페이지에서 장바구니 담기
    * 장바구니에서 비동기 수량 변경/삭제
    * 전체 or 부분 체크후 주문하기
    * ![03cart](https://user-images.githubusercontent.com/98933092/171577579-9cf506b5-35c3-41f3-a81f-6ddbd9b68dd9.png)

* 주문서
    * 주문상품정보, 주문자정보(회원정보), 배송정보입력, 결제수단 선택
    * ![04order](https://user-images.githubusercontent.com/98933092/171590503-d1f14641-23cd-4c62-a5c9-cdef441cd40c.png)

* Mypage-주문 목록
    * 주문목록
    * ![05my_order_list](https://user-images.githubusercontent.com/98933092/171577592-5bd94c55-6783-45d5-96cf-942ab6719671.png)

* Mypage-주문 상세
    * 주문상품, 배송정보, 결제정보 확인
    * 주문취소, 배송지변경 (배송준비중 전단계까지만 버튼 보여짐)
    * ![06my_order_detail](https://user-images.githubusercontent.com/98933092/171577596-4dba2798-eeb9-49c6-88d7-2158c3641c14.png)

* 관리자-회원 관리
    * 아이디, 이름 등으로 검색 조회
    * 각 아이디 클릭시 상세정보 팝업창
    * ![07admin_user](https://user-images.githubusercontent.com/98933092/171577602-e10f86b6-d7b3-4079-9de1-0a765bd60f43.png)

* 관리자-상품 관리
    * 상품명 검색 or 카테고리별 조회
    * 상품 등록, 수정, 삭제
    * ![08admin_product](https://user-images.githubusercontent.com/98933092/171577605-9b018fe4-ef4c-4241-9cc4-caccbc5291c0.png)

* 관리자-주문 관리(목록)
    * 주문 날짜, 주문상태, 키워드 검색 조회
    * 주문상태 변경(선택박스 선택시 변경됨), 송장번호 입력
    * ![09admin_order_list](https://user-images.githubusercontent.com/98933092/171577607-2493fb6b-5bd6-4e9e-9e80-a766298113ce.png)

* 관리자-주문 관리(상세)
    * 주문 상세(상품,결제,배송 등) 정보 확인
    * 배송지변경 (배송준비중 전단계까지만 버튼 보여짐)
    * ![10admin_order_detail](https://user-images.githubusercontent.com/98933092/171577609-4061f7c8-6862-424c-967a-e7f9ad131b0c.png)

* 관리자-결제 관리
    * 결제 목록
    * ![11admin_pay](https://user-images.githubusercontent.com/98933092/171577613-24b538fe-ae90-4e6f-ada8-eea638fa602b.png)

