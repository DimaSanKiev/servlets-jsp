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

	<c:out value="${case1.name}" /><br/>
	<c:out value="${case2.name}" /><br/>
	<c:out value="${case3.name}" /><br/>
	
	<c:out value="${sessionScope.case2.name}"/><br/>
	
	<c:out value="${map1['fruit']}"/><br/>
	
	<c:out value="${link}" /><br/>
	${link}<br/>

	<table style="border: 1px solid gray">
		<c:forEach var="test" items="${list1}">
			<tr><td>${test.id}</td><td>${test.name}</td><tr />
		</c:forEach>
	</table>

</body>
</html>