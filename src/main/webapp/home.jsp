<%@page import="com.mysql.cj.util.Base64Decoder"%>
<%@page import="java.util.Base64"%>
<%@page import="dto_classes.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	
	<% User u = (User)request.getSession().getAttribute("user"); %>
	
	<h1>Welcome <%= u.getUsername() %></h1>
	<h3>Email: <%=u.getUseremail() %> </h3>
	
	<% byte[] image = u.getUserimage(); %>
	<%String str = new String(Base64.getEncoder().encode(image));%>
	<img alt="" src="data:image/jpeg;base64,<%= str %>" height="300" width="500">
	<a href="addtask.jsp">Add Task</a>
</body>
</html>