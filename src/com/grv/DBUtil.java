package com.grv;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Gaurav Rajput
 * Created on 24/11/19
 */
public class DBUtil {
    private String url = "jdbc:mysql://localhost:3306/db_connect";
    private String userName = "db_user";
    private String password = "password";
    private Connection connection;

    private static DBUtil db;

    private DBUtil() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
             this.connection = DriverManager.getConnection(url, userName, password);
        }
        catch (Exception e) {}
    }

    public static Connection getConnection() {
        if(db == null) {
            db = new DBUtil();
        }
        return db.connection;
    }
}
