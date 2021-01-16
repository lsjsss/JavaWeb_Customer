<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>查</title>
</head>
<body>
	<a href="${ctx}/customer.jsp">添加</a> 
	<table border="1">
		<thead>
			<tr>
				<th>主键</th>
				<th>登录名称</th>
				<th>真实姓名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customerList}" var="obj">
				<tr>
					<th scope="row">${obj.id}</th>
					<td>${obj.loginName}</td>
					<td>${obj.realName}</td>
					<td>
						<a href="${ctx}/customerServlet.do?type=get&id=${obj.id}">编辑</a> 
						<a href="${ctx}/customerServlet.do?type=delete&id=${obj.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>