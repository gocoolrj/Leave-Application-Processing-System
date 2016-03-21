<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Type List</title>
</head>
<body>

<h1>Leave Type List</h1>

<h3 cssStyle="color:green">${message}</h3>


<a href="${pageContext.request.contextPath}/leaveType/create.html">Create new Leave Type</a>
<br/><br/>
<table>
	<thead>
		<tr>
			<td>Id</td>
			<td>Leave Type</td>
			<td>LimitDays</td>
			<td>Actions</td>
		</tr>
	</thead>
	<tbody>	
		<c:forEach var="ltList" items="${leaveTypeList}">
			<tr>
			<td>${ltList.leaveid}</td>
			<td>${ltList.leavetype}</td>
			<td>${ltList.limitdays}</td>
			<td>
				<a href="${pageContext.request.contextPath}/leaveType/edit/${ltList.leaveid}.html">Edit</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/leaveType/delete/${ltList.leaveid}.html">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<br/>
<a href="${pageContext.request.contextPath}/leaveType/admin">Go Home Page</a><br/>
</body>
</html>