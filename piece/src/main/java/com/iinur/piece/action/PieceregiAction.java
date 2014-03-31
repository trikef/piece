package com.iinur.piece.action;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.PiecenetModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","p", "ignoreHierarchy","false"}),
})
public class PieceregiAction extends BaseAction {

	public Piece p;
	
	public int pai;//parent_id
	public int pi;//Piece_id
	public String t;//title
	public String d;//description
	public String g;//goal
	public String td;//target_date
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		if(td != null){
			int regi = pmodel.registration(pi, uid, t, d, g, td);
			if(regi == 0){
				this.p = new Piece();
				this.p.setId(0);
				//return ERROR;
			} else {
				this.p = pmodel.getSingle(regi);
				PiecenetModel pnmodel = new PiecenetModel();
				pnmodel.registration(pi, pai, this.p.getId());
			}
		}
		return SUCCESS;
	}
}
