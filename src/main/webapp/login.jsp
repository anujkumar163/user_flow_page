<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>login page</h2>
	<from action="verifyLogin" method="post">
		email<input type="text" name="email">
		password<input type="text" name="password">
		<input type="submit" value="submit">
	
	</from>
	<%
		if(request.getAttribute("error")!= null){
			out.println(request.getAttribute("error"));
		}
	%>
</body>
</html>