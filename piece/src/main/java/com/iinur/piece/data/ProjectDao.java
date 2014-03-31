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
	
	public List<Project> get(int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM project WHERE user_id=?");
		List<Project> ps = null;
		try {
			ResultSetHandler<List<Project>> rsh = new BeanListHandler<Project>(Project.class);
			ps = run.query(sql.toString(), rsh, user_id);
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
}
