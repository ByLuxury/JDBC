package com.icooer;

import java.sql.*;

/**
 * Created by zhoushuai on 2017/1/18.
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws SQLException {
        QueryData();
    }

    public static void QueryData() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/info?characterEncoding=utf8&useSSL=true";//jdbc:mysql://主机名称：连接数据库端口/数据库的名称
        String user = "root";
        String password = "mysql";//密码
        String sql = "SELECT * FROM staff";
        Connection conn = null;
        Statement stmt = null;
        ResultSet set = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载mysql驱动
            conn = DriverManager.getConnection(url, user, password);//获取数据库连接
            stmt = conn.createStatement();//创建一个Statment对象，用来执行SQL语句
            set = stmt.executeQuery(sql);//执行SQL语句，返回查询结果集
            while (set.next()) {
                System.out.print("ID:" + set.getInt(1) + "\t");
                System.out.print("Name:" + set.getString(2) + "\n");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (set != null) {
                set.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
