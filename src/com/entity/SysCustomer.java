package com.entity;

import java.io.Serializable;

public class SysCustomer implements Serializable {

	private static final long serialVersionUID = 1L;

	// 主键
	private int id;
	// 登录名称
	private String loginName;
	// 真实姓名
	private String realName;
	// 密码
	private String password;
	// 角色编号
	private int roleId;

	public SysCustomer() {
		super();
	}

	public SysCustomer(String loginName, String realName, String password, int roleId) {
		super();
		this.loginName = loginName;
		this.realName = realName;
		this.password = password;
		this.roleId = roleId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}
	
	public String getRoleIds() {
		String roleIds = "" + roleId;
		return roleIds;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SysCustomer [id=" + id + ", loginName=" + loginName + ", realName=" + realName + ", password="
				+ password + ", roleId=" + roleId + "]";
	}
}
