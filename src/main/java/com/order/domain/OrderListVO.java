package com.order.domain;

import java.sql.Timestamp;

public class OrderListVO {
	private Timestamp order_date;
	private String order_product_name,order_product_img1;
	private String order_num,order_state,order_state_name,order_invoice,user_id,user_name,user_phone,user_email;
	private int order_price,order_delivery_charge,order_product_count;
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public String getOrder_product_name() {
		return order_product_name;
	}
	public void setOrder_product_name(String order_product_name) {
		this.order_product_name = order_product_name;
	}
	
	public String getOrder_product_img1() {
		return order_product_img1;
	}
	public void setOrder_product_img1(String order_product_img1) {
		this.order_product_img1 = order_product_img1;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	
	public String getOrder_state_name() {
		return order_state_name;
	}
	public void setOrder_state_name(String order_state_name) {
		this.order_state_name = order_state_name;
	}
	public String getOrder_invoice() {
		return order_invoice;
	}
	public void setOrder_invoice(String order_invoice) {
		this.order_invoice = order_invoice;
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
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getOrder_delivery_charge() {
		return order_delivery_charge;
	}
	public void setOrder_delivery_charge(int order_delivery_charge) {
		this.order_delivery_charge = order_delivery_charge;
	}
	public int getOrder_product_count() {
		return order_product_count;
	}
	public void setOrder_product_count(int order_product_count) {
		this.order_product_count = order_product_count;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "OrderListVO[order_date="+order_date
				+",order_product_name="+order_product_name
				+",order_product_img1="+order_product_img1
				+",order_num="+order_num
				+",order_state="+order_state
				+",order_state_name="+order_state_name
				+",order_invoice="+order_invoice
				+",user_id="+user_id
				+",user_name="+user_name
				+",user_phone="+user_phone
				+",user_email="+user_email
				+",order_price="+order_price
				+",order_delivery_charge="+order_delivery_charge
				+",order_product_count="+order_product_count
				+"]";
	}
	
}
