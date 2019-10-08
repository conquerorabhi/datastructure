package com.datastructure.concept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asingh on 6/17/19.
 */
public class MySqlConnectionPool implements ConnectionPool {
    Connection connection ;
    static List<Connection> connectionPool;


    @Override
    public Connection getConnection(String userID,String password,String url,String driverClass) {
        connection = ConnectionFactory.getConnection("MySql");
        if(connectionPool==null){
            connectionPool = new ArrayList<>();
            for(int count=0;count<10;count++){
                connectionPool.add(connection.createConnection("","","",""));
            }

        }else{

        }
        return null;
    }

    public MySqlConnectionPool(String userID,String password,String url,String driverClass){

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
