package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.model.PieceModel;

@ParentPackage("json-default")

//Actionクラスの結果。type=jsonでJSON形式
@Results({
@Result(name="success" , type="json" ,
       params={"root","piece", "ignoreHierarchy","false"}),
})
public class PiecedisplayAction extends BaseAction{

	public int i;//piece_id
	public boolean d;//display
	
	public Piece piece;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		if(pmodel.permissionExecute(i, uid)){
			pmodel.updateDisplay(i, d);
			this.piece = pmodel.getSingle(i);
			
			if(!d){
				this.atlmodel.regiDelPiece(servletPath, uid, i);//log
			}
		}

		return SUCCESS;
	}
	
}
