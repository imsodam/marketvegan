package com.order.domain;

public class CartVO {
	private String cart_num;
	private int cart_count;
	private int cart_price;
	private String user_id;
	private int product_code;
	
	
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
	public int getCart_price() {
		return cart_price;
	}
	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CartVO[cart_num="+cart_num
				+",cart_count="+cart_count
				+",cart_price="+cart_price
				+",user_id="+user_id
				+",product_code="+product_code
				+"]";
	}
}
