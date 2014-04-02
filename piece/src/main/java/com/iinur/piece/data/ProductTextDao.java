package com.iinur.piece.data;

import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;
import com.iinur.piece.data.bean.ProductText;

public class ProductTextDao extends BaseDao {

	private static final Logger log = LoggerFactory
			.getLogger(ProductTextDao.class);

	public ProductTextDao() {
		super();
	}

	public ProductText get(int product_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM product_text WHERE product_id=?");
		ProductText p = null;
		try {
			ResultSetHandler<ProductText> rsh = new BeanHandler<ProductText>(
					ProductText.class);
			p = run.query(sql.toString(), rsh, product_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p;
	}

	public ProductText getWithProductInfo(int product_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id,p.piece_id,p.user_id,p.name,p.status,p.star,p.star_count,");
		sql.append("p.type_id,p.created_at,pt.text_id,pt.data,pt.comment,pt.updated_at,u.name as user_name,ptp.name as type_name ");
		sql.append("FROM product p ");
		sql.append("INNER JOIN product_text pt ON p.id = pt.product_id ");
		sql.append("INNER JOIN user_info u ON p.user_id = u.id ");
		sql.append("INNER JOIN product_type ptp ON p.type_id = ptp.id ");
		sql.append("WHERE pt.product_id=? ");

		ProductText p = null;
		try {
			ResultSetHandler<ProductText> rsh = new BeanHandler<ProductText>(
					ProductText.class);
			p = run.query(sql.toString(), rsh, product_id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}

		return p;
	}

	public void insert(int product_id, String data, String comment) {
		String sql = "INSERT INTO product_text (product_id,data,comment) VALUES (?,?,?)";
		try {
			run.update(sql, product_id,data,comment);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}

}