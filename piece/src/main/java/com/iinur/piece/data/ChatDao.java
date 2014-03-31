package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.Chat;

public class ChatDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(ChatDao.class);

	public ChatDao() {
		super();
	}
	
	public Chat get(int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.user_id,c.text,c.created_at,u.name FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.id=? ");
		
		Chat c = null;
		try {
			ResultSetHandler<Chat> rsh = new BeanHandler<Chat>(Chat.class);
			c = run.query(sql.toString(), rsh, id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return c;
	}
	
	public Chat getNew(int project_id, int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.user_id,c.text,c.created_at,u.name FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.project_id=? AND c.user_id=? ");
		sql.append("ORDER BY c.id DESC ");
		sql.append("LIMIT 1");
		
		Chat c = null;
		try {
			ResultSetHandler<Chat> rsh = new BeanHandler<Chat>(Chat.class);
			c = run.query(sql.toString(), rsh, project_id, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return c;
	}
	
	public List<Chat> getList(int project_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.user_id,c.text,c.created_at,u.name FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.project_id=? ");
		sql.append("ORDER BY c.id ASC");
		
		List<Chat> cs = null;
		try {
			ResultSetHandler<List<Chat>> rsh = new BeanListHandler<Chat>(Chat.class);
			cs = run.query(sql.toString(), rsh, project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return cs;
	}
	
	public List<Chat> getPinList(int project_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.user_id,c.text,c.created_at,u.name FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.project_id=? ");
		sql.append("AND c.priority is not null ");
		sql.append("ORDER BY c.priority ASC, c.id ASC");
		
		List<Chat> cs = null;
		try {
			ResultSetHandler<List<Chat>> rsh = new BeanListHandler<Chat>(Chat.class);
			cs = run.query(sql.toString(), rsh, project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return cs;
	}
	
	public void insert(int project_id, int user_id, String text){
		String sql = "INSERT INTO chat (project_id,user_id,text) VALUES (?,?,?)";
		try {
			run.update(sql,project_id,user_id,text);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void updateText(int id, String text){
		String sql = "UPDATE chat SET text=? WHERE id=?";
		try {
			run.update(sql,text,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}

	public void updatePriority(int id, int priority){
		String sql = "UPDATE chat SET priority=? WHERE id=?";
		try {
			run.update(sql,priority,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
