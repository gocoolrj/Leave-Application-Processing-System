
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><font color="blue">Testing for manage leave application</font></h1>
	<table border="1">
	<tr>
		<th><b>StaffID</b></th>
		<th><b>Start Date</b></th>
		<th><b>End Date</b></th>
		<th><b>Duration</b></th>
		<th><b>Action</b></th>
	</tr>
	<tr>
		<td>${leaveRecord.staffid}</td>
		<td>${leaveRecord.startdate}</td>
		<td>${leaveRecord.enddate}</td>
		<td>${leaveRecord.daystaken}</td>
		<td><a href="/ca/manage/update/${leaveRecord.leaveformid}">Update</a>
		<a onclick="window.confirm('Are you sure to delete?');" href="/ca/manage/delete/${leaveRecord.leaveformid}">Delete</a>
		</td>
	</tr>
	</table>
</body>
</html>