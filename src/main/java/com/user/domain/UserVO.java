package com.user.domain;

import java.sql.Timestamp;

public class UserVO {
	private String user_id;//회원 id
	private String user_pwd;//암호
	private String user_name;//이름
	private String user_email;//이메일
	private String user_phone;//전번
	private String user_zipcode;//우편번호
	private String user_addr1;//주소
	private String user_addr2;//주소2
	private String user_addr3;//주소3
	private Timestamp user_date;//가입날짜
	private int user_point;//포인트
	private String user_grade;//등급
	private String user_agree;//약관동의
	private String user_end;//탈퇴여부
	private Timestamp user_end_date;//탈퇴날짜
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_zipcode() {
		return user_zipcode;
	}
	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}
	public String getUser_addr1() {
		return user_addr1;
	}
	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}
	public String getUser_addr2() {
		return user_addr2;
	}
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}
	public String getUser_addr3() {
		return user_addr3;
	}
	public void setUser_addr3(String user_addr3) {
		this.user_addr3 = user_addr3;
	}
	public Timestamp getUser_date() {
		return user_date;
	}
	public void setUser_date(Timestamp user_date) {
		this.user_date = user_date;
	}
	public int getUser_point() {
		return user_point;
	}
	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}
	public String getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
	public String getUser_agree() {
		return user_agree;
	}
	public void setUser_agree(String user_agree) {
		this.user_agree = user_agree;
	}
	public String getUser_end() {
		return user_end;
	}
	public void setUser_end(String user_end) {
		this.user_end = user_end;
	}
	public Timestamp getUser_end_date() {
		return user_end_date;
	}
	public void setUser_end_date(Timestamp user_end_date) {
		this.user_end_date = user_end_date;
	}
	
	public String toString() {
		return "UserVO[user_id="+user_id
				+",user_pwd="+user_pwd
				+",user_name="+user_name
				+",user_email="+user_email
				+",user_phone="+user_phone
				+",user_zipcode="+user_zipcode
				+",user_addr1="+user_addr1
				+",user_addr2="+user_addr2
				+",user_addr3="+user_addr3
				+",user_date="+user_date
				+",user_point="+user_point
				+",user_grade="+user_grade
				+",user_agree="+user_agree
				+",user_end="+user_end
				+",user_end_date="+user_end_date
				+"]";
	}
}
