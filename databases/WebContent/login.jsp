<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#content {
	position: relative;
}

#login {
	position: relative;
	top: 100px;
}

.align-right {
	text-align: right;
}

table {
	border: 1px solid gray;
	padding: 20px;
	background-color: #CCCCFF;
}

.login-error {
	font-size: 16px;
	font-weight: bold;
	font-color: red;
}
</style>
</head>
<body>

	<center>
		<div id="login">
			<form method="post"	action="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=dologin")%>">
				<input type="hidden" name="action" value="dologin" />
				
				<table>
					<tr>
						<td class="aligh-right">Email address:</td>
						<td><input type="text" name="email"
							value="<%=request.getAttribute("email")%>" /></td>
					</tr>
					<tr>
						<td class="aligh-right">Password:</td>
						<td><input type="password" name="password"
							value="<%=request.getAttribute("password")%>" /></td>
					</tr>
					<tr>
						<td class="aligh-right" colspan="2"><input type="submit"
							value="Log In" /></td>
					</tr>
				</table>

				<p class="login-error"><%=request.getAttribute("message")%></p>

			</form>
		</div>
	</center>

</body>
</html>