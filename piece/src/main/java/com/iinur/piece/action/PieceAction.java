package com.iinur.piece.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.Product;
import com.iinur.piece.model.ChatModel;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.ProductModel;

@Action(value="/piece/{id:.+}",
results={@Result(name="success", location="piece.jsp")}
)
public class PieceAction extends BaseAction {

	public Piece p;
	public PieceWithPath piwp;
	public int id;
	//public List<Piece> pis;//child_piece
	//public List<Piece> pips;//parent_piece
	public List<PieceWithPath> piwps;
	public List<Product> ps;
	
	public List<Chat> cs;
	public List<Chat> cps;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		this.p = pmodel.getSingle(id);
		this.piwp = pmodel.getWithPath(id);
		//this.pis = pmodel.getChild(this.p.getProject_id(), id);
		//this.pips = pmodel.getParent(this.p.getProject_id(), id);
		this.piwps = pmodel.getListWithPath(this.p.getProject_id(), id);
		
		ProductModel pdmodel = new ProductModel();
		this.ps = pdmodel.getList(id);

		ChatModel cmodel = new ChatModel();
		this.cs = cmodel.getList(p.getProject_id(),id);
		this.cps = cmodel.getPinList(p.getProject_id(),id);
		
		return SUCCESS;
	}
}
