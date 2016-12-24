<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:import url="header.jsp" >
	<c:param name="title" value="Picture Squirrel Home" />
</c:import>

<sql:setDataSource var="ds" dataSource="jsbc/webshop" />

<sql:query dataSource="${ds}" sql="SELECT * FROM images ORDER BY id" var="results" />

<table class="images">
	<c:set var="tablewidth" value="8" />
	<c:forEach var="image" items="${results.rows}" varStatus="row">
		<c:if test="${row.index % tablewidth == 0}">
			<tr>
		</c:if>
		<c:set scope="page" var="imgname" value="${image.stem}.${image.image_extension}" />
		<td>
			<a href="<c:url value="/gallery?action=image&image=${image.id}" />">
				<img width="80" src="${pageContext.request.contextPath}/pics/${imgname}" />
			</a>
		</td>
		<c:if test="${row.index + 1 % tablewidth == 0}">
			</tr>
		</c:if>
	</c:forEach>
</table>

<c:import url="footer.jsp" />
