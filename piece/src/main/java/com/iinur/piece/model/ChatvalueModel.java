package com.iinur.piece.model;

import com.iinur.piece.data.ChatvalueDao;

public class ChatvalueModel {

	public boolean contains = false;
	public void registration(int chatId, int userId, int good, int bad){
		
		ChatvalueDao cdao = new ChatvalueDao();
		
		if(cdao.containsKey(chatId, userId) == 0){
			this.contains = true;
			cdao.insert(chatId, userId, good, bad);
			
		}
	}
}
