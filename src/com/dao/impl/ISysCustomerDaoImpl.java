package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ISysCustomerDao;
import com.entity.SysCustomer;
import com.mysql.jdbc.PreparedStatement;

public class ISysCustomerDaoImpl extends BaseDaoImpl<SysCustomer> implements ISysCustomerDao {

	// 1 数据库驱动类
	static String driver = "com.mysql.jdbc.Driver";
	// 2 数据库的连接串
	// String url = "jdbc:mysql://localhost:3306/guestbook";
	static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	// 3 用户名
	static String user = "root";
	// 4 密码
	static String password = "root";

	private static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private static Connection conn = getConnection();

	// 增 executeUpdate
	public int add(String loginName, String realName, String password, String roleId) {
		int ret = -1;
		PreparedStatement pst = null;
		String sql = "insert into tuser(loginName, realName, password, roleId)values(?,?,?,?)";
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);

			// 赋值
			pst.setString(1, loginName);
			pst.setString(2, realName);
			pst.setString(3, password);
			pst.setString(4, roleId);

			// 执行
			ret = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	// 删 executeUpdate
	public int delete(String id) {
		int ret = -1;
		String sql = "delete from tuser where id = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, id);

			// 执行
			ret = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	// 改前取值 executeUpdate
	@Override
	public SysCustomer get(String id) {
		SysCustomer customer = null;
		String sql = "select * from tuser where id = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				customer = new SysCustomer();
				customer.setId(rs.getInt("id"));
				customer.setLoginName(rs.getString("loginName"));
				customer.setRealName(rs.getString("realName"));
				customer.setPassword(rs.getString("password"));
				customer.setRoleId(Integer.valueOf(rs.getString("roleId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	// 改 executeUpdate
	public int edit(String id, String loginName, String realName) {
		int ret = -1;
		String sql = "update tuser set loginName=?, realName=? where id=?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, loginName);
			pst.setString(3, realName);
			
			ret = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	// 查 executeQuery
	public List<SysCustomer> getAll() {
		String sql = "select * from tuser";
		List<SysCustomer> list = new ArrayList<SysCustomer>();

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			rs = pst.executeQuery();

			SysCustomer customer = null;
			while (rs.next()) {
				customer = new SysCustomer();
				customer.setId(rs.getInt("id"));
				customer.setLoginName(rs.getString("loginName"));
				customer.setRealName(rs.getString("realName"));
				customer.setPassword(rs.getString("password"));
				customer.setRoleId(Integer.valueOf(rs.getString("roleId")));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * -----------------------------------------
	 */
	// 增
	@Override
	public int add(String loginName, String realName, String password, int roleId) {
		int ret = -1;
		String sql = "insert into tuser(loginName, realName, password, roleId)values(?,?,?,?)";
		Object[] params = new Object[] { loginName, realName, password, roleId };
		try {
			ret = super.insert(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	// 删
	@Override
	public int delete(int id) {
		int ret = -1;
		String sql = "delete from tuser where id = ?";
		Object[] params = new Object[] { id };
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	// 改前取值
	@Override
	public SysCustomer get(int id) {
		SysCustomer sysCustomer = null;
		String sql = "select * from tuser where id = ?";
		Object[] params = new Object[] { id };
		try {
			sysCustomer = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sysCustomer;
	}

	// 改
	@Override
	public int edit(int id, String loginName, String realName) {
		int ret = -1;
		String sql = "update tuser set loginName=?, realName=? where id=?";
		Object[] params = new Object[] { loginName, realName, id };
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	// 查
	@Override
	public List<SysCustomer> getAlls() {
		List<SysCustomer> list = null;
		String sql = "select * from tuser";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
