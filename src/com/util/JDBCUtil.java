package com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by zhoushuai on 2017/1/18.
 */
public class JDBCUtil {
    private static String url;
    private static String driver;
    private static String user;
    private static String password;
    //把相关信息放入静态代码块，程序启动的时候自动运行
    static {
       /* url = "jdbc:mysql://localhost:3306/info?characterEncoding=utf8&useSSL=true";
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "mysql";*/
          Properties pro=new Properties();
        try {
            Reader reader=new FileReader("src/config.properties"); //获取配置文件流
            pro.load(reader);//加载配置文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取配置文件中的各个属性
        url = pro.getProperty("url");
        driver = pro.getProperty("driver");
        user = pro.getProperty("user");
        password = pro.getProperty("password");

    }

     //打开连接
    public static Connection openConnetcion() {
        try {
            Class.forName(driver);//加载驱动
            return DriverManager.getConnection(url, user, password);//返回数据库连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     //关闭连接
    public static void closeConnectio(Connection conn) {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
