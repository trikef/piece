package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.GroupMemberDao;
import com.iinur.piece.data.bean.GroupMember;

public class GroupMemberModel {

	private GroupMemberDao gdao = null;

	public GroupMemberModel(){
		this.gdao = new GroupMemberDao();
	}

	public boolean registration(int user_id, int project_id, int piece_id, int permission){
		boolean result = false;
		GroupMember g = this.gdao.get(user_id, project_id, piece_id);
		if(g==null){
			this.gdao.insert(user_id, project_id, piece_id, permission);
			result = true;
		}
		
		return result;
	}

	public GroupMember get(int user_id, int project_id, int piece_id){
		return this.gdao.get(user_id, project_id, piece_id);
	}

	public List<GroupMember> getList(int project_id, int piece_id){
		return this.gdao.getList(project_id,piece_id);
	}
	
	public void delete(int user_id, int project_id, int piece_id){
		this.gdao.delete(user_id, project_id, piece_id);
	}
}
