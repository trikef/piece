package com.iinur.piece.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.data.bean.Project;
import com.iinur.piece.model.ProjectModel;

@Action(value="/projectupdateinput/{id:.+}",
results={@Result(name="success", location="projectupdateinput.jsp")}
)
public class ProjectupdateinputAction extends BaseAction {

	public int id;

	public Project p;

	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		
		ProjectModel pmodel = new ProjectModel();
		this.p = pmodel.getSingle(id);
		
		this.acsmodel.regiProject(servletPath, id, uid);
		
		return SUCCESS;
	}
}
