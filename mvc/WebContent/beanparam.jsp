<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user4" class="bean.User" scope="page"></jsp:useBean>
	<jsp:useBean id="user5" class="bean.User" scope="page"></jsp:useBean>
	
	<!-- http://localhost:8080/mvc/beanparam.jsp?pass=Passw0rd -->
	<jsp:setProperty property="password" name="user4" param="pass"/>
	
	
	<!-- http://localhost:8080/mvc/beanparam.jsp?email=email@email.com&pass=newPass -->
	<jsp:setProperty name="user5" property="*"/>
	
	<%= user4.getPassword() %>
	<%= user5.getEmail() %>

</body>
</html>