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
		String msg = request.getParameter("login");
	%>

	<center><h2><b><u><font face "Broadway" color="pink">Login Page</font></u></b></h2></center>
	<center>
		<%
			if(msg != null){
				%>
				<b><i>Please Try Again..!</i></b>
				<%
			}
		%>
	
	</center>
	<form action="login" method="POST">
		Email : <input type="text" name="email"><br>
		Password : <input type="password" name="password"><br>
		Role : <select name="role">
			<option value="gp">Gram_panchayat
			<option value="bdo">BDO
			</select>
		<input type="submit" name="sbmt" value="Login">	
	</form>
</body>
</html>