package com.iinur.piece.data.bean;

import java.sql.Timestamp;

import com.iinur.core.util.HtmlUtils;

public class Piece {

	public static final int STATUS_ID_COMP = 0;
	public static final int STATUS_ID_INCOMP = 1;
	
	public static final boolean DISPLAY_ON = true;
	public static final boolean DISPLAY_OFF = false;

	private int id;
	private int project_id;
	private int user_id;
	private String title;
	private String description;
	private String goal;
	private int status_id;
	private boolean display;
	private int permission;
	private int priority;
	private String img;
	private String url;
	private Timestamp target_date;
	private Timestamp created_at;
	private String user_name;
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
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
