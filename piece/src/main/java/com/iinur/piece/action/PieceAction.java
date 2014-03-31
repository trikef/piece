package com.iinur.piece.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.model.PieceModel;

@Action(value="/piece/{id:.+}",
results={@Result(name="success", location="piece.jsp")}
)
public class PieceAction extends BaseAction {

	public Piece p;
	public int id;
	public List<Piece> pis;//child_piece
	public List<Piece> pips;//parent_piece
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		this.p = pmodel.getSingle(id);
		
		PieceModel pimodel = new PieceModel();
		this.pis = pimodel.getChild(this.p.getProject_id(), id);
		this.pips = pimodel.getParent(this.p.getProject_id(), id);

		return SUCCESS;
	}
}
