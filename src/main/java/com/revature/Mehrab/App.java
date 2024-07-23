package com.revature.Mehrab;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;INIT=runscript from 'init.sql'", "sa", "");
        ResultSet resultSet = connection.prepareStatement("select * from cars").executeQuery();
        while (resultSet.next()) 
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("yearmake"));
    }
}
