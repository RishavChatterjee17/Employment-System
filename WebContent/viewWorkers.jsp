<%@page import="beans.Workers"%>
<%@page import="java.util.List"%>
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
		List<Workers> workerList = (List<Workers>)request.getAttribute("worker");
	%>
	<table border="0">
		<tr bgcolor="green"><th>Name<th colspan="2">Email</tr>
		<%
			if(workerList!=null && workerList.size()>0){
				for(Workers wk : workerList){
		%>
		<tr bgcolor="lightblue"><td><%=wk.getW_name() %><td><%=wk.getW_adhar() %><td><a href="viewWorkers?wk_id=<%=wk.getW_id()%>">View</a></tr>	
		<%			
				}
			}
		%>
	</table>
</body>
</html>