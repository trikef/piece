package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.AccessLog;

public class AccessLogDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(AccessLogDao.class);

	public AccessLogDao() {
		super();
	}
	
	public List<AccessLog> getListFromUserId(int user_id, int limit) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("al.id,al.url,al.user_id,al.project_id,al.piece_id,al.product_id,al.created_at,COALESCE(pc.title,pj.title) as title ");
		sql.append("FROM access_log al ");
		sql.append("INNER JOIN project pj ON al.project_id=pj.id ");
		sql.append("LEFT JOIN piece pc ON al.piece_id=pc.id AND al.project_id=pc.project_id ");
		sql.append("LEFT JOIN product pd ON al.product_id=pd.id AND al.piece_id=pd.piece_id ");
		sql.append("WHERE al.user_id=? ");
		sql.append("AND al.id in (SELECT max(id) FROM access_log GROUP BY url) ");
		sql.append("ORDER BY al.created_at DESC ");
		sql.append("LIMIT ?");
		
		List<AccessLog> as = null;
		try {
			ResultSetHandler<List<AccessLog>> rsh = new BeanListHandler<AccessLog>(AccessLog.class);
			as = run.query(sql.toString(), rsh, user_id,limit);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return as;
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
