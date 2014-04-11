package com.iinur.piece.action.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.TagModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","tag", "ignoreHierarchy","false"}),
})
public class TagregiAction extends BaseAction {

	public Tag tag = null;
	
	public String n;//name
	public String des;//description
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		
		if(!StringUtils.isEmpty(n)){
			TagModel tmodel = new TagModel();
			tmodel.registration(uid, n, des);
			tag = tmodel.getNew(uid);
			
			this.atlmodel.regiNewTag(servletPath, uid, tag.getId());
		}
		return SUCCESS;
	}
}
