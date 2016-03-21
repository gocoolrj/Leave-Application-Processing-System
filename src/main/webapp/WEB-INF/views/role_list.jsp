<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role List Page</title>
</head>
<body>

<h1>Role List Page</h1>
<h3>${message}</h3>



<a href="${pageContext.request.contextPath}/role/create.html">Create new role</a><br/><br/>
<table>
	<thead>
		<tr>
			<td>Role Id</td>
			<td>Role Title</td>
			<td>Action</td>
		</tr>
	</thead>
	<tbody>	
		<c:forEach var="role" items="${roleList}">
			<tr>
				<td>${role.roleid}</td>
				<td>${role.title}</td>
				<td>
					<a href="${pageContext.request.contextPath}/role/edit/${role.roleid}.html">Edit</a><br/>
					<%-- <a href="${pageContext.request.contextPath}/role/delete/${role.roleid}.html">Delete</a> --%>
				</td>
			</tr>			
		</c:forEach>		
	</tbody>	
</table>
<br/>
<a href="${pageContext.request.contextPath}/role/admin">Go Home Page</a><br/>
</body>
</html>