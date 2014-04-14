package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.PieceTagModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","t", "ignoreHierarchy","false"}),
})
public class PiecetagregiAction extends BaseAction {

	public Tag t = null;
	
	public int ti;//tag_id
	public int pci;//piece_id
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		
		if(ti>0 && pci>0){
			PieceTagModel ptmodel = new PieceTagModel();
			this.t = ptmodel.getTag(pci, ti);
			if(this.t==null){
				ptmodel.registration(uid, pci, ti);
				this.t = ptmodel.getNewTag(uid, pci, ti);
				
				Piece p = new PieceModel().getSingle(pci);
				this.atlmodel.regiNewPieceTag(servletPath, uid, p.getProject_id(), pci, ti);
			}
		}
		return SUCCESS;
	}
}
