<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Role</title>
</head>
<body>
	<h1>Create New Role</h1>
	<form:form method="POST" commandName="role" action="${pageContext.request.contextPath}/role/create.html">
		<table>
			<tbody>				
				<tr>
					<td>Role Title : </td>
					<td><form:input path="title"/></td>
					<td><form:errors path="title" cssStyle="color:red;"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td><form:hidden path="createdby" value="test"/></td>
					<td></td>
				</tr>
				
				<tr>
					<td></td>
					<td><form:hidden path="createddate" value="2014-12-1"/></td>
					<td></td>
				</tr>
				
				<tr>
					<td></td>
					<td><form:hidden path="updatedby" value="test"/></td>
					<td></td>
				</tr>
				
				<tr>
					<td></td>
					<td><form:hidden path="updateddate" value="2014-12-1"/></td>
					<td></td>
				</tr>
			
				<tr>
					<td><input type="submit" value="Create"/></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>	
		</table>
	</form:form>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/role/list.html">Go to Role List</a>
</body>
</html>