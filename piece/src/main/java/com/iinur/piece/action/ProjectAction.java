package com.iinur.piece.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.data.FriendDao;
import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.data.bean.Friend;
import com.iinur.piece.data.bean.GroupMember;
import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.Project;
import com.iinur.piece.model.ChatModel;
import com.iinur.piece.model.FriendModel;
import com.iinur.piece.model.GroupMemberModel;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.ProjectModel;

@Action(value="/project/{id:.+}",
results={@Result(name="success", location="project.jsp")}
)
public class ProjectAction extends BaseAction {

	public int id;
	public Project p;
	public List<PieceWithPath> piwps;
	public List<Chat> cs;
	public List<Chat> cps;
	
	public GroupMember g;
	public List<GroupMember> gs;
	
	public List<Friend> fs;
	
	private static final int PROJECT_NODE_PIECE_ID = 0;

	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		ProjectModel pmodel = new ProjectModel();
		this.p = pmodel.getSingle(id);
		
		PieceModel pimodel = new PieceModel();
		this.piwps = pimodel.getListWithPath(id, 0);
		
		ChatModel cmodel = new ChatModel();
		this.cs = cmodel.getList(id,PROJECT_NODE_PIECE_ID);
		this.cps = cmodel.getPinList(id,PROJECT_NODE_PIECE_ID);
		
		GroupMemberModel gmodel = new GroupMemberModel();
		this.g = gmodel.get(uid, id, 0);
		this.gs = gmodel.getList(id, 0);
		
		FriendModel fmodel = new FriendModel();
		this.fs = fmodel.getList(uid, FriendDao.STATUS_PERMISSION);
		
		this.acsmodel.regiProject(this.servletPath, id, this.uid);//log

		return SUCCESS;
	}
}
