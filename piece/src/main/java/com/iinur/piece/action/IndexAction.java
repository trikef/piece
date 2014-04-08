package com.iinur.piece.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndexAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(IndexAction.class);

	public String execute(){
		this.logFlag = true;
		return before();
	}
}