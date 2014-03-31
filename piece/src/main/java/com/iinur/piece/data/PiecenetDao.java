package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.Piecenet;

public class PiecenetDao extends BaseDao {
	
	private static final Logger log = LoggerFactory.getLogger(PiecenetDao.class);

	public PiecenetDao() {
		super();
	}
	
	public List<Piecenet> getWhereProject(int project_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM piece_net WHERE project_id=?");
		List<Piecenet> ps = null;
		try {
			ResultSetHandler<List<Piecenet>> rsh = new BeanListHandler<Piecenet>(Piecenet.class);
			ps = run.query(sql.toString(), rsh, project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}
	
	public List<Piecenet> getChild(int parent_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM piece_net WHERE parent_id=?");
		List<Piecenet> ps = null;
		try {
			ResultSetHandler<List<Piecenet>> rsh = new BeanListHandler<Piecenet>(Piecenet.class);
			ps = run.query(sql.toString(), rsh, parent_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}

	public void insert(int project_id, int parent_id, int child_id){
		String sql = "INSERT INTO piece_net (project_id,parent_id,child_id) VALUES (?,?,?)";
		try {
			run.update(sql,project_id,parent_id,child_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
