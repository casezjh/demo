package com.qd.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static String testConnection;
    /**
     * get ClassLoader by this class
     */
    ClassLoader classLoader = JDBCUtil.class.getClassLoader();
    /**
     * Get an inputstream through the class loader method
     */
    InputStream in;

    /**
     * Get an JDBC connections through static code
     * Static code blocks are automatically loaded when the class is initialized
     */ {
        try {
            in = classLoader.getResourceAsStream("../config/JDBC_Config.properties");
            /**
             *  Creating an Properties object
             */
            Properties properties = new Properties();

            /**
             * Loading input stream,and catch IOException
             */
            properties.load(in);
            /**
             * Gets the value of the relevant parameter from properties
             */
            driver = properties.getProperty("driverClassName");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            testConnection = properties.getProperty("testConnection");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getJDBCConnection() {

        Connection connection = null;
        Statement statement = null;

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
        //Close the Statement
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //Then close the Connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            statement.execute(testConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
