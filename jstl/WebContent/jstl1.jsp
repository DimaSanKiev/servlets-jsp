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
	<%-- http://localhost:8080/jstl/jstl1.jsp?name=dima --%>
	<p>Name parameter: <c:out value="${param.name}" /></p>

	<%-- JSTL if --%>
	<%-- http://localhost:8080/jstl/jstl1.jsp?name=dima --%>
	<p><c:if test="${param.name == 'dima'}">
		Hello Dima.
	</c:if></p>
	<p><c:if test="${param.name != 'dima'}">
		Hello user.
	</c:if></p>
	
	<%-- JSTL choose --%>
	<%-- http://localhost:8080/jstl/jstl1.jsp?id=1&name=dima --%>
	<p><c:choose>
		<c:when test="${param.id == 1}">
			ID is equal to 1
		</c:when>
		<c:when test="${param.id == 2}">
			ID is equal to 2
		</c:when>
		<c:otherwise>
			ID is neither 1 nor 2
		</c:otherwise>
	</c:choose></p>
	
	<%-- JSTL "for" loop --%>
	<p><c:forEach var="i" begin="0" end="10" step="2" varStatus="status">
		Loop counter is: <c:out value="${i}" /></br>
		<c:if test="${status.first}">
			This was a first iteration</br>
		</c:if>
		<c:if test="${status.last}">
			This was a last iteration</br>
		</c:if>
	</c:forEach></p>
	
</body>
</html>