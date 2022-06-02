package com.board.domain;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.util.Static;

public class BoardVO {
	String board_num,board_title,board_group,board_content;
	String board_img,board_is_show,admin_id,board_group_name;
	MultipartFile upload;
	Timestamp board_date;
	int board_views;
	String keyField,keyWord;//검색어 조회 위함
	
	public String getBoard_num() {
		return board_num;
	}

	public void setBoard_num(String board_num) {
		this.board_num = board_num;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		//this.board_title = board_title;
		this.board_title = Static.convert(board_title);
	}

	public String getBoard_group() {
		return board_group;
	}

	public void setBoard_group(String board_group) {
		this.board_group = board_group;
	}

	public String getBoard_group_name() {
		return board_group_name;
	}

	public void setBoard_group_name(String board_group_name) {
		this.board_group_name = board_group_name;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		//this.board_content = board_content;
		this.board_content = Static.convert(board_content);
	}

	public String getBoard_img() {
		return board_img;
	}

	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}

	public String getBoard_is_show() {
		return board_is_show;
	}

	public void setBoard_is_show(String board_is_show) {
		this.board_is_show = board_is_show;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	public Timestamp getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}

	public int getBoard_views() {
		return board_views;
	}

	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}


	public String getKeyField() {
		return keyField;
	}

	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return "BoardVO[board_num="+board_num
				+",board_title="+board_title
				+",board_group="+board_group
				+",board_group_name="+board_group_name
				+",board_content="+board_content
				+",board_img="+board_img
				+",board_is_show="+board_is_show
				+",admin_id="+admin_id
				+",board_date="+board_date
				+",board_views="+board_views
				+",keyField="+keyField
				+",keyWord="+keyWord
				+"]";
	}

}
