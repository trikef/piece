package com.iinur.piece.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.model.PieceModel;

@Action(value="/pieceupdateinput/{id:.+}",
results={@Result(name="success", location="pieceupdateinput.jsp")}
)
public class PieceupdateinputAction extends BaseAction {

	public int id;

	public Piece p;

	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		
		PieceModel pmodel = new PieceModel();
		this.p = pmodel.getSingle(id);
		
		this.acsmodel.regiPiece(servletPath, id, uid);
		
		return SUCCESS;
	}
}
