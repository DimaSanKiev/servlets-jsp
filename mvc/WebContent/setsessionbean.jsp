<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user2" class="bean.User" scope="session"></jsp:useBean>

	<jsp:setProperty property="email" name="user2" value="user2@email.com" />
	<jsp:setProperty property="password" name="user2" value="password2" />

</body>
</html>