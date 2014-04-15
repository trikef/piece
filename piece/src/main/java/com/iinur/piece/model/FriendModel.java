package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.FriendDao;
import com.iinur.piece.data.bean.Friend;

public class FriendModel {
	
	private FriendDao fdao = null;
	
	public FriendModel(){
		this.fdao = new FriendDao();
	}
	
	public void registration(int own_user_id, int friend_user_id, int status_id){
		this.fdao.insert(own_user_id, friend_user_id, status_id);
	}
	
	public void updateStatusId(int own_user_id, int friend_user_id, int status_id){
		this.fdao.update(own_user_id, friend_user_id, status_id);
	}
	
	public Friend get(int own_user_id, int friend_user_id){
		return this.fdao.get(own_user_id, friend_user_id);
	}
	
	public List<Friend> getList(int own_user_id){
		return this.fdao.getList(own_user_id);
	}
	
	public List<Friend> getList(int own_user_id, int status_id){
		return this.fdao.getList(own_user_id,status_id);
	}
	
	public List<Friend> getListSideFriend(int user_id, int status_id){
		return this.fdao.getListSideFriend(user_id, status_id);
	}
}
