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
		sql.append("SELECT c.id,c.project_id,c.piece_id,c.user_id,c.text,c.priority,c.created_at,u.name,cv.good,cv.bad FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("LEFT JOIN (");
		sql.append("SELECT chat_id,sum(good) as good,sum(bad) as bad FROM chat_value GROUP BY chat_id");
		sql.append(") cv ON c.id = cv.chat_id ");
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
	
	public Chat getNew(int project_id, int piece_id, int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.piece_id,c.user_id,c.text,c.priority,c.created_at,u.name FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.project_id=? AND c.piece_id=? AND c.user_id=? ");
		sql.append("ORDER BY c.id DESC ");
		sql.append("LIMIT 1");
		
		Chat c = null;
		try {
			ResultSetHandler<Chat> rsh = new BeanHandler<Chat>(Chat.class);
			c = run.query(sql.toString(), rsh, project_id, piece_id, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return c;
	}
	
	public List<Chat> getList(int project_id, int piece_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.piece_id,c.user_id,c.text,c.priority,c.created_at,u.name,cv.good,cv.bad FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("LEFT JOIN (");
		sql.append("SELECT chat_id,sum(good) as good,sum(bad) as bad FROM chat_value GROUP BY chat_id");
		sql.append(") cv ON c.id = cv.chat_id ");
		sql.append("WHERE c.project_id=? AND c.piece_id=? ");
		sql.append("ORDER BY c.id DESC");
		
		List<Chat> cs = null;
		try {
			ResultSetHandler<List<Chat>> rsh = new BeanListHandler<Chat>(Chat.class);
			cs = run.query(sql.toString(), rsh, project_id, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return cs;
	}
	
	public List<Chat> getPinList(int project_id, int piece_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.piece_id,c.user_id,c.text,c.priority,c.created_at,u.name FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.project_id=? AND c.piece_id=? ");
		sql.append("AND c.priority>0 ");
		sql.append("ORDER BY c.priority ASC, c.id ASC");
		
		List<Chat> cs = null;
		try {
			ResultSetHandler<List<Chat>> rsh = new BeanListHandler<Chat>(Chat.class);
			cs = run.query(sql.toString(), rsh, project_id, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return cs;
	}
	
	public List<Chat> getGoodList(int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,pj.title as project_title,c.piece_id,c.user_id,c.text,c.priority,c.created_at,u.name FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("INNER JOIN project pj ON c.project_id = pj.id ");
		sql.append("WHERE exists (SELECT * FROM chat_value cv WHERE cv.user_id=? AND cv.good>0 AND cv.chat_id=c.id) ");
		sql.append("ORDER BY c.created_at DESC");
		
		List<Chat> cs = null;
		try {
			ResultSetHandler<List<Chat>> rsh = new BeanListHandler<Chat>(Chat.class);
			cs = run.query(sql.toString(), rsh, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return cs;
	}
	
	public List<Chat> getListUnread(int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.project_id,c.piece_id,c.user_id,c.text,c.priority,c.created_at,");
		sql.append("u.name,cv.good,cv.bad,pj.title project_title FROM chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("LEFT JOIN (");
		sql.append("SELECT chat_id,sum(good) as good,sum(bad) as bad FROM chat_value GROUP BY chat_id");
		sql.append(") cv ON c.id = cv.chat_id ");
		sql.append("LEFT JOIN project pj ON c.project_id=pj.id ");
		
		sql.append("WHERE c.user_id<>? AND exists (SELECT * FROM ");
		sql.append("(SELECT * FROM action_log WHERE action_name='NEW CHAT') atl ");
		sql.append("LEFT JOIN (SELECT project_id,piece_id,max(created_at) as created_at "); 
		sql.append("FROM access_log WHERE user_id=? GROUP BY project_id,piece_id) acl ");
		sql.append("ON atl.project_id=acl.project_id AND atl.piece_id=acl.piece_id ");
		sql.append("WHERE (atl.created_at>acl.created_at OR (atl.created_at is not null AND acl.created_at is null)) ");
		sql.append("AND atl.chat_id=c.id) ");

		sql.append("AND (exists (SELECT * FROM access_log alo LEFT JOIN project po ON alo.project_id=po.id WHERE (po.permission-((po.permission/10)*10))&4=4 AND po.id=c.project_id AND alo.user_id=?) ");//other permission
		sql.append("OR exists (SELECT * FROM group_member gm WHERE gm.user_id=? AND gm.project_id=c.project_id AND gm.piece_id=0)) ");//group permission
//TODO add permission piece

		sql.append("ORDER BY c.id DESC");
		
		List<Chat> cs = null;
		try {
			ResultSetHandler<List<Chat>> rsh = new BeanListHandler<Chat>(Chat.class);
			cs = run.query(sql.toString(), rsh, user_id,user_id,user_id,user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return cs;
	}

	public void insert(int project_id, int piece_id, int user_id, String text){
		String sql = "INSERT INTO chat (project_id,piece_id,user_id,text) VALUES (?,?,?,?)";
		try {
			run.update(sql,project_id,piece_id,user_id,text);
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
