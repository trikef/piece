package com.iinur.piece.action.task;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.PieceTagModel;

public class TagAction extends BaseAction {

	public List<PieceWithPath> piwps;
	public List<Tag> ts;
	
	public String q;
	public int ti;

	public String execute(){
		this.logFlag=true;//log
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		if(!StringUtils.isEmpty(q)){
			this.piwps = pmodel.serach(q);
		} else if(ti>0){
			this.piwps = pmodel.searchFromTagId(ti);
		} else {
			this.piwps = pmodel.serach(q);
		}
		PieceTagModel ptmodel = new PieceTagModel();
		this.ts = ptmodel.getAllTagsWithPieceCount();
	
		return SUCCESS;
	}
}
