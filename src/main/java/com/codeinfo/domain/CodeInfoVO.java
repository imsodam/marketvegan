package com.codeinfo.domain;

public class CodeInfoVO {
	private String gropu_id,code,code_name,use_yn;
	private int code_order;
	public String getGropu_id() {
		return gropu_id;
	}
	public void setGropu_id(String gropu_id) {
		this.gropu_id = gropu_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public int getCode_order() {
		return code_order;
	}
	public void setCode_order(int code_order) {
		this.code_order = code_order;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProductVO[gropu_id="+gropu_id
				+",code="+code
				+",code_name="+code_name
				+",use_yn="+use_yn
				+",code_order="+code_order
				+"]";
	}
}
