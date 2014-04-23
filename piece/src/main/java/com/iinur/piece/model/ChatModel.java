package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.ChatDao;
import com.iinur.piece.data.bean.Chat;

public class ChatModel {

	private ChatDao cdao = null;
	
	public ChatModel(){
		this.cdao = new ChatDao();
	}

	public void registration(int project_id, int piece_id, int user_id, String text){
		this.cdao.insert(project_id, piece_id, user_id, text);
	}
	
	public void updatePriority(int id, int priority){
		this.cdao.updatePriority(id, priority);
	}
	
	public void updateText(int id, String text){
		this.cdao.updateText(id, text);
	}
	
	public Chat get(int id){
		return this.cdao.get(id);
	}

	public Chat getNew(int project_id, int piece_id, int user_id){
		return this.cdao.getNew(project_id, piece_id, user_id);
	}
	
	public List<Chat> getList(int project_id, int piece_id){
		return this.cdao.getList(project_id, piece_id);
	}
	
	public List<Chat> getPinList(int project_id, int piece_id){
		return this.cdao.getPinList(project_id, piece_id);
	}
	
	public List<Chat> getGoodList(int user_id){
		return this.cdao.getGoodList(user_id);
	}
	
	public List<Chat> getListUnread(int user_id){
		return this.cdao.getListUnread(user_id);
	}
}
