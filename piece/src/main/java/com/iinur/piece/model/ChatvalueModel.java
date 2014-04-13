package com.iinur.piece.model;

import com.iinur.piece.data.ChatvalueDao;

public class ChatvalueModel {

	private ChatvalueDao cdao = null;
	public boolean contains = false;
	public static final int REGI = 1;
	public static final int DEL = 0;
	
	public ChatvalueModel(){
		cdao = new ChatvalueDao();
	}

	public void registration(int chatId, int userId, int good, int bad){
		
		if(cdao.containsKey(chatId, userId) == 0){
			this.contains = true;
			cdao.insert(chatId, userId, good, bad);
			
		}
	}
	
	public int toggle(int chatId, int userId, int good, int bad){
		
		if(cdao.containsKey(chatId, userId) == 0){
			this.contains = true;
			cdao.insert(chatId, userId, good, bad);
			return REGI;
		}
		cdao.delete(chatId, userId);
		return DEL;
	}
}
