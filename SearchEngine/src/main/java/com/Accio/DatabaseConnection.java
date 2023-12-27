/*
Singleton class whose object connects java and database
 */
package com.Accio;

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
    private static Connection getConnection(String user, String pass, String db){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?user=" + user + "&password=" + pass);
        }
        catch(SQLException | ClassNotFoundException sqlexception){
            sqlexception.printStackTrace();
        }
        return connection;
    }
}
