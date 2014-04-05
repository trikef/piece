package com.iinur.piece.data.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ProductChat {
	private int id;
	private int product_id;
	private int user_id;
	private String text;
	private int star;
	private Timestamp created_at;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static String TIME_FORMAT = "yyyy/MM/dd HH:mm";
	
	public String getCreated_at_str(){
		return new SimpleDateFormat(TIME_FORMAT).format(getCreated_at());
	}
}
