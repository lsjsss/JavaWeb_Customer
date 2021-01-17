<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer</title>
</head>
<!-- 
	1 对于表单来说，最重要的两个属性
		 - method：用于指明该表单form向后台提交数据的方式是get或post方式，一般设置为post
		 - action：指明该表单数据要提交到后台的地址
	2 在表单中的标签中的数据必须通过  name 属性传递到后台，不是id或其他属性
-->
<body>
	<form method="post" action="${ctx}/customerServlet.do?type=add">
		<table border="1">
			<tr>
				<td>登录名称</td>
				<td><input type="text" name="loginName"></td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td><input type="text" name="realName"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="confirmPassword"></td>
			</tr>
			<tr>
				<td>所属角色</td>
				<td>
					<select name="roleId" id="roleId">
						<option value="1">借阅管理员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="btlogin">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>