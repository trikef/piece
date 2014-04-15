package com.iinur.piece.data;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;

public class ActionLogDao extends BaseDao {

	private static final Logger log = LoggerFactory
			.getLogger(ActionLogDao.class);

	public ActionLogDao() {
		super();
	}

	public void insert(String url, String action_name, int user_id,
			int project_id, int piece_id, int product_id, int chat_id,
			int product_chat_id, int tag_id, int target_user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO action_log ");
		sql.append("(url,action_name,user_id,project_id,piece_id,product_id,chat_id,product_chat_id,tag_id,target_user_id) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?)");
		try {
			run.update(sql.toString(), url, action_name, user_id, project_id,
					piece_id, product_id, chat_id, product_chat_id, tag_id, target_user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
