<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Staff Hierarchy</title>
</head>
<body>
<h1>Manage Staff Hierarchy</h1>

<form:form  method="POST" commandName="staff" action="${pageContext.request.contextPath}/staff/hierarchy/edit/${param['staffid']}">
<table>
<tbody>
<tr>
<td>Staff_StaffID :</td>
<td><form:input path="staffid" readonly="true" /></td>
</tr>
<tr>
<td>Staff_RoleID :</td>
<td><form:select path="roleid">
<form:option value="1">Admin</form:option>
<form:option value="2">Manager</form:option>
<form:option value="3">Staff</form:option></form:select></td>
</tr>
<tr>
<td>Staff First Name:</td>
<td><form:input path="firstname" readonly="true"/></td>
</tr>
<tr>
<td>Staff Last Name:</td>
<td><form:input path="lastname" readonly="true"/></td>
</tr>
<tr>
<!-- <td>Gender:</td> -->
<td><form:hidden path="gender" /></td>
</tr>
<tr>
<!-- <td>Staff Address:</td> -->
<td><form:hidden path="address" /></td>
</tr>
<tr>
<!-- <td>Staff Phone:</td> -->
<td><form:hidden path="phoneno" /></td>
</tr>
<tr>
<td>Staff Email:</td>
<td><form:input path="email" readonly="true"/></td>
</tr>
<tr>
<!-- <td>Staff Password:</td> -->
<td><form:hidden path="pwd" /></td>
</tr>
<tr>
<!-- <td>Staff ManagerID:</td> -->
<td><form:hidden path="managerid" /></td>
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
<td><input type="submit" value="Update" /></td>
<td></td>  
</tr>
</tbody>
</table>
</form:form>
<br/>
<a href="${pageContext.request.contextPath}/staff/hierarchy/list.html">Go to Hierarchy List</a><br/>
</body>
</html>