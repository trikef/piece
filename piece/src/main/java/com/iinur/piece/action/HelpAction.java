package com.iinur.piece.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelpAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(HelpAction.class);


	public String execute(){
		this.logFlag = true;
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		return SUCCESS;
	}
}