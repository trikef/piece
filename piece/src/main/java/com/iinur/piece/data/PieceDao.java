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
import com.iinur.piece.data.bean.PieceWithPath;

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
	
	public PieceWithPath getPieceWithPath(int id){
		StringBuffer sql = new StringBuffer();
		sql.append("WITH RECURSIVE rec(id,pid,path,path_title) as ( ");
		sql.append("SELECT child_id, parent_id,array[parent_id],array[p.title] FROM piece_net pn ");
		sql.append("INNER JOIN piece pc ON pn.child_id=pc.id ");
		sql.append("LEFT join piece p ON pn.parent_id = p.id ");
		sql.append("WHERE parent_id=0 AND exists (SELECT project_id FROM piece bp WHERE bp.id=? AND bp.project_id=pc.project_id) ");
		sql.append("UNION ALL ");
		sql.append("SELECT b.child_id,b.parent_id,path||b.parent_id,path_title||title FROM rec a JOIN  ");
		sql.append("(SELECT pn2.child_id,pn2.parent_id,p2.title FROM piece_net pn2  ");
		sql.append("LEFT JOIN piece p2 ON pn2.parent_id = p2.id) b ");
		sql.append("ON a.id=b.parent_id) ");
		sql.append("SELECT r.id,p3.project_id,p3.user_id,p3.title,p3.description,p3.goal,p3.target_date,r.pid as parent_id,r.path,r.path_title,array_upper(r.path,1) as LV ");
		sql.append("FROM rec r ");
		sql.append("LEFT JOIN piece p3 ON r.id=p3.id ");
		sql.append("WHERE r.id=? ");
		
		PieceWithPath p = null;
		try {
			ResultSetHandler<PieceWithPath> rsh = new BeanHandler<PieceWithPath>(PieceWithPath.class);
			String sqlStr = sql.toString();
			log.debug("getPieceWithPathList sql::"+sqlStr);
			p = run.query(sql.toString(), rsh, id, id);
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
	
	public List<PieceWithPath> getPieceWithPathList(int project_id, int id){
		StringBuffer sql = new StringBuffer();

		//insert into piece (id,project_id,user_id,title,description,goal) values(0,0,0,'プロジェクト','-','-');
		sql.append("WITH RECURSIVE rec(id,pid,path,path_title) as ( ");
		sql.append("SELECT child_id, parent_id,array[parent_id],array[p.title] FROM piece_net pn ");
		sql.append("INNER JOIN piece pc ON pn.child_id=pc.id ");
		sql.append("LEFT join piece p ON pn.parent_id = p.id ");
		sql.append("WHERE parent_id=0 AND pc.project_id=? ");
		sql.append("UNION ALL ");
		sql.append("SELECT b.child_id,b.parent_id,path||b.parent_id,path_title||title FROM rec a JOIN  ");
		sql.append("(SELECT pn2.child_id,pn2.parent_id,p2.title FROM piece_net pn2  ");
		sql.append("LEFT JOIN piece p2 ON pn2.parent_id = p2.id) b ");
		sql.append("ON a.id=b.parent_id) ");
		sql.append("SELECT r.id,p3.project_id,p3.user_id,p3.title,p3.description,p3.goal,p3.target_date,r.pid as parent_id,r.path,r.path_title,array_upper(r.path,1) as LV ");
		sql.append("FROM rec r ");
		sql.append("LEFT JOIN piece p3 ON r.id=p3.id ");
		sql.append("WHERE not exists (SELECT * FROM piece_net pn3 WHERE pn3.parent_id=r.id) AND ?=ANY(r.path) ");
		sql.append("ORDER BY path ");

		List<PieceWithPath> ps = null;
		try {
			ResultSetHandler<List<PieceWithPath>> rsh = new BeanListHandler<PieceWithPath>(PieceWithPath.class);
			String sqlStr = sql.toString();
			log.debug("getPieceWithPathList sql::"+sqlStr);
			ps = run.query(sql.toString(), rsh, project_id, id);
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
