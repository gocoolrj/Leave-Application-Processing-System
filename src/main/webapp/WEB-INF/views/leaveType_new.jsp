<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Leave Type</title>
</head>
<body>
	<h1>Create Leave Type</h1>
	<form:form method="POST" commandName="leaveType" action="${pageContext.request.contextPath}/leaveType/create.html">
		<table>
			<tbody>	
				<tr>
					<td>Leave Type : </td>
					<td><form:input path="leavetype"/></td>
					<td><form:errors path="leavetype" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>LimitDays : </td>
					<td><form:input path="limitdays"/></td>
					<td><form:errors path="limitdays" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td></td>
					<td><form:hidden path="createdby" value="test"/></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><form:hidden path="createddate" value="2014-12-1"/></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><form:hidden path="updatedby" value="test"/></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><form:hidden path="updateddate" value="2014-12-1"/></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="Create"/></td>
					<td></td>
					<td></td>
				</tr>				
			</tbody>	
		</table>
	</form:form>
	
	<br/>
	<a href="${pageContext.request.contextPath}/leaveType/list.html">Go to LeaveType List</a>
</body>
</html>