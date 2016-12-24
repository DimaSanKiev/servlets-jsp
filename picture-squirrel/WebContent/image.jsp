<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:import url="header.jsp" >
	<c:param name="title" value="Picture Squirrel - View Image" />
</c:import>

<sql:setDataSource var="ds" dataSource="jsbc/webshop" />

<sql:query dataSource="${ds}" sql="SELECT * FROM images WHERE id=?" var="results">
	<sql:param>${param.image}</sql:param>
</sql:query>
<c:set scope="page" var="image" value="${results.rows[0]}" />
<c:set scope="page" var="imgname" value="${image.stem}.${image.image_extension}" />

<img src="${pageContext.request.contextPath}/pics/${imgname}" />

<c:import url="footer.jsp" />
