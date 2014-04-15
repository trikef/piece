package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.Friend;

public class FriendDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(FriendDao.class);

	public static final int STATUS_REQUEST = 2;
	public static final int STATUS_PERMISSION = 1;
	public static final int STATUS_BLOCK = 3;

	public FriendDao() {
		super();
	}

	public Friend get(int own_user_id, int friend_user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("f.id,f.own_user_id,f.friend_user_id,f.status_id,f.created_at,");
		sql.append("ou.name as own_name,fu.name as friend_name ");
		sql.append("FROM friend f ");
		sql.append("INNER JOIN user_info ou ON ou.id=f.own_user_id ");
		sql.append("INNER JOIN user_info fu ON fu.id=f.friend_user_id ");
		sql.append("WHERE f.own_user_id=? AND f.friend_user_id=? ");
		
		Friend f;
		try {
			ResultSetHandler<Friend> rsh = new BeanHandler<Friend>(Friend.class);
			f = run.query(sql.toString(), rsh, own_user_id, friend_user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return f;
	}

	public List<Friend> getList(int own_user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("f.id,f.own_user_id,f.friend_user_id,f.status_id,f.created_at,");
		sql.append("ou.name as own_name,fu.name as friend_name ");
		sql.append("FROM friend f ");
		sql.append("INNER JOIN user_info ou ON ou.id=f.own_user_id ");
		sql.append("INNER JOIN user_info fu ON fu.id=f.friend_user_id ");
		sql.append("WHERE f.own_user_id=? ");
		
		List<Friend> fs;
		try {
			ResultSetHandler<List<Friend>> rsh = new BeanListHandler<Friend>(Friend.class);
			fs = run.query(sql.toString(), rsh, own_user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return fs;
	}
	
	public List<Friend> getList(int own_user_id, int status_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("f.id,f.own_user_id,f.friend_user_id,f.status_id,f.created_at,");
		sql.append("ou.name as own_name,fu.name as friend_name ");
		sql.append("FROM friend f ");
		sql.append("INNER JOIN user_info ou ON ou.id=f.own_user_id ");
		sql.append("INNER JOIN user_info fu ON fu.id=f.friend_user_id ");
		sql.append("WHERE f.own_user_id=? AND f.status_id=? ");
		
		List<Friend> fs;
		try {
			ResultSetHandler<List<Friend>> rsh = new BeanListHandler<Friend>(Friend.class);
			fs = run.query(sql.toString(), rsh, own_user_id, status_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return fs;
	}

	public List<Friend> getListSideFriend(int user_id, int status_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("f.id,f.own_user_id as friend_user_id,f.friend_user_id as own_user_id,f.status_id,f.created_at,");
		sql.append("ou.name as own_name,fu.name as friend_name ");
		sql.append("FROM friend f ");
		
		sql.append("INNER JOIN user_info ou ON ou.id=f.friend_user_id ");
		sql.append("INNER JOIN user_info fu ON fu.id=f.own_user_id ");
		sql.append("WHERE not exists ( ");
		sql.append("SELECT * FROM friend of WHERE of.own_user_id=? AND of.status_id=")
		.append(STATUS_BLOCK).append(" AND of.friend_user_id=f.own_user_id) ");
		sql.append("AND f.friend_user_id=? AND f.status_id=?");
		
		List<Friend> fs;
		try {
			ResultSetHandler<List<Friend>> rsh = new BeanListHandler<Friend>(Friend.class);
			fs = run.query(sql.toString(), rsh, user_id, user_id, status_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return fs;
	}

	public void insert(int own_user_id, int friend_user_id, int status_id){
		String sql = "INSERT INTO friend (own_user_id,friend_user_id,status_id) VALUES (?,?,?)";
		try {
			run.update(sql,own_user_id,friend_user_id,status_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}

	public void update(int own_user_id, int friend_user_id, int status_id) {
		String sql = "UPDATE friend SET status_id=? WHERE own_user_id=? AND friend_user_id=?";
		try {
			run.update(sql,status_id, own_user_id, friend_user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
