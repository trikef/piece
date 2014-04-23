package com.iinur.piece.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.piece.data.FriendDao;
import com.iinur.piece.data.bean.Friend;
import com.iinur.piece.model.FriendModel;

public class IndexAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(IndexAction.class);

	public String execute(){
		this.logFlag = true;
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		return SUCCESS;
	}
}