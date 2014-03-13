package com.iinur.core.data;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactory {

    public static DataSource getDataSource() {
    	DataSource ds = null;

        try {
            Context initContext = new InitialContext();
            ds = (DataSource)initContext.lookup("java:comp/env/jdbc/postgresql");

        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ds;
    }
}
