package com.iinur.piece.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.util.PermissionUtils;
import com.iinur.core.util.TimestampUtils;
import com.iinur.piece.data.ProjectDao;
import com.iinur.piece.data.bean.GroupMember;
import com.iinur.piece.data.bean.Project;

public class ProjectModel {

	private static final Logger log = LoggerFactory
			.getLogger(ProjectModel.class);

	private ProjectDao pdao = null;
	
	public static final String MYPROJECT_TITLE = "マイプロジェクト";
	public static final String MYPROJECT_DESCRIPTION = "あなた専用のプロジェクトです。非公開設定にしてあるのでご自由にChatでメモをしたり、Taskでちょっとした用事などのToDo管理に使ってください";
	public static final String MYPROJECT_GOAL = "使い勝手が悪ければ「灯」プロジェクトにご連絡ください。改善しますよー";
	
	public static final String MYPROJECT_FAST_CHAT = MYPROJECT_DESCRIPTION;
	
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
	
	public Project registration(int user_id, String title, String description,
			String goal, String target_date) {

		Project p = null;
		Connection con = this.pdao.getConnection();
		try {
			con.setAutoCommit(false);

			this.pdao.insert(user_id, title, description, goal, TimestampUtils.parseDate(target_date));
			p = getNew(user_id);
			GroupMemberModel gmodel = new GroupMemberModel();
			gmodel.registration(user_id, p.getId(), 0, PermissionUtils.ALL);
			
			DbUtils.commitAndClose(con);
		} catch (ParseException e) {
			log.error(e.getMessage());

		} catch (SQLException e) {
			log.error(e.getMessage());
			DbUtils.rollbackAndCloseQuietly(con);
		}

		return p;
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
	
	public boolean permission(int project_id, int user_id, int action){
		Project p = this.pdao.getSingle(project_id);
		int permission = p.getPermission();
		String group = getGroup(project_id, user_id);
		return PermissionUtils.check(permission, group, action);
	}

	public String getGroup(int project_id, int user_id){
		Project p = this.pdao.getSingle(project_id);
		if(p.getUser_id()==user_id){
			return PermissionUtils.OWNER;
		} else {
			GroupMemberModel gm = new GroupMemberModel();
			GroupMember g = gm.get(user_id, project_id, 0);
			if(g != null){
				return PermissionUtils.GROUP;
			}
		}
		return PermissionUtils.OTHER;
	}
}
