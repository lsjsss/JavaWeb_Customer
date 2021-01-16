package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 功能：
 * 1 提供数据连接
 * 2 关闭数据库资源
 * @author Administrator
 *
 */
public class DBTools {
	
	// 要实现数据库访问操作，首选需要4个基本信息
	// 1 数据库驱动类
	static String driver = "com.mysql.jdbc.Driver";
	// 2 数据库的连接串
	// String url = "jdbc:mysql://localhost:3306/guestbook";
	static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	// 3 用户名
	static String user = "root";
	// 4 密码
	static String password = "root";

	// 加载数据库驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;		
	}
	
	/**
	 * 关闭数据库资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if(conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}		
	}
	public static void main(String[] args) {
		System.out.println(DBTools.getConnection());
	}
}
