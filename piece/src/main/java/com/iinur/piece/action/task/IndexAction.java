package com.iinur.piece.action.task;

import java.util.List;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.PieceTagModel;

public class IndexAction extends BaseAction {

	public static final String DEFAULT_TOP_VIEW_TAG_NAME = "未経験者歓迎";
	public static final int DEFAULT_TOP_VIEW_TAG_LIMIT = 3;
	public String topViewTagName = DEFAULT_TOP_VIEW_TAG_NAME;
	public List<Tag> ts;
	public List<PieceWithPath> pstp;
	//public Tag t1;
	//public Tag t2;
	
	//private static final String T1_KEY = "システム";
	//private static final String T2_KEY = "オフィスワーク";

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
		
		PieceModel pmodel = new PieceModel();
		this.pstp = pmodel.searchFromTagName(DEFAULT_TOP_VIEW_TAG_NAME,DEFAULT_TOP_VIEW_TAG_LIMIT);
		
		//TODO easy navi tag 
		//this.t1 = ptmodel.getTagFromName(T1_KEY);
		//this.t2 = ptmodel.getTagFromName(T2_KEY);
	
		return SUCCESS;
	}
}
