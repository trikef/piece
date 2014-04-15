package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.GroupMember;

public class GroupMemberDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(GroupMemberDao.class);

	public GroupMemberDao() {
		super();
	}

	public GroupMember get(int user_id, int project_id, int piece_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("gm.id,gm.user_id,gm.project_id,gm.piece_id,gm.permission,gm.created_at,");
		sql.append("u.name ");
		sql.append("FROM group_member gm ");
		sql.append("INNER JOIN user_info u ON u.id=gm.user_id ");
		sql.append("WHERE gm.user_id=? AND gm.project_id=? AND gm.piece_id=? ");
		
		GroupMember g;
		try {
			ResultSetHandler<GroupMember> rsh = new BeanHandler<GroupMember>(GroupMember.class);
			g = run.query(sql.toString(), rsh, user_id, project_id, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return g;
	}

	public List<GroupMember> getList(int project_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("gm.id,gm.user_id,gm.project_id,gm.piece_id,gm.permission,gm.created_at,");
		sql.append("u.name ");
		sql.append("FROM group_member gm ");
		sql.append("INNER JOIN user_info u ON u.id=gm.user_id ");
		sql.append("WHERE gm.project_id=? ");
		
		List<GroupMember> gs;
		try {
			ResultSetHandler<List<GroupMember>> rsh = new BeanListHandler<GroupMember>(GroupMember.class);
			gs = run.query(sql.toString(), rsh, project_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return gs;
	}

	public List<GroupMember> getList(int project_id, int piece_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("gm.id,gm.user_id,gm.project_id,gm.piece_id,gm.permission,gm.created_at,");
		sql.append("u.name ");
		sql.append("FROM group_member gm ");
		sql.append("INNER JOIN user_info u ON u.id=gm.user_id ");
		sql.append("WHERE gm.project_id=? AND gm.piece_id=? ");
		
		List<GroupMember> gs;
		try {
			ResultSetHandler<List<GroupMember>> rsh = new BeanListHandler<GroupMember>(GroupMember.class);
			gs = run.query(sql.toString(), rsh, project_id, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return gs;
	}
	
	public List<GroupMember> getListFromUserId(int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("gm.id,gm.user_id,gm.project_id,gm.piece_id,gm.permission,gm.created_at,");
		sql.append("u.name ");
		sql.append("FROM group_member gm ");
		sql.append("INNER JOIN user_info u ON u.id=gm.user_id ");
		sql.append("WHERE gm.user_id=? ");
		
		List<GroupMember> gs;
		try {
			ResultSetHandler<List<GroupMember>> rsh = new BeanListHandler<GroupMember>(GroupMember.class);
			gs = run.query(sql.toString(), rsh, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return gs;
	}

	public void insert(int user_id, int project_id, int piece_id, int permission){
		String sql = "INSERT INTO group_member (user_id, project_id, piece_id, permission) VALUES (?,?,?,?)";
		try {
			run.update(sql,user_id, project_id, piece_id, permission);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}

	public void update(int user_id, int project_id, int piece_id, int permission){
		String sql = "UPDATE group_member SET permission=? WHERE user_id=? AND project_id=? AND piece_id=?";
		try {
			run.update(sql, permission ,user_id, project_id, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void delete(int user_id, int project_id, int piece_id){
		String sql = "DELETE FROM group_member WHERE user_id=? AND project_id=? AND piece_id=?";
		try {
			run.update(sql ,user_id, project_id, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
