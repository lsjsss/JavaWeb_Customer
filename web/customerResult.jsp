<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加结果</title>
</head>
<body>
	<h3>${reg}</h3>
	<a href="${ctx}/customerServlet.do?type=getAll">返回</a>
</body>
</html>