<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Leave Entitlement</h1>
<form:form  method="POST" commandName="leaveType" action="${pageContext.request.contextPath}/entitlement/update/${param['leaveid']}">
<table>
<tbody>
<tr>
<td><form:hidden path="leaveid" /></td>
</tr>
<tr>
<td>Leave Type :</td>
<td><form:input path="leavetype" readonly="true"/></td>
</tr>
<tr>
<td>Limit :</td>
<td><form:input path="limitdays"/></td>
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
</tr>
</tbody>
</table>
</form:form>
<br/>
<a href="${pageContext.request.contextPath}/entitlement/list.html">Go to Entitlement List</a><br/>
</body>
</html>