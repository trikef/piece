package com.iinur.piece.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.data.bean.Project;
import com.iinur.piece.model.ProjectModel;

@Results({
	  @Result(name="error", location="projectupdateinput.jsp")
	})
public class ProjectupdateAction extends BaseAction {

	public int pid;
	public String title;
	public String description;
	public String goal;
	public String target_date;
	
	public String msg;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		ProjectModel pmodel = new ProjectModel();
		if(target_date != null){
			boolean regi = pmodel.update(pid, title, description, goal, target_date);
			if(!regi){
				this.msg = ERROR;
				return ERROR;
			}
		}
		this.atlmodel.regiUpdateProject(servletPath, uid, pid);//log
		this.acsmodel.regiProject(servletPath, pid, uid);
		
		return SUCCESS;
	}
}
