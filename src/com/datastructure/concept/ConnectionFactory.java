package com.datastructure.concept;

/**
 * Created by asingh on 6/17/19.
 */
public class ConnectionFactory {

    public static Connection getConnection(String dbType){
        if("Mongo".equals(dbType)){
            return new MongoConnection();
        }else if("MySql".equals(dbType)){
            return new MySqlConnection();
        }
        return null;
    }
}
