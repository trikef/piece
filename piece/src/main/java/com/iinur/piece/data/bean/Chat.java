package com.iinur.piece.data.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Chat {
	private int id;
	private int project_id;
	private int user_id;
	private String text;
	private int priority;
	private Timestamp created_at;
	private String name;
	private int good;
	private int bad;
	private boolean regi;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
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

	public boolean isRegi() {
		return regi;
	}
	public void setRegi(boolean regi) {
		this.regi = regi;
	}

	private static String TIME_FORMAT = "yyyy/MM/dd HH:mm";
	
	public String getCreated_at_str(){
		return new SimpleDateFormat(TIME_FORMAT).format(getCreated_at());
	}
}
