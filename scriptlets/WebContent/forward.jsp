<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Hello

	<%
		/* 
		    forward happens entirely on the server. The servlet container just forwards the same request to the target url, 
		    without the browser knowing about that. Hence you can use the same request attributes and the same request 
		    parameters when handling the new url. And the browser won't know the url has changed (because it has happened 
		    entirely on the server)
		*/
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		/*
			redirect sets the response status to 302, and the new url in a Location header, and sends the response to 
			the browser. Then the browser, according to the http specification, makes another request to the new url

		*/
		response.sendRedirect("index.jsp");
	%>

</body>
</html>