package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.model.ChatModel;
import com.iinur.piece.model.ChatvalueModel;

@ParentPackage("json-default")

//Actionクラスの結果。type=jsonでJSON形式
@Results({
@Result(name="success" , type="json" ,
       params={"root","chat", "ignoreHierarchy","false"}),
})
public class ChatvalueAction extends BaseAction{

	public int i;//chat_id
	public int u;//uid
	public int g;//good
	public int b;//bad
	
	public Chat chat;
	
	public String execute(){
		ChatvalueModel cvmodel = new ChatvalueModel();
		cvmodel.registration(i, u, g, b);
				
		ChatModel cmodel = new ChatModel();
		this.chat = cmodel.get(i);
		this.chat.setRegi(cvmodel.contains);

		return SUCCESS;
	}
	
}