package com.iinur.piece.data.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Product {

	private int id;
	private int piece_id;
	private int user_id;
	private String name;
	private int status;
	private double star;
	private int type_id;
	private Timestamp created_at;
	private String user_name;
	private String type_name;
	
	private String project_title;
	private String piece_title;
	
	private int project_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPiece_id() {
		return piece_id;
	}
	public void setPiece_id(int piece_id) {
		this.piece_id = piece_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	private static String TIME_FORMAT = "yyyy/MM/dd HH:mm";
	
	public String getCreated_at_str(){
		return new SimpleDateFormat(TIME_FORMAT).format(getCreated_at());
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
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_title() {
		return project_title;
	}
	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
	public String getPiece_title() {
		return piece_title;
	}
	public void setPiece_title(String piece_title) {
		this.piece_title = piece_title;
	}
}
