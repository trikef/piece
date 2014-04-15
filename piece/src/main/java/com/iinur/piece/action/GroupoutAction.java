package com.iinur.piece.action;

import com.iinur.piece.model.GroupMemberModel;

public class GroupoutAction extends BaseAction {

	public int pri;//project_id
	public int pci;//piece_id
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		GroupMemberModel gmodel = new GroupMemberModel();
		gmodel.delete(uid, pri, pci);

		this.atlmodel.regiOutGroupMember(servletPath, uid, pri, pci);

		return SUCCESS;
	}
}
