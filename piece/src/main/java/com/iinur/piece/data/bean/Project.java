package com.iinur.piece.data.bean;

import java.sql.Timestamp;

import com.iinur.core.util.HtmlUtils;

public class Project {

	private int id;
	private int user_id;
	private String title;
	private String description;
	private String goal;
	private String img;
	private int status_id;
	private int permission;
	private Timestamp target_date;
	private Timestamp created_at;
	
	private boolean unread;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public String getDescription_link() {
		return HtmlUtils.replaceLink(description);
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGoal() {
		return goal;
	}
	public String getGoal_link() {
		return HtmlUtils.replaceLink(goal);
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public Timestamp getTarget_date() {
		return target_date;
	}
	public void setTarget_date(Timestamp target_date) {
		this.target_date = target_date;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public boolean isUnread() {
		return unread;
	}
	public void setUnread(boolean unread) {
		this.unread = unread;
	}
}
