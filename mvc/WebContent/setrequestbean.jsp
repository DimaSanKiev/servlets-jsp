<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user0" class="bean.User" scope="request"></jsp:useBean>

	<jsp:setProperty property="email" name="user0" value="user0@email.com" />
	<jsp:setProperty property="password" name="user0" value="password0" />
	
	Email: <%= user0.getEmail() %>
	<p />
	Password: <%= user0.getPassword() %>
	
	<jsp:forward page="getrequestbean.jsp"></jsp:forward>

</body>
</html>