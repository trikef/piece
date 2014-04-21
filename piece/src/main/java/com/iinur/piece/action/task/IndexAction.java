package com.iinur.piece.action.task;

import java.util.List;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.PieceTagModel;

public class IndexAction extends BaseAction {

	public List<Tag> ts;
	public Tag t1;
	public Tag t2;
	
	private static final String T1_KEY = "システム";
	private static final String T2_KEY = "オフィスワーク";

	public String q;
	public int ti;

	public String execute(){
		this.logFlag=true;//log
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}

		PieceTagModel ptmodel = new PieceTagModel();
		this.ts = ptmodel.getAllTagsWithPieceCount();
		
		//TODO easy navi tag 
		//this.t1 = ptmodel.getTagFromName(T1_KEY);
		//this.t2 = ptmodel.getTagFromName(T2_KEY);
	
		return SUCCESS;
	}
}
