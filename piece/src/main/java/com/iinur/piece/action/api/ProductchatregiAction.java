package com.iinur.piece.action.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.ProductChat;
import com.iinur.piece.model.ProductChatModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","c", "ignoreHierarchy","false"}),
})
public class ProductchatregiAction extends BaseAction {

	public ProductChat c = null;
	
	public int p;//product_id
	public int u;//user_id
	public String t;//text
	public int s;//star
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		if(!StringUtils.isEmpty(t)){
			ProductChatModel pcmodel = new ProductChatModel();
			pcmodel.registration(p, u, t, s);
			c = pcmodel.getNew(p, u);
			
			this.atlmodel.regiNewProductChat(servletPath, uid, p, c.getId());//log
		}
		return SUCCESS;
	}
}
