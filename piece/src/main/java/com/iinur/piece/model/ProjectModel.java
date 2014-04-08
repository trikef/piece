package com.iinur.piece.model;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.util.PermissionUtils;
import com.iinur.core.util.TimestampUtils;
import com.iinur.piece.data.ProjectDao;
import com.iinur.piece.data.bean.Project;

public class ProjectModel {

	private static final Logger log = LoggerFactory
			.getLogger(ProjectModel.class);

	private ProjectDao pdao = null;
	
	public ProjectModel(){
		this.pdao = new ProjectDao();
	}
	public Project getSingle(int id){
		return this.pdao.getSingle(id);
	}
	
	public Project getNew(int user_id){
		return this.pdao.getNew(user_id);
	}
	
	public List<Project> get(int user_id){
		return this.pdao.get(user_id);
	}
	
	public boolean registration(int user_id, String title, String description,
			String goal, String target_date) {

		boolean result = true;
		try {
			this.pdao.insert(user_id, title, description, goal, TimestampUtils.parseDate(target_date));
		} catch (ParseException e) {
			log.error(e.getMessage());
			result = false;
		}
		return result;
	}
	
	public boolean update(int project_id, String title, String description,
			String goal, String target_date) {

		boolean result = true;
		try {
			this.pdao.update(project_id, title, description, goal, TimestampUtils.parseDate(target_date));
		} catch (ParseException e) {
			log.error(e.getMessage());
			result = false;
		}
		return result;
	}
	
	public void updatePermission(int project_id, String group, int action){
		if(group.equals(PermissionUtils.OTHER)){
			this.pdao.updatePermissionOther(project_id, action);
		}
	}
	
	public String getGroup(int project_id, int user_id){
		Project p = this.pdao.getSingle(project_id);
		if(p.getUser_id()==user_id){
			return PermissionUtils.OWNER;
		}
		//TODO return PermissionUtils.GROUP;
		return PermissionUtils.OTHER;
	}
}
