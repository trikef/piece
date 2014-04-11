package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.TagModel;

@ParentPackage("json-default")

//Actionクラスの結果。type=jsonでJSON形式
@Results({
@Result(name="success" , type="json" ,
       params={"root","tag", "ignoreHierarchy","false"}),
})
public class TagdisplayAction extends BaseAction{

	public int i;//tag_id
	public boolean d;//display
	
	public Tag tag;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		TagModel tmodel = new TagModel();
		//TODO permission
		//if(tmodel.permissionExecute(i, uid)){
			tmodel.updateDisplay(i, d);
			this.tag = tmodel.get(i);
			
			if(!d){
				this.atlmodel.regiDelTag(servletPath, uid, i);//log
			}
		//}

		return SUCCESS;
	}
	
}
