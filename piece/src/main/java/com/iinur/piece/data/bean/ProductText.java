package com.iinur.piece.data.bean;

import java.sql.Timestamp;

import com.iinur.core.util.HtmlUtils;

public class ProductText extends Product {

	private int text_id;
	//private int product_id;
	private String data;
	private String comment;
	//private Timestamp created_at;
	private Timestamp updated_at;
	public int getText_id() {
		return text_id;
	}
	public void setText_id(int text_id) {
		this.text_id = text_id;
	}
	public String getData() {
		return data;
	}
	public String getData_link() {
		return HtmlUtils.replaceLink(data);
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
}
