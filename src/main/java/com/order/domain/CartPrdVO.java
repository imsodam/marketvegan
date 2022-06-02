package com.order.domain;

public class CartPrdVO {
	private String cart_num,product_img1,product_name,order_num;
	private int cart_count,product_price,product_delivery_charge,product_code;
	
	
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getProduct_img1() {
		return product_img1;
	}
	public void setProduct_img1(String product_img1) {
		this.product_img1 = product_img1;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getCart_num() {
		return cart_num;
	}
	public void setCart_num(String cart_num) {
		this.cart_num = cart_num;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_delivery_charge() {
		return product_delivery_charge;
	}
	public void setProduct_delivery_charge(int product_delivery_charge) {
		this.product_delivery_charge = product_delivery_charge;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CartPrdVO[cart_num="+cart_num
				+",product_img1="+product_img1
				+",product_name="+product_name
				+",cart_count="+cart_count
				+",product_price="+product_price
				+",product_delivery_charge="+product_delivery_charge
				+",product_code="+product_code
				+",order_num="+order_num
				+"]";
	}
	
}
