<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><font color="red">Manage leave application</font></h1>
	<table border="1">
	<tr>
		<th><b>Staff ID</b></th>
		<th><b>Start Date</b></th>
		<th><b>End Date</b></th>
		<th><b>Duration</b></th>
		<th><b>Action</b></th>
	</tr>
	<c:forEach var="leaveRecords" items="${leaveRecords}">
	<tr>
		<td>${leaveRecords.staffid}</td>
		<td>${leaveRecords.startdate}</td>
		<td>${leaveRecords.enddate}</td>
		<td>${leaveRecords.daystaken}</td>
		<td><a href="/ca/manage/update/${leaveRecords.leaveformid}">Update</a>
		<a onclick="window.confirm('Are you sure to delete?');" href="/ca/manage/delete/${leaveRecords.leaveformid}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	</table>
		<a href="${pageContext.request.contextPath}/Staff/Staff">Home Screen</a>
</body>
</html>