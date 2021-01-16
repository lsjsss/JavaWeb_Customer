package com.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dao.ISysCustomerDao;
import com.entity.SysCustomer;
import com.utils.DBTools;

public class ISysCustomerDaoImpl extends BaseDaoImpl<SysCustomer> implements ISysCustomerDao {
	private Connection conn = DBTools.getConnection();

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
	
	//查
	@Override
	public List<SysCustomer> getAll() {
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
