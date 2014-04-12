package com.iinur.piece.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.model.PieceModel;

@Results({
	  @Result(name="error", location="pieceupdateinput.jsp")
	})
public class PieceupdateAction extends BaseAction {

	public int prd;
	public int pcd;
	public String title;
	public String description;
	public String goal;
	public String target_date;
	
	public String msg;
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		if(target_date != null){
			boolean regi = pmodel.update(pcd, title, description, goal, target_date);
			if(!regi){
				this.msg = ERROR;
				return ERROR;
			}
		}
		this.atlmodel.regiUpdatePiece(servletPath, uid, prd, pcd);
		this.acsmodel.regiPiece(servletPath, pcd, uid);
		
		return SUCCESS;
	}
}
