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

	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("formsubmit")) {
			if (user1.validate()) {
				request.getRequestDispatcher("/Controller").forward(request, response);
			}
		}
	%>

	<h3><jsp:getProperty property="message" name="user1" /></h3>

	<form action="/forms/selfvalidatingform.jsp" method="post">
		<input type="hidden" name="action" value="formsubmit" />
		<input type="text" name="email" value="<jsp:getProperty property="email" name="user1" />" /><p/> 
		<input type="password" name="password" value="<jsp:getProperty property="password" name="user1" />" /><p/>
		<input type="submit" value="OK" />
	</form>

</body>
</html>