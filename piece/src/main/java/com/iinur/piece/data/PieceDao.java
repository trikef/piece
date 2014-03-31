package com.iinur.piece.data;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.Piece;

public class PieceDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(PieceDao.class);

	public PieceDao() {
		super();
	}
	
	public int getNewId() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT max(id) FROM Piece");
		Integer p = null;
		try {
			ResultSetHandler<Integer> rsh = new ScalarHandler<Integer>();
			p = run.query(sql.toString(), rsh);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p.intValue();
	}

	public Piece getSingle(int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM Piece WHERE id=?");
		Piece p = null;
		try {
			ResultSetHandler<Piece> rsh = new BeanHandler<Piece>(Piece.class);
			p = run.query(sql.toString(), rsh, id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p;
	}
	
	public List<Piece> get(int project_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM Piece WHERE project_id=?");
		List<Piece> ps = null;
		try {
			ResultSetHandler<List<Piece>> rsh = new BeanListHandler<Piece>(Piece.class);
			ps = run.query(sql.toString(), rsh, project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}

	public List<Piece> getChild(int project_id, int parent_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id,p.project_id,p.title,p.description,p.goal,p.status_id,");
		sql.append("p.priority,p.img,p.url,p.target_date,p.created_at ");
		sql.append("FROM piece p ");
		sql.append("INNER JOIN piece_net pn ON p.id=pn.child_id ");
		sql.append("WHERE p.project_id=? ");
		sql.append("AND pn.parent_id=? ");

		List<Piece> ps = null;
		try {
			ResultSetHandler<List<Piece>> rsh = new BeanListHandler<Piece>(Piece.class);
			ps = run.query(sql.toString(), rsh, project_id, parent_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}

	public List<Piece> getParent(int project_id, int child_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id,p.project_id,p.title,p.description,p.goal,p.status_id,");
		sql.append("p.priority,p.img,p.url,p.target_date,p.created_at ");
		sql.append("FROM piece p ");
		sql.append("INNER JOIN piece_net pn ON p.id=pn.parent_id ");
		sql.append("WHERE p.project_id=? ");
		sql.append("AND pn.child_id=? ");

		List<Piece> ps = null;
		try {
			ResultSetHandler<List<Piece>> rsh = new BeanListHandler<Piece>(Piece.class);
			ps = run.query(sql.toString(), rsh, project_id, child_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}

	public void insert(int project_id, int user_id, String title, String description, String goal, Timestamp target_date){
		String sql = "INSERT INTO Piece (project_id,user_id,title,description,goal,target_date) VALUES (?,?,?,?,?,?)";
		try {
			run.update(sql,project_id,user_id,title,description,goal,target_date);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
