package com.datastructure.concept;

/**
 * Created by asingh on 6/17/19.
 */
public class ConnectionPoolFactory {

    public static ConnectionPool getConnectionPool(String poolType){
        if(poolType.equals("MySql")){
            return new MySqlConnectionPool("","","","");
        }else{
            return new MongoConnectionPool("","","","");
        }
    }
}
