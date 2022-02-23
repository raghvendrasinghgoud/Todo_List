package com.todo.helper;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
     static Connection conn;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","Raghav@123");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}