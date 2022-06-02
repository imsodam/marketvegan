package com.order.domain;

import java.sql.Timestamp;

public class ChangeVO {
	private int change_num;
	private Timestamp change_date,delivery_date;
	private String order_num,change_content,change_state,change_reason,change_content_name,change_state_name,change_reason_name;
	public int getChange_num() {
		return change_num;
	}
	public void setChange_num(int change_num) {
		this.change_num = change_num;
	}
	public Timestamp getChange_date() {
		return change_date;
	}
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public void setChange_date(Timestamp change_date) {
		this.change_date = change_date;
	}
	
	public Timestamp getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Timestamp delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getChange_content() {
		return change_content;
	}
	public void setChange_content(String change_content) {
		this.change_content = change_content;
	}
	public String getChange_state() {
		return change_state;
	}
	public void setChange_state(String change_state) {
		this.change_state = change_state;
	}
	public String getChange_reason() {
		return change_reason;
	}
	public void setChange_reason(String change_reason) {
		this.change_reason = change_reason;
	}
	public String getChange_content_name() {
		return change_content_name;
	}
	public void setChange_content_name(String change_content_name) {
		this.change_content_name = change_content_name;
	}
	public String getChange_state_name() {
		return change_state_name;
	}
	public void setChange_state_name(String change_state_name) {
		this.change_state_name = change_state_name;
	}
	public String getChange_reason_name() {
		return change_reason_name;
	}
	public void setChange_reason_name(String change_reason_name) {
		this.change_reason_name = change_reason_name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ChangeVO[change_num="+change_num
				+",change_date="+change_date
				+",delivery_date="+delivery_date
				+",order_num="+order_num
				+",change_content="+change_content
				+",change_state="+change_state
				+",change_reason="+change_reason
				+",change_content_name="+change_content_name
				+",change_state_name="+change_state_name
				+",change_reason_name="+change_reason_name
				+"]";
	}
}
