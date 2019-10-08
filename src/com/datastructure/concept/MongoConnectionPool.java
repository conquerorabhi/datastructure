package com.datastructure.concept;

import java.util.List;

/**
 * Created by asingh on 6/17/19.
 */
public class MongoConnectionPool implements ConnectionPool{
    List<Connection> connectionPool;

    /**
     * Driver: ""com.mysql.jdbc.Driver"
     * URL = "jdbc:mysql://localhost/kodejava"
     * @param userId
     * @param password
     * @param driverClassUrl
     */
    public MongoConnectionPool(String userId,String password,String driverClassUrl,String url){

    }

    @Override
    public Connection getConnection(String userID, String password, String url, String driverClass) {
        return null;
    }

    @Override
    public void freeConnection(Connection connection) {

    }

    @Override
    public void closeAllConnection() {

    }

    @Override
    public int getAllConnection() {
        return 0;
    }
}
