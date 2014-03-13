package com.iinur.core.data;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

public class BaseDao {

	protected QueryRunner run = null;

	public BaseDao() {
		DataSource ds = DataSourceFactory.getDataSource();
		run = new QueryRunner(ds);
	}
}
