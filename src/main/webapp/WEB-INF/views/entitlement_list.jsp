<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Leave List</title>
</head>
<body>
<h1>Entitlement List </h1>
<table border = "1" >
<thead>
<tr>
<td>Leave Id</td>
<td>Leave Type</td>
<td>Limit days</td>
<td>Action</td>
</tr>

<c:forEach var="leavetype" items="${allLeave}">
<tr>
<td><c:out value = "${leavetype.leaveid}"/></td>
<td><c:out value = "${leavetype.leavetype} "/></td>
<td><c:out value = "${leavetype.limitdays}"/></td>
<td>
<c:url var="myurl" value="/entitlement/update">
<c:param name="leaveid" value="${leavetype.leaveid}"></c:param>
</c:url>
<a href="${myurl}">Edit</a><br/>
</td>

 </tr>
</c:forEach> 
 </table>
 <br/>
 <a href="${pageContext.request.contextPath}/entitlement/admin">Go Home Page</a><br/>
</body>
</html>