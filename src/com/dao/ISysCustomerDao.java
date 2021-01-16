package com.dao;

import java.util.List;

import com.entity.SysCustomer;

public interface ISysCustomerDao {
	
	int add(String loginName, String realName, String password, int roleId);
	
	int delete(int id);

	int edit(int id, String loginName, String realName);

	List<SysCustomer> getAll();

	SysCustomer get(int id);
	
}
