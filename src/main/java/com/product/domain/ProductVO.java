package com.product.domain;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {

	private String product_name,product_content,category_code,product_is_show;
	private String product_img1,product_img2,product_img3,product_img4;
	private int product_code, product_price,product_delivery_charge,product_views,product_sales,product_review,product_discount;	
	private Timestamp product_update,product_date;
	private List<MultipartFile> upload;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_content() {
		return product_content;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getProduct_is_show() {
		return product_is_show;
	}
	public void setProduct_is_show(String product_is_show) {
		this.product_is_show = product_is_show;
	}

	public String getProduct_img1() {
		return product_img1;
	}
	public void setProduct_img1(String product_img1) {
		this.product_img1 = product_img1;
	}
	public String getProduct_img2() {
		return product_img2;
	}
	public void setProduct_img2(String product_img2) {
		this.product_img2 = product_img2;
	}
	public String getProduct_img3() {
		return product_img3;
	}
	public void setProduct_img3(String product_img3) {
		this.product_img3 = product_img3;
	}
	public String getProduct_img4() {
		return product_img4;
	}
	public void setProduct_img4(String product_img4) {
		this.product_img4 = product_img4;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
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
	public int getProduct_views() {
		return product_views;
	}
	public void setProduct_views(int product_views) {
		this.product_views = product_views;
	}
	public int getProduct_sales() {
		return product_sales;
	}
	public void setProduct_sales(int product_sales) {
		this.product_sales = product_sales;
	}
	public int getProduct_review() {
		return product_review;
	}
	public void setProduct_review(int product_review) {
		this.product_review = product_review;
	}
	public int getProduct_discount() {
		return product_discount;
	}
	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}
	public Timestamp getProduct_update() {
		return product_update;
	}
	public void setProduct_update(Timestamp product_update) {
		this.product_update = product_update;
	}
	public Timestamp getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Timestamp product_date) {
		this.product_date = product_date;
	}
	public List<MultipartFile> getUpload() {
		return upload;
	}
	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProductVO[product_name="+product_name
				+",product_content="+product_content
				+",category_code="+category_code
				+",product_is_show="+product_is_show
				+",product_img1="+product_img1
				+",product_img2="+product_img2
				+",product_img3="+product_img3
				+",product_img4="+product_img4
				+",product_code= "+product_code
				+",product_price="+product_price
				+",product_delivery_charge="+product_delivery_charge
				+",product_views="+product_views
				+",product_sales="+product_sales
				+",product_review="+product_review
				+",product_discount="+product_discount
				+",product_update="+product_update
				+",product_date="+product_date
				+",upload"+upload
				+"]";
	}
	
	
}

