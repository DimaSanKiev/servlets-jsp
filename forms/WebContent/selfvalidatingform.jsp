<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user1" class="bean.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="user1" />

	<form action="/forms/selfvalidatingform.jsp" method="post">
		Email: <input type="text" name="email" value="<jsp:getProperty property="email" name="user1" />" /><br/> 
		Password: <input type="text" name="password" value="<jsp:getProperty property="password" name="user1" />" /><br/>
		<input type="submit" value="OK" />
	</form>

</body>
</html>