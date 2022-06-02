package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//로그인 여부
public class LoginId {
	private String user_id="";
	
	public LoginId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
	    if(session!=null) {
	    	user_id=(String)session.getAttribute("idKey");
	    }
	}
	
	public String getId() {
		return user_id;
	}
}
