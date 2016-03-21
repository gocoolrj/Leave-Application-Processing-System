<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new staff</title>
</head>
<body>

<h1>New Staff page</h1>
<form:form method="POST" commandName="staff" action="${pageContext.request.contextPath}/staff/create.html" >
<table>
<tbody>
<tr>
<td>Staff_StaffID:</td>
<td><form:input path="staffid" /></td>
<td><form:errors path="staffid" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff_RoleID :</td>
<td><form:select path="roleid">
<form:option value="1">Admin</form:option>
<form:option value="2">Manager</form:option>
<form:option value="3">Staff</form:option></form:select></td>
<td><form:errors path="roleid" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff First Name:</td>
<td><form:input path="firstname"/></td>
<td><form:errors path="firstname" cssStyle="color: red;"/></td>

</tr>
<tr>
<td>Staff Last Name:</td>
<td><form:input path="lastname" /></td>
<td><form:errors path="lastname" cssStyle="color: red;"/></td>

</tr>
<tr>
<td>Gender:</td>
<td><form:radiobutton path="gender" value= "M"/>Male
	<form:radiobutton path="gender" value= "F"/>Female
</td>
	<td><form:errors path="gender" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff Address:</td>
<td><form:input path="address" /></td>
<td><form:errors path="address" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff Phone:</td>
<td><form:input path="phoneno" /></td>
<td><form:errors path="phoneno" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff Email:</td>
<td><form:input path="email" /></td>
<td><form:errors path="email" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff Password:</td>
<td><form:password path="pwd" /></td>
<td><form:errors path="pwd" cssStyle="color: red;"/></td>
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
<td><input type="submit" value="Create" /></td>
</tr>
</tbody>
</table>
</form:form>
<br/>
<a href="${pageContext.request.contextPath}/staff/list.html">Go to Staff List Page</a>

</body>
</html>