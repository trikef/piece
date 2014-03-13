package com.iinur.piece.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private static final Logger log = LoggerFactory.getLogger(IndexAction.class);

	public String text;

	public String execute(){
		this.text = "Hello!";
		return SUCCESS;
	}
}