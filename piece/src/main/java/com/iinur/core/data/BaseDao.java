package com.iinur.core.data;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao {

	private static final Logger log = LoggerFactory.getLogger(BaseDao.class);

	protected QueryRunner run = null;

	public BaseDao() {
		DataSource ds = DataSourceFactory.getDataSource();
		run = new QueryRunner(ds);
	}
	
	public Connection getConnection(){
		Connection con = null;
		try {
			con = run.getDataSource().getConnection();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.toString());
		}
		return con;
	}
}
