package com.dao;

import java.util.List;

import com.entity.SysCustomer;

public interface ISysCustomerDao {
	// executeQuery，executeUpdate
	int add(String loginName, String realName, String password, String roleId);
	int delete(String id);
	int edit(String id, String loginName, String realName);
	List<SysCustomer> getAll();
	
	// 原始方式
	int add(String loginName, String realName, String password, int roleId);
	int delete(int id);
	int edit(int id, String loginName, String realName);
	List<SysCustomer> getAlls();
	
	SysCustomer get(int id);
	SysCustomer get(String id);
	
}
