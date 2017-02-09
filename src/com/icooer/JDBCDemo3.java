package com.icooer;

import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhoushuai on 2017/1/19.
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        //createTable();
        // insertData();
        // deleteData();
        // updateData();
        List<User> list=queryData();//返回集合
        Iterator<User> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    //创建表
    public static void createTable() {
        Connection conn = JDBCUtil.openConnetcion();
        String sql = "CREATE TABLE test(id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(10) NOT NULL) CHARACTER SET=utf8";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("创建表成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnectio(conn);
        }

    }
    //插入数据
    public static void insertData() {
        Connection conn = JDBCUtil.openConnetcion();
        String sql = "INSERT INTO test(name) VALUES('周杰')";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);//插入数据
            System.out.println("添加成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnectio(conn);
        }

    }

    //删除数据
    public static void deleteData() {
        Connection conn = JDBCUtil.openConnetcion();
        String sql = "DELETE FROM test WHERE id=3";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("删除成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnectio(conn);
        }

    }

    //修改数据
    public static void updateData() {
        Connection conn = JDBCUtil.openConnetcion();
        String sql = "UPDATE test SET id=3 WHERE id=4";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnectio(conn);
        }

    }
    //查询数据
   /*public static void queryData(){
        Connection conn=JDBCUtil.openConnetcion();
        String sql="select id,name from test";
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1)+":"+rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
   */

    public static List<User> queryData() {

        Connection conn = JDBCUtil.openConnetcion();
        String sql = "SELECT * FROM test";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
               // System.out.println(rs.getInt(1) + ":" + rs.getString(2));
                list.add(user);
            }

           // System.out.println(list);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
