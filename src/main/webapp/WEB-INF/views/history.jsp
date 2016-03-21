<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Leave History</title>
</head>


<body>
<table border="0px"  cellpadding="0px" cellspacing="0px" width="100%">

<tr>
<td>
<h1>Leave History</h1>
<h4>Leave Type: 1 --> Compensation</h4>
<h4>Leave Type: 2 --> Professional_Annual</h4>
<h4>Leave Type: 3 --> Admin_Annual</h4>
<h4>Leave Type: 4 --> Medical</h4>
	
</td>
</tr>
<tr>
<td>
<table border='0px' cellpadding="10px" cellspacing="0px" class="index" >
<thead>
<tr >
<td>LeaveType</td>
<td>From</td>
<td>To</td>
<td>Status</td>
<td>Action</td>
</tr>
</thead>
<tbody>

<c:forEach var="history" items="${AllLeave}">
<tr>
<td><c:out value = "${history.leaveid}"/></td>
<td><c:out value = "${history.startdate} "/></td>
<td><c:out value = "${history.enddate}"/></td>
<td><c:out value = "${history.lstatus}"/></td>
<td><a href="${pageContext.request.contextPath}/history/edit/${history.leaveformid}.html">View Details</a></td>
 </tr>
</c:forEach> 
 
</tbody>
</table>
</td>
</tr>
</table>

<br/>
	<a href="${pageContext.request.contextPath}/Manager/Manager">Home Screen</a>
</body>
</html>