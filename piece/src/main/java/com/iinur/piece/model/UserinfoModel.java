package com.iinur.piece.model;

import com.iinur.piece.data.UserinfoDao;
import com.iinur.piece.data.bean.Project;
import com.iinur.piece.data.bean.Userinfo;

public class UserinfoModel {

	private UserinfoDao udao = null;
	
	public UserinfoModel(){
		this.udao = new UserinfoDao();
	}
	public boolean registration(String name){
		boolean flag = false;
		Userinfo u = udao.get(name);
		if(u == null){
			udao.insert(name);
			Userinfo ui = udao.get(name);
			ProjectModel pmodel = new ProjectModel();
			pmodel.registration(ui.getId(), ProjectModel.MYPROJECT_TITLE, 
					ProjectModel.MYPROJECT_DESCRIPTION, ProjectModel.MYPROJECT_GOAL, null);
			Project project = pmodel.getNew(ui.getId());
			ChatModel cmodel = new ChatModel();
			cmodel.registration(project.getId(), 0, ui.getId(), ProjectModel.MYPROJECT_FAST_CHAT);
			flag = true;
		}
		return flag;
	}
	
	public Userinfo get(String name){
		return udao.get(name);
	}
}
