package com.iinur.piece.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.data.bean.Project;
import com.iinur.piece.model.ChatModel;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.ProjectModel;

@Action(value="/project/{id:.+}",
results={@Result(name="success", location="project.jsp")}
)
public class ProjectAction extends BaseAction {

	public int id;
	public Project p;
	public List<Piece> pis;
	public List<Chat> cs;
	public List<Chat> cps;

	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		ProjectModel pmodel = new ProjectModel();
		this.p = pmodel.getSingle(id);
		
		PieceModel pimodel = new PieceModel();
		this.pis = pimodel.getChild(id, 0);
		
		ChatModel cmodel = new ChatModel();
		this.cs = cmodel.getList(id);
		this.cps = cmodel.getPinList(id);
		
		return SUCCESS;
	}
}
