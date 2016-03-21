<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Form</title>
</head>
<body>
	<form:form method="POST" commandName="lf" action="${pageContext.request.contextPath}/leaveform/apply-form">
	<table>
	
	<tr>
	 <td> LeaveType</td>
	  <td><form:select path="leaveid">
                <form:option value="1">Compensation</form:option>
               
            </form:select>
	</td>
	</tr> 
	<tr>
	<td>Staff Id</td>
	<td><form:input path="staffid" value='<%=request.getSession().getAttribute("name") %>'/></td>
	</tr>
	<tr>
	<td>Start Date</td>
	<td><form:input path="startdate" type="date"/></td>
	</tr>
	<tr>
	<td>Shift</td>
	<td><form:select path="fromshift">
		<form:option value="am">am</form:option>
		<form:option value="pm">pm</form:option>
		
		</form:select>
		</td></tr>
		<tr>
	<td>Reason:</td>
		<td><textarea cols="25" rows="5"></textarea></td>
		</tr>
		<tr>
		<td><form:hidden path="toshift" value="am"></form:hidden></td>	
		</tr>
		<tr>
		<td><form:hidden path="daystaken" value="0.5"/></td>
		</tr>
		<tr>
		<td><form:hidden path="lstatus" value="applied1"/></td>
		</tr>
		<tr>
		<td><form:hidden path="comment" values="nil"/></td>
		</tr>
			<tr>
		<td><form:hidden path="enddate" value="2014-10-11"/></td>
		</tr>
		<tr>
		<td><form:hidden path="createddate" value="2014-10-11"/></td>
		</tr>
		<tr>
		<td><form:hidden path="updateddate" value="2014-10-11"/></td>
		</tr>
		<tr>
		<td><form:hidden path="createdby" value="vewv"/></td>
		</tr>
		<tr>
		<td><form:hidden path="updatedby" value="sdvsdv"/></td>
		</tr>	
		
		<form:button type="submit" >SUBMIT</form:button>
		
		</table>
	</form:form>
	<br/>
	<a href="${pageContext.request.contextPath}/Staff/Staff">Home Screen</a>
</body>
</html>