<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Leave Type</title>
</head>
<body>
<h1>Edit Leave Type</h1>
	<form:form method="POST" commandName="leaveType" action="${pageContext.request.contextPath}/leaveType/edit/${leaveType.leaveid}.html">
		<table>
			<tbody>	
				<tr>
					<td>Leave ID : </td>
					<td><form:hidden path="leaveid"/></td>
					<td></td>
				</tr>
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
					<td><form:hidden path="createdby" value="test"/></td> <%-- Need to add user from session --%>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><form:hidden path="createddate" value="2014-12-1"/></td> <%-- Need to add current date --%>
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
					<td><input type="submit" value="Update"/></td>
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