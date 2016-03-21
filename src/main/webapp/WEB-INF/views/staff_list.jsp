<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Staff List Page</title>
</head>
<body>
<h1>Staff List</h1>

<a href="${pageContext.request.contextPath}/staff/create.html">Create New Staff</a><br/><br/>

<table border = "1" >
<thead>
<tr>
<td>Staff Id</td>
<td>Roll Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Gender</td>
<td>Address</td>
<td>Phone</td>
<td>Email</td>
<td>ManagerID</td>
<td>Action</td>
</tr>

<c:forEach var="staff" items="${allstaff}">
<tr>
<td><c:out value = "${staff.staffid}"/></td>
<td><c:out value = "${staff.roleid} "/></td>
<td><c:out value = "${staff.firstname}"/></td>
<td><c:out value = "${staff.lastname}"/></td>
<td><c:out value = "${staff.gender}"/></td>
<td><c:out value = "${staff.address}"/></td>
<td><c:out value = "${staff.phoneno}"/></td>
<td><c:out value = "${staff.email}"/></td>
<td><c:out value = "${staff.managerid}"></c:out></td>
<td>
<c:url var="myurl" value="/staff/update.html">
<c:param name="staffid" value="${staff.staffid}"></c:param>
</c:url>
<a href="${myurl}">Edit</a>&nbsp;
<c:url var="myurl" value="/staff/delete.html">
<c:param name="staffid" value="${staff.staffid}"></c:param>
</c:url>
<a href="${myurl}">Delete</a><br/>
<%-- <a href="${pageContext.request.contextPath}/staff/delete/${staff.staffid}">Delete</a><br/> --%>
</td>

 </tr>
</c:forEach> 
 </table>
 <br/>
 <a href="${pageContext.request.contextPath}/staff/admin"">Go Home Page</a><br/>
</body>
</html>