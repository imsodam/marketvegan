package com.user.domain;

public class LoginVO {
	private boolean check;
	private String user_end;
	
	public boolean getCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public String getUser_end() {
		return user_end;
	}
	public void setUser_end(String user_end) {
		this.user_end = user_end;
	}
	public String toString() {
		return "LoginVO[check="+check
				+",user_end="+user_end
				+"]";
	}

	
}
