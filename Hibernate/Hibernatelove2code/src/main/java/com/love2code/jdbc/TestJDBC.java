package com.love2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    private static final String URL = "jdbc:postgresql://localhost:5432/DB-java-ee";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {

        try {
            System.out.println("Connecting to database: " + URL);

//            Class.forName("com.mysql.jdbs.Driver");
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Connection successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
