package com.iinur.piece.data;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;

public class AccessLogDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(AccessLogDao.class);

	public AccessLogDao() {
		super();
	}
	
	public void insert(String url, int project_id, int piece_id, int product_id, int user_id){
		String sql = "INSERT INTO access_log (url,project_id,piece_id,product_id,user_id) VALUES (?,?,?,?,?)";
		try {
			run.update(sql,url,project_id,piece_id,product_id,user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
