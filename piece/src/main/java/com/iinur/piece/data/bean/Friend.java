package com.iinur.piece.data.bean;

import java.sql.Timestamp;

public class Friend {

	private int id;
	private int own_user_id;
	private int friend_user_id;
	private int status_id;
	private Timestamp created_at;
	
	private String own_name;
	private String friend_name;
	
	private int friend_status_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOwn_user_id() {
		return own_user_id;
	}
	public void setOwn_user_id(int own_user_id) {
		this.own_user_id = own_user_id;
	}
	public int getFriend_user_id() {
		return friend_user_id;
	}
	public void setFriend_user_id(int friend_user_id) {
		this.friend_user_id = friend_user_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getOwn_name() {
		return own_name;
	}
	public void setOwn_name(String own_name) {
		this.own_name = own_name;
	}
	public String getFriend_name() {
		return friend_name;
	}
	public void setFriend_name(String friend_name) {
		this.friend_name = friend_name;
	}
	public int getFriend_status_id() {
		return friend_status_id;
	}
	public void setFriend_status_id(int friend_status_id) {
		this.friend_status_id = friend_status_id;
	}
}
