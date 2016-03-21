<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Staff Page</title>
</head>

<body>
<h1>Edit Staff page</h1>

<form:form  method="POST" commandName="staff" action="${pageContext.request.contextPath}/staff/update/${param['staffid']}">
<table>
<tbody>
<tr>
<!-- <td>Staff_StaffID :</td> -->
<td><form:hidden path="staffid" /></td>
</tr>
<tr>
<td>Staff_RoleID :</td>
<td><form:input path="roleid" readonly="true"/></td>
</tr>
<tr>
<td>Staff First Name:</td>
<td><form:input path="firstname"/></td>
</tr>
<tr>
<td>Staff Last Name:</td>
<td><form:input path="lastname" /></td>
</tr>
<tr>
<td>Gender:</td>
<%-- <td><form:input path="gender" /></td> --%>
<td><form:radiobutton path="gender" value= "M"/>Male
	<form:radiobutton path="gender" value= "F"/>Female</td>
</tr>
<tr>
<td>Staff Address:</td>
<td><form:input path="address" /></td>
</tr>
<tr>
<td>Staff Phone:</td>
<td><form:input path="phoneno" /></td>
</tr>
<tr>
<td>Staff Email:</td>
<td><form:input path="email" /></td>
</tr>
<tr>
<td>Staff Password:</td>
<td><form:input path="pwd" /></td>
</tr>
<tr>
<td>Staff ManagerID:</td>
<td><form:input path="managerid" /></td>
</tr>
<tr>
<td><form:hidden path ="createdby" value= "test"/></td>
</tr>
<tr>
<td><form:hidden path ="updatedby" value= "test"/></td>
</tr>
<tr>
<td><form:hidden path ="createddate" value= "2014-12-01"/></td>
</tr>
<tr>
<td><form:hidden path ="updateddate" value= "2014-12-01"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Update" /></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/staff/list.html">Go to Staff List</a>
</body>
</html>