<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> list page</h2>
	shiro标签
	Welocme:<shiro:principal></shiro:principal>
	
	<shiro:hasRole name="admin">
		<br><br>
		<a href="admin.jsp">admin.jsp</a>
	</shiro:hasRole>
	
	<shiro:hasRole name="user">
		<br><br>
	<a href="user.jsp">user.jsp</a>
	</shiro:hasRole>
	<br><br><br><br>
	
	<a href="shiro/shiroAnnotation">shiroAnnotation</a>
	
	<br><br>
	<a href="admin.jsp">admin.jsp</a>
	
	<br><br>
	<a href="user.jsp">user.jsp</a>
	
	<br><br>
	<a href="shiro/logout">logout</a>
	
	
</body>
</html>