package com.util;

import java.util.Map;

public class PagingUtil {
	
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private StringBuffer pagingHtml;// 페이징 생성자

	/**
	 * currentPage : 현재페이지
	 * totalCount : 전체 게시물 수
	 * blockCount : 한 페이지의  게시물의 수
	 * blockPage : 한 화면에 보여줄 페이지 수
	 * pageUrl : 호출 페이지 url
	 * addKey : 부가적인 key 없을 때는 null 처리 (&num=23형식으로 전달할 것)
	 * */
	public PagingUtil(int currentPage, int totalCount, int blockCount,
			int blockPage, String pageUrl) {
		this(null,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	public PagingUtil(int currentPage, int totalCount, int blockCount,
			int blockPage, String pageUrl, String addKey) {
		this(null,currentPage,totalCount,blockCount,blockPage,pageUrl,addKey);
	}
	public PagingUtil(Map<String,Object> map,int currentPage, int totalCount, int blockCount,
			int blockPage, String pageUrl) {
		this(map,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	public PagingUtil(Map<String,Object> map,int currentPage, int totalCount, int blockCount,
			int blockPage,String pageUrl,String addKey) {
		
		if(addKey == null) addKey = ""; //부가키가 null 일때 ""처리
		
		// 전체 페이지 수
		int totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}
		// 현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// 현재 페이지의 처음과 마지막 글의 번호 가져오기.
		startCount = (currentPage - 1) * blockCount + 1;
		endCount = currentPage * blockCount;
		// 시작 페이지와 마지막 페이지 값 구하기.
		int startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		int endPage = startPage + blockPage - 1;
		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		//검색어등 맵객체에서 꺼내오기
		String keyField="";
		String keyWord="";
		String category_code="";
		String order_state="";
		String payment_type="";
		String page="";
		String sDay="";
		String eDay="";
		//System.out.println("PagingUtil 호출됨 map=>"+map);
		if(map.containsKey("keyField")) {keyField=(String)map.get("keyField");}
		if(map.containsKey("keyWord")) {keyWord=(String)map.get("keyWord");}
		if(map.containsKey("category_code")) {category_code=(String)map.get("category_code");}
		if(map.containsKey("order_state")) {order_state=(String)map.get("order_state");}
		if(map.containsKey("payment_type")) {payment_type=(String)map.get("payment_type");}
		if(map.containsKey("page")) {page=(String)map.get("page");}
		if(map.containsKey("sDay")) {sDay=(String)map.get("sDay");}
		if(map.containsKey("eDay")) {eDay=(String)map.get("eDay");}
		
		// 이전 block 페이지
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			pagingHtml.append("<a href="+pageUrl+"?pageNum="+ (startPage - 1) + addKey );
			if(!Static.isStringEmpty(keyWord)) {
				pagingHtml.append("&keyField="+keyField+"&keyWord="+keyWord);
			}
			if(!Static.isStringEmpty(category_code)) {
				pagingHtml.append("&category_code="+category_code);
			}
			if(!Static.isStringEmpty(order_state)) {
				pagingHtml.append("&order_state="+order_state);
			}
			if(!Static.isStringEmpty(payment_type)) {
				pagingHtml.append("&payment_type="+payment_type);
			}
			if(!Static.isStringEmpty(page)) {
				pagingHtml.append("&page="+page);
			}
			if(!Static.isStringEmpty(sDay)) {
				pagingHtml.append("&sDay="+sDay);
				pagingHtml.append("&eDay="+eDay);
			}
			pagingHtml.append(">");
			pagingHtml.append("<i class='fas fa-angle-left'></i>");
			pagingHtml.append("</a>");
		}
		//페이지 번호.현재 페이지는 빨간색으로 강조하고 링크를 제거.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("<span>"+i+"</span>");
			} else {
				pagingHtml.append("<a href='"+pageUrl+"?pageNum=");
				pagingHtml.append(i);
				if(!Static.isStringEmpty(keyWord)) {
					pagingHtml.append("&keyField="+keyField+"&keyWord="+keyWord);
				}
				if(!Static.isStringEmpty(category_code)) {
					pagingHtml.append("&category_code="+category_code);
				}
				if(!Static.isStringEmpty(order_state)) {
					pagingHtml.append("&order_state="+order_state);
				}
				if(!Static.isStringEmpty(payment_type)) {
					pagingHtml.append("&payment_type="+payment_type);
				}
				if(!Static.isStringEmpty(page)) {
					pagingHtml.append("&page="+page);
				}
				if(!Static.isStringEmpty(sDay)) {
					pagingHtml.append("&sDay="+sDay);
					pagingHtml.append("&eDay="+eDay);
				}
				pagingHtml.append(addKey+"'>");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
				
			}
		}
		// 다음 block 페이지
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<a href="+pageUrl+"?pageNum="+ (endPage + 1) );
			if(!Static.isStringEmpty(keyWord)) {
				pagingHtml.append("&keyField="+keyField+"&keyWord="+keyWord);
			}
			if(!Static.isStringEmpty(category_code)) {
				pagingHtml.append("&category_code="+category_code);
			}
			if(!Static.isStringEmpty(order_state)) {
				pagingHtml.append("&order_state="+order_state);
			}
			if(!Static.isStringEmpty(payment_type)) {
				pagingHtml.append("&payment_type="+payment_type);
			}
			if(!Static.isStringEmpty(page)) {
				pagingHtml.append("&page="+page);
			}
			if(!Static.isStringEmpty(sDay)) {
				pagingHtml.append("&sDay="+sDay);
				pagingHtml.append("&eDay="+eDay);
			}
			pagingHtml.append(addKey+">");
			pagingHtml.append("<i class='fas fa-angle-right'></i>");
			pagingHtml.append("</a>");
		}
	}
	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}
	public int getStartCount() {
		return startCount;
	}
	public int getEndCount() {
		return endCount;
	}
}
