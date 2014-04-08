package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.core.util.PermissionUtils;
import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Project;
import com.iinur.piece.model.ProjectModel;

@ParentPackage("json-default")

//Actionクラスの結果。type=jsonでJSON形式
@Results({
@Result(name="success" , type="json" ,
       params={"root","project", "ignoreHierarchy","false"}),
})
public class ProjecttogglepublicAction extends BaseAction{

	public int i;//project_id
	//public String g;//group
	//public int a;//action
	
	public Project project;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		ProjectModel pmodel = new ProjectModel();
		Project p = pmodel.getSingle(i);
		String group = pmodel.getGroup(i, uid);
		if(PermissionUtils.check(p.getPermission(), group, PermissionUtils.WRITE)){
			if(PermissionUtils.check(
					p.getPermission(), 
					PermissionUtils.OTHER, 
					PermissionUtils.WRITE)){
				pmodel.updatePermission(i, PermissionUtils.OTHER, PermissionUtils.NONE);
				
				this.atlmodel.regiPrivateProject(servletPath, uid, i);//log
			} else {
				pmodel.updatePermission(i, PermissionUtils.OTHER, PermissionUtils.ALL);
				
				this.atlmodel.regiPublicProject(servletPath, uid, i);//log
			}
			this.project = pmodel.getSingle(i);
		}
		
		return SUCCESS;
	}
	
}
