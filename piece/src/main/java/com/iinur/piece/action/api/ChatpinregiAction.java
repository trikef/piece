package com.iinur.piece.action.api;

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
public class ChatpinregiAction extends BaseAction {

	public Chat c = null;
	
	public int i;//id
	public int p;//priority
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		
		if(i>0){
			ChatModel cmodel = new ChatModel();
			cmodel.updatePriority(i, p);
			c = cmodel.get(i);
			
			this.atlmodel.regiPinChat(servletPath, uid, c.getProject_id(), c.getPiece_id(), i);//log
		}
		return SUCCESS;
	}
}
