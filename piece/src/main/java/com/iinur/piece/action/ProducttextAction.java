package com.iinur.piece.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.ProductChat;
import com.iinur.piece.data.bean.ProductText;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.ProductChatModel;
import com.iinur.piece.model.ProducttextModel;

@Actions({
		@Action(value="/task/producttext/{id:.+}",
		results={}
		),
		@Action(value="/producttext/{id:.+}",
		results={@Result(name="success", location="producttext.jsp")
		,@Result(name="task", location="task/producttext.jsp")}
		)
})
public class ProducttextAction extends BaseAction {

	private static String RESULT_TASK = "task";
	public int id;
	
	public ProductText pt;
	public PieceWithPath piwp;
	public List<ProductChat> pcs;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		ProducttextModel ptmodel = new ProducttextModel();
		this.pt = ptmodel.get(id);

		PieceModel pmodel = new PieceModel();
		this.piwp = pmodel.getWithPath(pt.getPiece_id());

		ProductChatModel pcmodel = new ProductChatModel();
		this.pcs = pcmodel.getList(pt.getId());
		
		this.acsmodel.regiProduct(this.servletPath, id, this.uid);//log
		
		if(this.servletPath.startsWith("/task/producttext/")){
			return RESULT_TASK;
		}
		return SUCCESS;
	}
}
