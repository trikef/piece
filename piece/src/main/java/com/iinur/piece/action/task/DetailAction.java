package com.iinur.piece.action.task;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.Product;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.ChatModel;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.PieceTagModel;
import com.iinur.piece.model.ProductModel;

@Action(value="/detail/{id:.+}",
results={@Result(name="success", location="detail.jsp")}
)
public class DetailAction extends BaseAction {

	public Piece p;
	public PieceWithPath piwp;
	public int id;
	public List<Product> ps;
	
	public List<Chat> cs;
	public List<Chat> cps;
	
	public List<Tag> pts;

	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		this.p = pmodel.getSingle(id);
		this.piwp = pmodel.getWithPath(id);
		
		ProductModel pdmodel = new ProductModel();
		this.ps = pdmodel.getList(id);

		ChatModel cmodel = new ChatModel();
		this.cs = cmodel.getList(p.getProject_id(),id);
		this.cps = cmodel.getPinList(p.getProject_id(),id);

		PieceTagModel ptmodel = new PieceTagModel();
		this.pts = ptmodel.getTags(id);

		this.acsmodel.regiPiece(this.servletPath, id, this.uid);//log
	
		return SUCCESS;
	}
}
