package com.iinur.piece.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.data.bean.Project;
import com.iinur.piece.model.ProjectModel;

@Results({
	  @Result(name="error", location="projectinput.jsp")
	})
public class ProjectregiAction extends BaseAction {

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
		if(!StringUtils.isEmpty(title)){
			Project p = pmodel.registration(uid, title, description, goal, target_date);
			
			if(p==null){
				this.msg = ERROR;
				return ERROR;
			} else {
				this.atlmodel.regiNewProject(servletPath, uid, p.getId());
			}
		}

		return SUCCESS;
	}
}
