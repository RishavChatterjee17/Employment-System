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
	
		List<Project> projects = (List<Project>)session.getAttribute("project");
		
		String msg = request.getParameter("register");
	
	%>
	
	<center><h2>Worker Registration Page</h2></center>
	<center>
	<%
		if(msg!=null && msg.equals("success")){
	%>
		<b>Worker registered Successfully...!</b>			
	<%
		}
	%>
	</center>
	<form action="register" method="post">
		Name : <input type="text" name="w_name"></br>
		Adhar_no : <input type="text" name="w_adhar"></br>
		Address : <input type="text" name="w_address"></br>
		Project : <select name="project">
			<%
				if(projects!=null && projects.size()>0){
 					for(Project p : projects){
			%>
					<option value="<%=p.getP_id()%>"><%=p.getP_name() %>	
			<% 
					}
				}
			%>
				
				</select>
		<input type="submit" name="sbmt" value="Register">
	</form>
	<a href="CsHome.jsp">Home</a>
</body>
</html>