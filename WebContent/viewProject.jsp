<%@page import="beans.Project"%>
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
		List<Project> projectList = (List<Project>)request.getAttribute("plist");
	%>
	<table border="0">
		<tr bgcolor="green"><th>Name<th colspan="2">Location<th>Start Date<th colspan="2">End Date</th></tr>
		<%
			if(projectList!=null && projectList.size()>0){
				for(Project pj : projectList){
		%>
		<tr bgcolor="lightblue"><td><%=pj.getP_name() %><td><%=pj.getP_location() %><td><a href="viewProject1?p_id=<%=pj.getP_id()%>">View</a></tr>	
		<%
				}
			}
		%>
		
	</table>
</body>
</html>