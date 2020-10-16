package com.qf.hzx.utils;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: ajax
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-13 17:15
 **/
public class DBUtils {
    public static String className = null;
    public static String name = null;
    public static String pass = null;
    public static String url = null;

    static {
        Properties properties = new Properties();
        try {
            //properties.load(DBUtils.class.getClassLoader().getResourceAsStream("src/main/resources/jdbc.properties"));
            properties.load(new FileInputStream("src/main/resources/jdbc.properties"));
            className = properties.getProperty("className");
            name = properties.getProperty("name");
            pass = properties.getProperty("pass");
            url = properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取连接对象
    public static Connection getConnection() {
        Connection conn = null;

        try {
            //加载驱动
            Class.forName(className);
            conn = DriverManager.getConnection(url, name, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    //关闭
    public static void closeAll(AutoCloseable... closeables) {
        for (AutoCloseable ac : closeables) {
            if (ac != null) {
                try {
                    ac.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
