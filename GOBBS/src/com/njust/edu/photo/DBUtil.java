/*
 * 这个类用于连接数据库
 * 
 */

package com.njust.edu.photo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBUtil {
	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/gobbs_general?useSSL=true&amp;characterEncoding=utf8";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	static {
         try {
             Class.forName(DRIVER_CLASS_NAME);
         } catch (ClassNotFoundException e) {
             System.out.println("注册失败！");
             e.printStackTrace();
         }
     }
 
     // 获取连接
     public static Connection getConn() throws SQLException {
         return DriverManager.getConnection(URL, USERNAME, PASSWORD);
     }
 
     // 关闭连接
     public static void closeConn(Connection conn) {
         if (null != conn) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 System.out.println("关闭连接失败！");
                 e.printStackTrace();
             }
         }
     }
     //测试
     public static void main(String[] args) throws SQLException {
         System.out.println(DBUtil.getConn());
     }

}
