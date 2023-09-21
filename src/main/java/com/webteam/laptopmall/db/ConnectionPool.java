package com.webteam.laptopmall.db;

import com.webteam.laptopmall.utilities.PropertyUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool ins;
    private BasicDataSource ds;

    public static synchronized ConnectionPool getIns(){
        if(ins == null){
            ins = new ConnectionPool();
        }
        return ins;
    }

    private ConnectionPool(){ initDataSource(); }

    private void initDataSource(){
//        var loader = PropertiesUtil.loadProperties();
        var loader = PropertyUtil.loadProperties();
        String url = loader.getProperty("jdbc.url");
        String username = loader.getProperty("jdbc.username");
        String pass = loader.getProperty("jdbc.password");
        int minIdleConns = Integer.parseInt(loader.getProperty("jdbc.minIdleConnections"));
        int maxIdleConns = Integer.parseInt(loader.getProperty("jdbc.maxIdleConnections"));
        int maxOpenPS = Integer.parseInt(loader.getProperty("jdbc.maxOpenPreparedStatements"));

        ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(pass);
        ds.setMinIdle(minIdleConns);
        ds.setMaxIdle(maxIdleConns);
        ds.setMaxOpenPreparedStatements(maxOpenPS);
    }

    public Connection getConn() throws SQLException {
        return ds.getConnection();
    }
}
