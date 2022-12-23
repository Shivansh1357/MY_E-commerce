package com.example.myecommerce;

import java.sql.*;

public class dataBaseConnection {
    Connection con=null;
    String SQLURL="jdbc:mysql://localhost:3306/ecommerce?useSSl=false";
    String username="root";
    String password="Shiv@nsh1357";
    dataBaseConnection() throws SQLException{
        con= DriverManager.getConnection(SQLURL,username,password);
        if(con!=null) System.out.println("Our Connection is established with server");
    }
    public ResultSet executeQuery(String query) throws SQLException {
        ResultSet result=null;
        try {
            Statement statement = con.createStatement();
             result = statement.executeQuery(query);
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public int executeUpdate(String query){
        int row=0;
        try {
            Statement statement = con.createStatement();
            row = statement.executeUpdate(query);
            return row;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }
}
