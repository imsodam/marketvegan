package com.admin.domain;

public class AdminVO {
	private String admin_id,admin_pwd,admin_name,admin_level;

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_level() {
		return admin_level;
	}

	public void setAdmin_level(String admin_level) {
		this.admin_level = admin_level;
	}
	
	public String toString() {
		return "AdminVO[admin_id="+admin_id
				+",admin_pwd="+admin_pwd
				+",admin_name="+admin_name
				+",admin_level="+admin_level
				+"]";
	}
}
