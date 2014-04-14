package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.PieceTag;
import com.iinur.piece.data.bean.Tag;

public class PieceTagDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(PieceTagDao.class);

	public PieceTagDao() {
		super();
	}

	public Tag getTag(int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("t.id,t.user_id,t.name,t.description,t.display,t.pop,t.created_at,pt.id as piece_tag_id ");
		sql.append("FROM tag t ");
		sql.append("INNER JOIN piece_tag pt ON t.id=pt.tag_id ");
		sql.append("WHERE pt.id=? ");

		Tag t;
		try {
			ResultSetHandler<Tag> rsh = new BeanHandler<Tag>(Tag.class);
			t = run.query(sql.toString(), rsh, id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return t;
	}

	public Tag getTagFromTagId(int piece_id, int tag_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("t.id,t.user_id,t.name,t.description,t.display,t.pop,t.created_at,pt.id as piece_tag_id ");
		sql.append("FROM tag t ");
		sql.append("INNER JOIN piece_tag pt ON t.id=pt.tag_id ");
		sql.append("WHERE pt.piece_id=? AND pt.tag_id=? LIMIT 1");

		Tag t;
		try {
			ResultSetHandler<Tag> rsh = new BeanHandler<Tag>(Tag.class);
			t = run.query(sql.toString(), rsh, piece_id, tag_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return t;
	}

	public List<Tag> getTags(int piece_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("t.id,t.user_id,t.name,t.description,t.display,t.pop,t.created_at,pt.id as piece_tag_id ");
		sql.append("FROM tag t ");
		sql.append("INNER JOIN piece_tag pt ON t.id=pt.tag_id ");
		sql.append("WHERE pt.piece_id=? ");
		sql.append("ORDER BY t.pop DESC, pt.created_at ASC");

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

	public PieceTag getNew(int user_id, int piece_id, int tag_id) {
		String sql = "SELECT * FROM piece_tag WHERE user_id=? AND piece_id=? AND tag_id=? ORDER BY created_at DESC LIMIT 1";
		PieceTag t = new PieceTag();
		try {
			ResultSetHandler<PieceTag> rsh = new BeanHandler<PieceTag>(PieceTag.class);
			t = run.query(sql, rsh, user_id,piece_id,tag_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return t;
	}

	public Tag getNewTag(int user_id, int piece_id, int tag_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("t.id,t.user_id,t.name,t.description,t.display,t.pop,t.created_at,pt.id as piece_tag_id ");
		sql.append("FROM tag t ");
		sql.append("INNER JOIN piece_tag pt ON t.id=pt.tag_id ");
		sql.append("WHERE pt.user_id=? AND pt.piece_id=? AND pt.tag_id=? ORDER BY pt.created_at DESC LIMIT 1 ");
		
		Tag t = new Tag();
		try {
			ResultSetHandler<Tag> rsh = new BeanHandler<Tag>(Tag.class);
			t = run.query(sql.toString(), rsh, user_id,piece_id,tag_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return t;
	}

	public void insert(int user_id, int piece_id, int tag_id){
		String sql = "INSERT INTO piece_tag (user_id,piece_id,tag_id) VALUES (?,?,?)";
		try {
			run.update(sql,user_id,piece_id,tag_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM piece_tag WHERE id=?";
		try {
			run.update(sql,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
