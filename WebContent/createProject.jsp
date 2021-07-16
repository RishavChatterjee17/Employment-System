<%@page import="beans.Project"%>
<%@page import="java.util.List"%>
<%@page import="beans.*" %>
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

	<%	
	
		String msg = request.getParameter("create");
	
	%>
	
	<center><h2>Project Creation Page</h2></center>
	<center>
	<%
		if(msg!=null && msg.equals("done")){
	%>
		<b>Project Created Successfully...!</b>			
	<%
		}
	%>
	</center>
	<form action="createProject" method="post">
		Name : <input type="text" name="p_name"></br>
		Location : <input type="text" name="p_location"></br>
		<input type="submit" name="sbmt1" value="Create">
	</form>
	<a href="BDOHome.jsp">Home</a>

</body>
</html>