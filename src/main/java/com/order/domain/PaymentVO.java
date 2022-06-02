package com.order.domain;

import java.sql.Timestamp;

public class PaymentVO {
	private int payment_num,payment_price;
	private Timestamp payment_date;
	private String payment_type,card_type,card_month,order_num,payment_name;
	private String user_id,user_name,user_phone,user_email,order_state_name;
	
	public int getPayment_num() {
		return payment_num;
	}
	public void setPayment_num(int payment_num) {
		this.payment_num = payment_num;
	}
	public int getPayment_price() {
		return payment_price;
	}
	
	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
	}
	public Timestamp getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Timestamp payment_date) {
		this.payment_date = payment_date;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getCard_month() {
		return card_month;
	}
	public void setCard_month(String card_month) {
		this.card_month = card_month;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getPayment_name() {
		return payment_name;
	}
	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getOrder_state_name() {
		return order_state_name;
	}
	public void setOrder_state_name(String order_state_name) {
		this.order_state_name = order_state_name;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return "PaymentVO[payment_num="+payment_num
				+",payment_price="+payment_price
				+",payment_date="+payment_date
				+",payment_type="+payment_type
				+",card_type="+card_type
				+",card_month="+card_month
				+",order_num="+order_num
				+",payment_name="+payment_name
				+",user_id="+user_id
				+",user_name="+user_name
				+",user_phone="+user_phone
				+",user_email="+user_email
				+",order_state_name="+order_state_name
				+"]";
	}

}
