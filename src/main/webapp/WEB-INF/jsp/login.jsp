<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"
	type="text/javascript"></script>
<title>Registry Login</title>

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>


</head>
<body>
	<form:form commandName="user" method="post" action="validateUser.html">
		<table style="width: 50%;">
			<tbody>
				<tr>
					<td>Employee Id:</td>
					<td><form:input path="employeeId" id="id" /></td>
					<td><form:errors path="employeeId" cssClass="error" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
			</tbody>
		</table>

		<input type="submit" value="Login">
		<div class="error">
			<c:if test="${not empty validate}">${validate}</c:if>
		</div>
	</form:form>
</body>
</html>