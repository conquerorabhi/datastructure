package com.datastructure.concept;

/**
 * Created by asingh on 6/17/19.
 */
public interface ConnectionPool {

    public Connection getConnection(String userID,String password,String url,String driverClass);
    public void freeConnection(Connection connection);
    public void closeAllConnection();
    public int getAllConnection();
}
