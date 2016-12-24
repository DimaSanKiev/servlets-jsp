<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ps" %>

<c:import url="header.jsp" >
	<c:param name="title" value="Picture Squirrel - View Image" />
</c:import>

<center>

<%-- If we need to update the image rating, we need to
get the image data and updating the rating in a single transaction --%>
<sql:tansaction dataSource="jsbc/webshop">

	<sql:query sql="SELECT * FROM images WHERE id=?" var="results">
		<sql:param>${param.image}</sql:param>
	</sql:query>
	
	<%-- Get the row for this image and format the file name --%>
	<c:set scope="page" var="image" value="${results.rows[0]}" />
	<%-- <c:set scope="page" var="imgname" value="${image.stem}.${image.image_extension}" /> --%>
	<%-- Set the average ranking to a variable --%>
	<c:set scope="page" var="average_ranking" value="${image.average_ranking}" />
	
	<%-- If the user has clicked to rate the image, do the rating. --%>
	<c:if test='${param.action == "rate"}'>
		<c:set scope="page" var="newRating" value="${(image.average_ranking * image.rankings + param.rating)/(image.rankings + 1)}" />
		<c:set scope="page" var="average_ranking" value="${newRating}" />
		
		<sql:update sql="UPDATE images SET average_ranking=? WHERE id=?">
			<sql:param>${newRating}</sql:param>
			<sql:param>${param.image}</sql:param>
		</sql:update>
		
		<sql:update sql="UPDATE images SET rankings=? WHERE id=?">
			<sql:param>${image.rankings + 1}</sql:param>
			<sql:param>${param.image}</sql:param>
		</sql:update>
	</c:if>
</sql:tansaction>

<%-- Show the title with first letter capitalized --%>
<h2><c:out value="${fn:toUpperCase(fn:substring(image.stem, 0, 1))}${fn:toLowerCase(fn:substring(image.stem, 1, -1))}" /></h2>
<span class="rating">Rated: <fmt:formatNumber value="${average_ranking}" maxFractionDigits="1" /></span>

<%-- Output the image and the rating form --%>
<table style="border:none;">
	<tr>
		<td><br style="margin-bottom: 1px;">
		<span class="attribution">Image by <a class="attribution" target="_blank" href="${image.attribution_url}">${image.attribution_name}</a></span><br>
		<%-- Using a custom tag --%>
		<ps:image width="200" stem="${image.stem}" extension="${image.image_extension}"/>
		<%-- <img src="${pageContext.request.contextPath}/pics/${imgname}" /> --%></td>
	
		<td>	
		<form action='<c:url value="/gallery" />' method="post">
			<input type="hidden" name="action" value="rate" />
			
			<table style="padding: 20px; border: none;">
				<tr><td><h3><i>Rate It!</i></h3></td></tr>
				<tr><td align="left"><input type="radio" name="rating" value="5">5 - Amazing</input></td></tr>
				<tr><td align="left"><input type="radio" name="rating" value="4">4 - Good</input></td></tr>
				<tr><td align="left"><input type="radio" name="rating" value="3">3 - Average</input></td></tr>
				<tr><td align="left"><input type="radio" name="rating" value="2">2 - Bad</input></td></tr>
				<tr><td align="left"><input type="radio" name="rating" value="1">1 - Horrendous</input></td></tr>
				<tr><td align="left"><input type="submit" name="submit" value="OK" /></td></tr>
			</table>
		</form>
		</td>
	</tr>
</table>

</center>

<c:import url="footer.jsp" />
