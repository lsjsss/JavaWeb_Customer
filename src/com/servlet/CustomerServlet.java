package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ISysCustomerDao;
import com.dao.impl.ISysCustomerDaoImpl;
import com.entity.SysCustomer;

@WebServlet("/customerServlet.do")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ISysCustomerDao customerDao = new ISysCustomerDaoImpl();

	public CustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 乱码处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取jsp页面参数值
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String loginName = request.getParameter("loginName");
		String realName = request.getParameter("realName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String roleId = request.getParameter("roleId");

		if (type.equals("add")) {
			// 增
			add(request, response, loginName, realName, password, confirmPassword, roleId);
		} else if (type.equals("delete")) {
			// 删
			delete(request, response, id);
		} else if (type.equals("get")) {
			// 改前获取值 - 跳编辑页面
			get(request, response, id);
		} else if (type.equals("edit")) {
			// 改
			edit(request, response, id, loginName, realName);
		} else if (type.equals("getAll")) {
			// 查
			getAll(request, response);
		} 
	}

	// 增
	private void add(HttpServletRequest request, HttpServletResponse response, String loginName, String realName,
			String password, String confirmPassword, String roleId) throws ServletException, IOException {
		if (loginName.equals("") || realName.equals("") || password.equals("") || roleId.equals("")
				|| !(password.equals(confirmPassword))) {
			request.setAttribute("reg", "失败！");
		} else {
			// Dao 层添加
			this.customerDao.add(loginName, realName, password, Integer.valueOf(roleId));

			// 返回jsp页面消息
			request.setAttribute("reg", "成功！");
		}
		// 跳转 - 结果页面
		request.getRequestDispatcher("/customerResult.jsp").forward(request, response);
	}
	
	// 删
	private void delete(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
		int ret = this.customerDao.delete(Integer.valueOf(id));
		if (ret == 1) {
			request.setAttribute("reg", "成功！");
		} else {
			request.setAttribute("reg", "失败！");
		}
		// 跳转 - 结果页面
		request.getRequestDispatcher("/customerResult.jsp").forward(request, response);
	}
	
	// 改前获取值 - 跳编辑页面
	private void get(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
		SysCustomer customer = this.customerDao.get(Integer.valueOf(id));
		request.setAttribute("customer", customer);
		// 跳转
		request.getRequestDispatcher("/customerEdit.jsp").forward(request, response);
	}
	
	// 改
	private void edit(HttpServletRequest request, HttpServletResponse response, String id, String loginName, String realName) throws ServletException, IOException {
		if (loginName.equals("") || realName.equals("")) {
			// 返回jsp页面消息
			request.setAttribute("reg", "失败！");
		} else {
			// Dao 层修改
			this.customerDao.edit(Integer.valueOf(id), loginName, realName);

			// 返回jsp页面消息
			request.setAttribute("reg", "成功！");
		}
		// 跳转 - 结果页面
		request.getRequestDispatcher("/customerResult.jsp").forward(request, response);
	}
	
	// 查
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取数据库表中全部数据
		List<SysCustomer> customerList = this.customerDao.getAll();
		request.setAttribute("customerList", customerList);

		// 跳转 - 列表页面
		request.getRequestDispatcher("/customerAll.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}