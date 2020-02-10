package com.qd.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JDBCUtil {
    Logger log = LoggerFactory.getLogger(JDBCUtil.class);
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://192.168.3.85:3306/student?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true";
    private static final String username = "case";
    private static final String password = "case";
    private static final String testConnection = "select 1 from dual";

    public static Connection getJDBCConnection() {
        Connection connection = null;
        try {
            /**
             * Loading JDBC driver
             */
            Class.forName(driver);
            /**
             * Get connection object
             */
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
