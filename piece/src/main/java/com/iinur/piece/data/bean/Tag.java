package com.iinur.piece.data.bean;

import java.sql.Timestamp;

public class Tag {

	private int id;
	private String name;
	private String description;
	private boolean display;
	private Timestamp created_at;
	
	private int piece_tag_id;
	private int num;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public int getPiece_tag_id() {
		return piece_tag_id;
	}
	public void setPiece_tag_id(int piece_tag_id) {
		this.piece_tag_id = piece_tag_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
