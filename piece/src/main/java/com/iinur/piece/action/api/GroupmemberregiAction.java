package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.core.util.PermissionUtils;
import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.GroupMember;
import com.iinur.piece.model.GroupMemberModel;
import com.iinur.piece.model.ProjectModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","g", "ignoreHierarchy","false"}),
})
public class GroupmemberregiAction extends BaseAction {

	public GroupMember g = null;
	
	public int fi;//friend_user_id
	public int pri;//project_id
	public int pci;//piece_id
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}

		if(fi>0 && uid!=fi){
			ProjectModel pmodel = new ProjectModel();
			if(pmodel.permission(pri, uid, PermissionUtils.WRITE)){
				GroupMemberModel gmodel = new GroupMemberModel();
				GroupMember gm = gmodel.get(fi, pri, pci);
				if(gm==null){
					gmodel.registration(fi, pri, pci, PermissionUtils.ALL);//TODO permission check
					g = gmodel.get(fi, pri, pci);

					this.atlmodel.regiAddGroupMember(servletPath, uid, pri, pci, fi);
				}
			}
		}

		return SUCCESS;
	}
}
