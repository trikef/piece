package com.iinur.piece.data.bean;

import java.sql.Timestamp;

public class GroupMember {
	private int id;
	private int user_id;
	private int project_id;
	private int piece_id;
	private int permission;
	private Timestamp created_at;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int getPiece_id() {
		return piece_id;
	}

	public void setPiece_id(int piece_id) {
		this.piece_id = piece_id;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
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
}
