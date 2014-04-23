package com.iinur.piece.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.model.ChatModel;

public class FavAction extends BaseAction {

	private static final Logger log = LoggerFactory.getLogger(FavAction.class);

	public List<Chat> fcs;

	public String execute(){
		this.logFlag = true;
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		ChatModel cmodel = new ChatModel();
		this.fcs = cmodel.getGoodList(uid);

		return SUCCESS;
	}
}
