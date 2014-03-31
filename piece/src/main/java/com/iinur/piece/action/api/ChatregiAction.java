package com.iinur.piece.action.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.model.ChatModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","c", "ignoreHierarchy","false"}),
})
public class ChatregiAction extends BaseAction {

	public Chat c = null;
	
	public int p;
	public int u;
	public String t;
	
	public String execute(){
		
		if(!StringUtils.isEmpty(t)){
			ChatModel cmodel = new ChatModel();
			cmodel.registration(p, u, t);
			c = cmodel.getNew(p, u);
		}
		return SUCCESS;
	}
}