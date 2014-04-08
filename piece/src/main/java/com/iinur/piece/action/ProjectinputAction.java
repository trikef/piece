package com.iinur.piece.action;

public class ProjectinputAction extends BaseAction {

	public String execute(){
		this.logFlag = true;
		return before();
	}
}
