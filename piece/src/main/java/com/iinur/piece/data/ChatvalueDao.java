package com.iinur.piece.data;

import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;

public class ChatvalueDao extends BaseDao{

	private static final Logger log = LoggerFactory.getLogger(ChatvalueDao.class);

	public ChatvalueDao() {
		super();
	}
	public int containsKey(int chatId, int userId){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("count(*) as c ");
		sql.append("FROM chat_value ");
		sql.append("WHERE chat_id = ? AND user_id = ?");

		int a = 0;
		try {
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
			a = run.query(sql.toString(), rsh, chatId, userId).intValue();
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return a;
	}

	public void insert(int chatId, int userId, int good, int bad){
		String sql = "INSERT INTO chat_value (chat_id, user_id, good, bad) VALUES (?,?,?,?)";
		try {
			run.update(sql,chatId, userId, good, bad);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
