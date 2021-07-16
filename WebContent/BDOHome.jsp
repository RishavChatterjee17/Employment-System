<%@page import="beans.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		User user =  (User)session.getAttribute("user");
		if(user==null){
			response.sendRedirect("login.jsp");
		}
	%>
<center><h2><b><u><font face "Broadway" color="pink">BDO Home Page</font></u></b></h2></center>
	<a href="createProject.jsp">Create Project</a><br>
	<a href="viewWorker.jsp">View Worker Detail</a><br>
	<a href="logout.jsp">Logout</a>	
</body>
</html>