package com.order.domain;

import java.sql.Timestamp;

public class OrdersVO {
	private String order_num,order_recipient,order_zipcode,order_addr1,order_addr2,order_addr3,order_memo,order_state,user_id,order_change_state,order_phone,order_invoice,order_state_name;
	private Timestamp order_date,order_delivery_date;
	private int order_price,order_point,order_delivery_charge;
	//추가
	private String user_name,user_phone,user_email;
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getOrder_recipient() {
		return order_recipient;
	}
	public void setOrder_recipient(String order_recipient) {
		this.order_recipient = order_recipient;
	}
	public String getOrder_zipcode() {
		return order_zipcode;
	}
	public void setOrder_zipcode(String order_zipcode) {
		this.order_zipcode = order_zipcode;
	}
	public String getOrder_addr1() {
		return order_addr1;
	}
	public void setOrder_addr1(String order_addr1) {
		this.order_addr1 = order_addr1;
	}
	public String getOrder_addr2() {
		return order_addr2;
	}
	public void setOrder_addr2(String order_addr2) {
		this.order_addr2 = order_addr2;
	}
	public String getOrder_addr3() {
		return order_addr3;
	}
	public void setOrder_addr3(String order_addr3) {
		this.order_addr3 = order_addr3;
	}
	public String getOrder_memo() {
		return order_memo;
	}
	public void setOrder_memo(String order_memo) {
		this.order_memo = order_memo;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public Timestamp getOrder_delivery_date() {
		return order_delivery_date;
	}
	public void setOrder_delivery_date(Timestamp order_delivery_date) {
		this.order_delivery_date = order_delivery_date;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getOrder_point() {
		return order_point;
	}
	public void setOrder_point(int order_point) {
		this.order_point = order_point;
	}
	public int getOrder_delivery_charge() {
		return order_delivery_charge;
	}
	public void setOrder_delivery_charge(int order_delivery_charge) {
		this.order_delivery_charge = order_delivery_charge;
	}
	public String getOrder_invoice() {
		return order_invoice;
	}
	public void setOrder_invoice(String order_invoice) {
		this.order_invoice = order_invoice;
	}
	public String getOrder_change_state() {
		return order_change_state;
	}
	public void setOrder_change_state(String order_change_state) {
		this.order_change_state = order_change_state;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
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
		return "OrdersVO[order_num="+order_num
				+",order_recipient="+order_recipient
				+",order_zipcode="+order_zipcode
				+",order_addr1="+order_addr1
				+",order_addr2="+order_addr2
				+",order_addr3="+order_addr3
				+",order_memo="+order_memo
				+",order_state="+order_state
				+",user_id="+user_id
				+",order_change_state="+order_change_state
				+",order_phone="+order_phone
				+",order_invoice="+order_invoice
				+",order_state_name="+order_state_name
				+",order_date="+order_date
				+",order_delivery_date="+order_delivery_date
				+",order_price="+order_price
				+",order_point="+order_point
				+",order_delivery_charge="+order_delivery_charge
				+"]";
	}
	
}
