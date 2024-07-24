package com.revature.Mehrab;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;INIT=runscript from 'init.sql'", "sa", "");
        // ResultSet resultSet = connection.prepareStatement("select * from cars").executeQuery();
        // while (resultSet.next()) 
        //     System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("yearmake"));

        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        String query;
        while (!isDone) {
            Statement statement = connection.createStatement();
            System.out.print("h2> ");
            query = scanner.nextLine();
        
            if ("exit".equalsIgnoreCase(query)) {
                isDone = true;
                break;
            }

            while (!query.endsWith(";")) {
                System.out.print("---->  ");
                query += scanner.nextLine();
            }

            try {
                boolean isResultSet = statement.execute(query);
                if (isResultSet) {
                    ResultSet resultSet = statement.getResultSet();
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        System.out.printf("%-15s", resultSet.getString(i));
                    }
                    System.out.println();
                } else {
                    int linesUpdated = statement.getUpdateCount();
                    System.out.println(linesUpdated + ((linesUpdated == 1) ? " row" : " rows") + " updated.");
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        scanner.close();
        connection.close();
    }
}
