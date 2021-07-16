<%@page import="beans.Workers"%>
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
	Workers worker = (Workers)request.getAttribute("st");
	if(worker != null){
%>
	Worker Name : <b><%=worker.getW_name() %></b></br>
	Adhar_no : <b><%=worker.getW_adhar() %></b><br>
	Project : <b><%=worker.getProject().getP_name() %></b><br>
			
<%
	}
%>
</body>
</html>