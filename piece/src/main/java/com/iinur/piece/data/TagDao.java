package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.Tag;

public class TagDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(TagDao.class);

	public TagDao() {
		super();
	}
	
	public List<Tag> getAll() {
		String sql = "SELECT * FROM tag WHERE display=TRUE ORDER BY name ASC";
		List<Tag> ts;
		try {
			ResultSetHandler<List<Tag>> rsh = new BeanListHandler<Tag>(Tag.class);
			ts = run.query(sql, rsh);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return ts;
	}

	public Tag get(int id) {
		String sql = "SELECT * FROM tag Where id=?";
		Tag t = new Tag();
		try {
			ResultSetHandler<Tag> rsh = new BeanHandler<Tag>(Tag.class);
			t = run.query(sql, rsh, id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return t;
	}
	/*
	 * id SERIAL,
	user_id INTEGER NOT NULL,
	name VARCHAR(100) NOT NULL,
	description TEXT,
	display BOOLEAN DEFAULT TRUE,
	pop INTEGER DEFAULT 0,--ALTER TABLE tag ADD COLUMN pop INTEGER DEFAULT 0;
	created_at
	 */
	public List<Tag> getTagsWithSelectedPiece(int piece_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("t.id,t.user_id,t.name,t.description,t.display,t.pop,t.created_at,pt.id as piece_tag_id ");
		sql.append("FROM tag t ");
		sql.append("LEFT JOIN (SELECT * FROM piece_tag WHERE piece_id=?) pt ON t.id=pt.tag_id ");
		sql.append("WHERE t.display=true ");
		
		List<Tag> ts;
		try {
			ResultSetHandler<List<Tag>> rsh = new BeanListHandler<Tag>(Tag.class);
			ts = run.query(sql.toString(), rsh, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return ts;
	}

	public Tag getNew(int user_id) {
		String sql = "SELECT * FROM tag WHERE user_id=? ORDER BY created_at DESC LIMIT 1";
		Tag t = new Tag();
		try {
			ResultSetHandler<Tag> rsh = new BeanHandler<Tag>(Tag.class);
			t = run.query(sql, rsh, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return t;
	}

	public void insert(int user_id, String name, String description){
		String sql = "INSERT INTO tag (user_id,name,description) VALUES (?,?,?)";
		try {
			run.update(sql,user_id,name,description);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}

	public void update(int id, String name, String description) {
		String sql = "UPDATE tag SET name =?,description=? WHERE id =?";
		try {
			run.update(sql,name,description,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void updateDisplay(int id, boolean display) {
		String sql = "UPDATE tag SET display=? WHERE id =?";
		try {
			run.update(sql,display,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
