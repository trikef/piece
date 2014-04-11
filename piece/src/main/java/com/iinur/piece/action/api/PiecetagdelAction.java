package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.PieceTagModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","result", "ignoreHierarchy","false"}),
})
public class PiecetagdelAction extends BaseAction {

	public boolean result = false;
	
	public int ti;//tag_id
	public int pci;//piece_id
	public int i;//piece_tag_id
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		//TODO performance and id check
		if(ti>0 && pci>0 && i>0){
			PieceTagModel ptmodel = new PieceTagModel();
			ptmodel.delete(i);
			this.result=true;
			
			Piece p = new PieceModel().getSingle(pci);
			this.atlmodel.regiDelPieceTag(servletPath, uid, p.getProject_id(), pci, ti);
		}
		return SUCCESS;
	}
}
