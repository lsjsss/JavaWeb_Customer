package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
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

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}