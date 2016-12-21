<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- Output text --%>
	<c:out value="Hello World JSTL" />

	<%-- Access bean properties in JSTL --%>
	<jsp:useBean id="test" class="bean.TestBean" scope="page" />
	<p>Value of info "attribute": <c:out value="${test.info}" /></p>
	
	<%-- Getting parameters --%>
	<p>Name parameter: <c:out value="${param.name}" /></p>

</body>
</html>