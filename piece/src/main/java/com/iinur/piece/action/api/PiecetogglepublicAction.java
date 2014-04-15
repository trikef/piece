package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.core.util.PermissionUtils;
import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.model.PieceModel;

@ParentPackage("json-default")

//Actionクラスの結果。type=jsonでJSON形式
@Results({
@Result(name="success" , type="json" ,
       params={"root","piece", "ignoreHierarchy","false"}),
})
public class PiecetogglepublicAction extends BaseAction{

	public int i;//piece_id
	//public String g;//group
	//public int a;//action
	
	public Piece piece;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		Piece p = pmodel.getSingle(i);
		String group = pmodel.getGroup(i, uid);
		if(PermissionUtils.check(p.getPermission(), group, PermissionUtils.WRITE)){
			if(PermissionUtils.check(
					p.getPermission(), 
					PermissionUtils.OTHER, 
					PermissionUtils.WRITE)){
				pmodel.updatePermission(i, PermissionUtils.OTHER, PermissionUtils.NONE);
				
				this.atlmodel.regiPrivatePiece(servletPath, uid, p.getProject_id(), i);//log
			} else {
				pmodel.updatePermission(i, PermissionUtils.OTHER, PermissionUtils.ALL);
				
				this.atlmodel.regiPublicPiece(servletPath, uid, p.getProject_id(), i);//log
			}
			this.piece = pmodel.getSingle(i);
		}
		
		return SUCCESS;
	}
	
}
