package com.icooer;

import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhoushuai on 2017/1/18.
 */
public class JDBCDemo2 {

     private static Connection conn;
     private static Statement stmt;
     private static ResultSet rs;
    public static void main(String[] args){
       conn= JDBCUtil.openConnetcion();//获得数据连接
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT username FROM staff");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnectio(conn); //关闭数据库连接
        }

    }
}
