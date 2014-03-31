package com.iinur.piece.action;

import java.util.List;

import com.iinur.piece.data.bean.Project;
import com.iinur.piece.model.ProjectModel;

public class ProjectlistAction extends BaseAction {

	public List<Project> ps;

	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		ProjectModel pmodel = new ProjectModel();
		this.ps = pmodel.get(uid);
		
		return SUCCESS;
	}
}
