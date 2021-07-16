<%@page import="beans.Project"%>
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
	Project p = (Project)request.getAttribute("p");

%>

	<center><h2>Project Details</h2></center>
	<table border="1" align="center">
		<tr><th>Name<th>Location<th>StartDate<th>EndDate</tr>
		<tr><td><%=p.getP_name() %><td><%=p.getP_location() %><td><%=p.getP_sdate() %><td><%=p.getP_edate() %></tr>
	</table>
</body>
</html>