package com.iinur.piece.action.task;

import java.util.List;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.PieceTagModel;

public class IndexAction extends BaseAction {

	public List<Tag> ts;
	
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
	
		return SUCCESS;
	}
}
