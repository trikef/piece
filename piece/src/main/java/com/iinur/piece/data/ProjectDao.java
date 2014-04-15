package com.iinur.piece.data;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.Project;

public class ProjectDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);

	public ProjectDao() {
		super();
	}
	
	public Project getSingle(int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM project WHERE id=?");
		Project p = null;
		try {
			ResultSetHandler<Project> rsh = new BeanHandler<Project>(Project.class);
			p = run.query(sql.toString(), rsh, id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p;
	}
	
	public Project getNew(int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM project WHERE user_id=? ORDER BY created_at DESC LIMIT 1");
		Project p = null;
		try {
			ResultSetHandler<Project> rsh = new BeanHandler<Project>(Project.class);
			p = run.query(sql.toString(), rsh, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p;
	}
	
	public List<Project> get(int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM project p ");
		 
		sql.append("LEFT JOIN ");
		sql.append("(SELECT ");
		sql.append("atl.project_id,atl.last_at>acl.last_at as unread ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("project_id,max(created_at) as last_at ");
		sql.append("FROM action_log ");
		sql.append("WHERE user_id <> ? ");
		sql.append("GROUP BY project_id) atl ");
		sql.append("LEFT JOIN ");
		sql.append("(SELECT ");
		sql.append("project_id,max(created_at) as last_at ");
		sql.append("FROM access_log ");
		sql.append("WHERE user_id=? ");
		sql.append("GROUP BY project_id) acl ");
		sql.append("ON atl.project_id=acl.project_id) l ");
		sql.append("ON p.id=l.project_id ");

		sql.append("WHERE exists (SELECT * FROM group_member gm WHERE gm.user_id=? AND gm.piece_id=0 AND gm.project_id=p.id) ");
		sql.append("OR p.user_id=? OR (p.permission-((p.permission/10)*10))&4=4 ");

		List<Project> ps = null;
		try {
			ResultSetHandler<List<Project>> rsh = new BeanListHandler<Project>(Project.class);
			log.debug("List<Project> get(int user_id):"+sql.toString());
			ps = run.query(sql.toString(), rsh, user_id,user_id,user_id,user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}

	public void insert(int user_id, String title, String description, String goal, Timestamp target_date){
		String sql = "INSERT INTO project (user_id,title,description,goal,target_date) VALUES (?,?,?,?,?)";
		try {
			run.update(sql,user_id,title,description,goal,target_date);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void update(int project_id, String title, String description, String goal, Timestamp target_date){
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE project ");
		sql.append("SET title=?, ");
		sql.append("description=?, ");
		sql.append("goal=?, ");
		sql.append("target_date=? ");
		sql.append("WHERE id=? ");

		try {
			run.update(sql.toString(),title,description,goal,target_date,project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void updatePermissionOther(int project_id, int action){
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE project SET permission= ");
		sql.append("cast(substring(cast(permission as text) from 1 for 2)|| ");
		sql.append("cast(? as text) ");
		sql.append("as INTEGER) WHERE id=? ");
		try {
			run.update(sql.toString(),action,project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void updatePermissionPlusOther(int project_id, int action){
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE project SET permission= ");
		sql.append("cast(substring(cast(permission as text) from 1 for 2)|| ");
		sql.append("cast(cast(substring(cast(permission as text) from 3 for 1) as INTEGER)|? as text) ");
		sql.append("as INTEGER) WHERE id=? ");
		try {
			run.update(sql.toString(),action,project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
