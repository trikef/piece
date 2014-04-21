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

	public Tag getTagFromName(String name) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("t.id,t.user_id,t.name,t.description,t.display,t.pop,t.created_at,");
		sql.append("tc.path,tc.path_name,tc.num ");
		sql.append("FROM tag t, ");
		
		sql.append("(WITH RECURSIVE rect(id,pid,path,path_name) as ( ");
		sql.append("SELECT child_id, parent_id,array[parent_id],array_append(NULL,tp.name) ");
		sql.append("FROM tag_net tn ");
		sql.append("INNER JOIN tag tc ON tn.child_id=tc.id ");
		sql.append("INNER JOIN tag tp ON tn.parent_id=tp.id ");
		sql.append("UNION ALL ");
		sql.append("SELECT b.child_id,b.parent_id,path||b.parent_id,array_append(path_name,b.name) ");
		sql.append("FROM rect a INNER JOIN  (");
		sql.append("SELECT tn2.child_id,tn2.parent_id,t2.name ");
		sql.append("FROM tag_net tn2 ");
		sql.append("LEFT JOIN tag t2 ON tn2.parent_id=t2.id");
		sql.append(") b ON a.id=b.parent_id) ");
		sql.append("SELECT ");
		sql.append("min(rt.path) as path,min(path_name) as path_name,count(*) as num ");
		sql.append("FROM rect rt ");
		sql.append("WHERE (?=ANY(rt.path_name) OR exists (SELECT * FROM tag tt WHERE rt.id=tt.id AND tt.name=?))) tc ");
		
		sql.append("WHERE t.name=? ");
		
		Tag t;
		try {
			ResultSetHandler<Tag> rsh = new BeanHandler<Tag>(Tag.class);
			t = run.query(sql.toString(), rsh, name,name,name);
			log.debug("getTagFromName("+name+"):"+sql.toString());
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

	public List<Tag> getAllTagsWithPieceCount() {
		StringBuffer sql = new StringBuffer();

		//TODO tuning
		sql.append("WITH RECURSIVE rec(id,pid,path,path_title) as ( ");
		sql.append("SELECT child_id, parent_id,array[parent_id],array[p.title] FROM piece_net pn ");
		sql.append("INNER JOIN piece pc ON pn.child_id=pc.id ");
		sql.append("LEFT join piece p ON pn.parent_id = p.id ");
		sql.append("WHERE parent_id=0 ");
		sql.append("UNION ALL ");
		sql.append("SELECT b.child_id,b.parent_id,path||b.parent_id,path_title||title FROM rec a JOIN  ");
		sql.append("(SELECT pn2.child_id,pn2.parent_id,p2.title FROM piece_net pn2  ");
		sql.append("LEFT JOIN piece p2 ON pn2.parent_id = p2.id) b ");
		sql.append("ON a.id=b.parent_id) ");
		
		sql.append("SELECT ");
		//sql.append("t.id,t.name,t.description,t.display,t.pop,t.created_at,count(*) as num ");
		sql.append("t.id,t.name,count(*) as num ");
		sql.append("FROM rec r ");
		sql.append("LEFT JOIN piece p3 ON r.id=p3.id ");
		
		sql.append("LEFT JOIN piece_tag pt ON p3.id=pt.piece_id ");
		sql.append("LEFT JOIN tag t ON pt.tag_id=t.id ");
		
		sql.append("WHERE not exists (SELECT * FROM piece_net pn3 WHERE pn3.parent_id=r.id) ");
		sql.append("AND p3.display=TRUE AND p3.status_id=1 ");
		sql.append("AND (p3.permission-((p3.permission/10)*10))&4=4 ");
		sql.append("AND t.name is not null ");

		sql.append("GROUP BY t.id,t.name ");
		sql.append("ORDER BY count(*) DESC ");

		List<Tag> ts;
		try {
			ResultSetHandler<List<Tag>> rsh = new BeanListHandler<Tag>(Tag.class);
			ts = run.query(sql.toString(), rsh);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return ts;
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
