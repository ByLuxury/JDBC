package com.icooer;

import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by zhoushuai on 2017/2/9.
 */
public class JDBCDemo4 {
    public static void main(String[] args) {
        System.out.print("input id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.print("input name:");
        String name = scanner.next();
        //insertData(id,name);
        //以面向对象的方式插入
        User user = new User();
        user.setId(id);
        user.setName(name);
//        insertObj(user);
        updateData(user);//更新数据

    }

    public static void insertData(int id, String name) {
        Connection conn = JDBCUtil.openConnetcion();//打开连接
        String sql = "INSERT INTO test(id,name) VALUE(?,?) ";//通过占位符来动态插入数据
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);//传入sql，建立PreparedStatement对象
            //设置条件参数索引和值
            pstmt.setInt(1, id); //SQL语句中第一个条件为id
            pstmt.setString(2, name);//第二个为name
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnectio(conn);
        }
    }
    //以面向对象的方式插入，参数为一个对象
    public static void insertObj(User user) {
        Connection conn = JDBCUtil.openConnetcion();//打开连接
        String sql = "INSERT INTO test(id,name) VALUES (?,?) ";//通过占位符来动态插入数据
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);//传入sql，建立PreparedStatement对象
            //设置条件参数索引和值
            pstmt.setInt(1, user.getId()); //SQL语句中第一个条件为id
            pstmt.setString(2, user.getName());//第二个为name
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnectio(conn);
        }
    }

    public static void updateData(User user) {
        Connection conn = JDBCUtil.openConnetcion();
        String sql = "UPDATE test SET name=? WHERE id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnectio(conn);
        }
    }
}
