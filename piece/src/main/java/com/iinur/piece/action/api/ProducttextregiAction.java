package com.iinur.piece.action.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.ProductText;
import com.iinur.piece.model.ProducttextModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","p", "ignoreHierarchy","false"}),
})
public class ProducttextregiAction extends BaseAction {

	public ProductText p = null;
	
	public int pi;//piece_id
	public int ui;//user_id
	public String n;//name
	public int s;//status
	public String d;//data
	public String c;//comment
	
	public String execute(){
		
		if(pi>0 && !StringUtils.isEmpty(d)){
			ProducttextModel ptmodel = new ProducttextModel();
			p = ptmodel.registrationAll(pi, ui, s, d, c);
		}
		return SUCCESS;
	}
}
