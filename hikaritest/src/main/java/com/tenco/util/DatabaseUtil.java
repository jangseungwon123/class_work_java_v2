package com.tenco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {


    private static  final String DB_URL = "jdbc:mysql://192.168.0.184:3306/academy_management?serverTimezone=Asia/Seoul";
    private static final String DB_USER = "academy_admin";
    private static final String DB_PASSWORD = "ghkdlxld";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void main(String[] args) {
        // DB 접근 테스트
        try{
            DatabaseUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
