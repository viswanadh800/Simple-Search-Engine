/*
This class is singleton class, which means only one object is created.
The object that is created is connection and through which we can connect database.
So, after creating this object, we can run sql queries from java instead of from mysql work bench.
Main purpose of this class is to create a instance to database and set a connection to database.

Why singleton class? - because creating connection between java and database is costly in terms of computation power.
*/
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection=null;
    public static Connection getConnection(){
        if(connection!=null)
            return connection;
        else{
            String user="root";
            String password="Sairam@123!";
            String db="searchengineapp";
            return getConnection(user, password, db);
        }
    }

    //added mysql-connector-j-8.0.32.jar file, so that we can connect java to database
    private static Connection getConnection(String user, String pass, String db){
        try {
            //JDBC API uses JDBC drivers to connect with the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?user=" + user + "&password=" + pass);
        }
        catch(SQLException | ClassNotFoundException sqlexception){
            sqlexception.printStackTrace();
        }
        return connection;
    }
}
