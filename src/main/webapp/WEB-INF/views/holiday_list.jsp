<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Holiday Page</title>
</head>
<body>


<h1>Holiday List </h1>
<a href="${pageContext.request.contextPath}/holiday/create.html">Create New Holiday</a><br/><br/>
<table border = "1" >
<thead>
<tr>
<td>Holiday Id</td>
<td>Holiday Date</td>
<td>Description</td>
</tr>

<c:forEach var="holiday" items="${allHoliday}">
<tr>
<td><c:out value = "${holiday.hid}"/></td>
<td><c:out value = "${holiday.hdate} "/></td>
<td><c:out value = "${holiday.description}"/></td>
 </tr>
</c:forEach> 
 </table>
 <br/>
 <a href="${pageContext.request.contextPath}/holiday/admin"">Go Home Page</a>
</body>
</html>