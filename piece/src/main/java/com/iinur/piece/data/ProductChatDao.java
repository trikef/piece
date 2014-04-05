package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.ProductChat;

public class ProductChatDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(ProductChatDao.class);

	public ProductChatDao() {
		super();
	}
	
	public ProductChat get(int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.product_id,c.user_id,c.text,c.star,c.created_at,u.name FROM product_chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.id=? ");
		
		ProductChat c = null;
		try {
			ResultSetHandler<ProductChat> rsh = new BeanHandler<ProductChat>(ProductChat.class);
			c = run.query(sql.toString(), rsh, id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return c;
	}
	
	public ProductChat getNew(int product_id, int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.product_id,c.user_id,c.text,c.star,c.created_at,u.name FROM product_chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.product_id=? AND c.user_id=? ");
		sql.append("ORDER BY c.id DESC ");
		sql.append("LIMIT 1");
		
		ProductChat c = null;
		try {
			ResultSetHandler<ProductChat> rsh = new BeanHandler<ProductChat>(ProductChat.class);
			c = run.query(sql.toString(), rsh, product_id, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return c;
	}
	
	public List<ProductChat> getList(int product_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.id,c.product_id,c.user_id,c.text,c.star,c.created_at,u.name FROM product_chat c ");
		sql.append("INNER JOIN user_info u ON c.user_id = u.id ");
		sql.append("WHERE c.product_id=? ");
		sql.append("ORDER BY c.id ASC");
		
		List<ProductChat> cs = null;
		try {
			ResultSetHandler<List<ProductChat>> rsh = new BeanListHandler<ProductChat>(ProductChat.class);
			cs = run.query(sql.toString(), rsh, product_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return cs;
	}
	
	public void insert(int product_id, int user_id, String text, int star){
		String sql = "INSERT INTO product_chat (product_id,user_id,text,star) VALUES (?,?,?,?)";
		try {
			run.update(sql,product_id,user_id,text,star);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void updateText(int id, String text){
		String sql = "UPDATE product_chat SET text=? WHERE id=?";
		try {
			run.update(sql,text,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}

	public void updatePriority(int id, int priority){
		String sql = "UPDATE product_chat SET priority=? WHERE id=?";
		try {
			run.update(sql,priority,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
