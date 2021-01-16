<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>改</title>
</head>
<body class="linear">
	<form method="post" action="${ctx}/customerServlet.do?type=edit">
		<input type="hidden" name="id" id="id" value="${customer.id}">
		<table border="1">
			<tr>
				<td>登录名称</td>
				<td><input type="text" name="loginName" value="${customer.loginName}"></td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td><input type="text" name="realName" value="${customer.realName}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="btlogin"></td>
			</tr>
		</table>
	</form>
</body>
</html>