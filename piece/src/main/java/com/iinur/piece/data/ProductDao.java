package com.iinur.piece.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.Product;

public class ProductDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(ProductDao.class);

	public ProductDao() {
		super();
	}
	
	public Product get(int product_id){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("pd.id,pd.piece_id,pd.user_id,pd.name,pd.status,pd.star,pd.type_id,pd.created_at, ");
		sql.append("u.name as user_name,pt.name as type_name,pc.project_id ");
		sql.append("FROM Product pd ");
		sql.append("INNER JOIN piece pc ON pd.piece_id=pc.id ");
		sql.append("INNER JOIN user_info u ON pd.user_id = u.id ");
		sql.append("INNER JOIN product_type pt ON pd.type_id = pt.id ");
		sql.append("WHERE pd.id=? ");

		Product p = null;
		try {
			ResultSetHandler<Product> rsh = new BeanHandler<Product>(Product.class);
			p = run.query(sql.toString(), rsh, product_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p;
	}

	public Product getNew(int piece_id, int user_id){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM Product WHERE piece_id=? AND user_id=? ORDER BY created_at DESC LIMIT 1");
		Product p = null;
		try {
			ResultSetHandler<Product> rsh = new BeanHandler<Product>(Product.class);
			p = run.query(sql.toString(), rsh, piece_id, user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p;
	}

	public List<Product> getList(int piece_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id,p.piece_id,p.user_id,p.name,p.status,p.star,p.star_count,p.type_id,p.created_at,u.name as user_name,pt.name as type_name ");
		sql.append("FROM Product p ");
		sql.append("INNER JOIN user_info u ON p.user_id = u.id ");
		sql.append("INNER JOIN product_type pt ON p.type_id = pt.id ");
		sql.append("WHERE piece_id=?");

		List<Product> ps = null;
		try {
			ResultSetHandler<List<Product>> rsh = new BeanListHandler<Product>(Product.class);
			ps = run.query(sql.toString(), rsh, piece_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}

	public List<Product> getListUnread(int user_id){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("pd.id,pj.title,pc.title,du.name,pd.name,pdt.name as type_name,du.name as user_name,pd.created_at, ");
		sql.append("pj.title as project_title,pc.title as piece_title ");
		sql.append("FROM product pd ");
		sql.append("LEFT JOIN product_type pdt ON pd.type_id=pdt.id ");
		sql.append("LEFT JOIN piece pc ON pd.piece_id=pc.id ");
		sql.append("LEFT JOIN project pj ON pc.project_id=pj.id ");
		sql.append("LEFT JOIN user_info du ON pd.user_id=du.id ");
		
		sql.append("WHERE exists (");
		sql.append("SELECT * FROM group_member gm ");
		sql.append("WHERE gm.project_id=pc.project_id ");
		sql.append("AND gm.user_id=?");
		sql.append(") ");
		sql.append("AND not exists (");
		sql.append("SELECT * FROM access_log al ");
		sql.append("WHERE al.user_id=? ");
		sql.append("AND al.product_id=pd.id");
		sql.append(") ");
		sql.append("AND exists (");
		sql.append("SELECT * FROM user_info ou ");
		sql.append("WHERE ou.id=? AND ou.created_at<pd.created_at)");
		
		List<Product> ps = null;
		try {
			ResultSetHandler<List<Product>> rsh = new BeanListHandler<Product>(Product.class);
			ps = run.query(sql.toString(), rsh, user_id,user_id,user_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return ps;
	}

	public void insert(int piece_id, int user_id, String name, int status){
		String sql = "INSERT INTO Product (piece_id,user_id,name,status) VALUES (?,?,?,?)";
		try {
			run.update(sql,piece_id,user_id,name,status);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
	
	public void update(int product_id, int piece_id, String name, int status){
		String sql = "UPDATE Product SET piece_id=?,name=?,status=? WHERE id=?";
		try {
			run.update(sql,piece_id,name,status,product_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
