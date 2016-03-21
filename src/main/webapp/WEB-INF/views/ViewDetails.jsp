<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewDetails</title>
</head>
<body>
<h2>View Leave History Details</h2>


<c:if test="${history.lstatus!='applied'}">

<form:form method="POST" commandName="history" action="${pageContext.request.contextPath}/history/update/${history.leaveformid}.html">
<table>
<tbody>
<tr>
<td>Leave Type	:</td>
<td><b><c:out value = "${leavetypename.leavetype}" /></b></td>

</tr>
<tr>
<td>From Date:</td>
<td><b><c:out value = "${history.startdate}"/>(<c:out value = "${history.fromshift}"/>)</b></td>
<td><input type="hidden" value = "${history.startdate}" ></td><td><input type="hidden" value = "${history.fromshift}" ></td>
</tr>
<tr>
<td>To Date:</td>
<td><b><c:out value = "${history.enddate}"/>(<c:out value = "${history.toshift}"/>)</b></td>
<td><input type="hidden" value = "${history.enddate}" ></td><td><input type="hidden" value = "${history.toshift}" ></td>
</tr>
<tr>
<td>Reason:</td>
<td><b><c:out value = "${history.reason}"/></b></td>
<td><input type="hidden" value = "${history.reason}" >
</tr>
<tr>
<td>Contact	:</td>

<td><b><c:out value = "${staffInfo.address}"/></b></td>
<td><input type="hidden" name="address" value = "${staffInfo.address}" ></td>
</tr>
<tr>
<td>Comment	:</td>

<td><form:textarea path="Comment" rows="3" cols="20"/></td>
	<td><form:hidden path ="Comment"/></td>
</tr>
<tr>
<td>Status	:</td>
<td><b><i><c:out value = "${history.lstatus}"/></i></b></td> 
<td><input type="hidden" value = "${history.lstatus}" ></td>
</tr>
<tr>
	<td><form:hidden path ="createdby"/></td>
	<td><form:hidden path ="createddate"/></td>
</tr>
<tr>
	<td><form:hidden path ="updatedby"/></td>
	<td><form:hidden path ="updateddate"/></td>
</tr>
<tr>	
	<td><form:hidden path ="daystaken"/></td>
	<td><form:hidden path ="leaveformid"/></td>
</tr>	
<tr>	
	<td><form:hidden path ="leaveid"/></td>
	<td><form:hidden path ="staffid"/></td>
</tr>
<tr>	
	<td><form:hidden path = "Comment"/></td>
	<td><form:hidden path = "firstname"/></td>
</tr>
<tr>
	<td><form:hidden path="workdissemination"/></td>
</tr>
<tr>

	<!-- <td colspan="2" align="right"> <input type="hidden" name="canceled" />
			<input type="submit" value="Cancel" name="cancel" onclick="{document.viewhistory.canceled.value=this.value}"/>
			</td> -->
</tr>
</tbody>
</table>
</form:form>

</c:if>
<c:if test="${history.lstatus=='applied'}" >
<form:form method="POST" commandName="history" action="${pageContext.request.contextPath}/history/update/${history.leaveformid}.html">
<table>
<tbody>
<tr>
	<td>Leave Type : </td>
	<td>
				        <form:select path="leaveid" value="${leavename.leavetype}">					
						<form:option value="1">Annual Leave</form:option>
						<form:option value="2">Professional Leave</form:option>
						<form:option value="4">Medical Leave</form:option>
						<form:option value="3">Compensation Leave</form:option>
						
					</form:select>				
				</td>
			</tr>
	<%-- <td>
		<select>
			<option selected="selected" >${leavetypename.leavetype}</option>
			<option>Annual Leave</option>
			<option>Medical Leave</option>
			<option>Compensation Leave</option>
		</select>					
	</td> --%>	
<tr>
	<td>From Date:</td>
	<td><form:input path="startdate"/></td>
	<td><form:input path="fromshift"/></td>
</tr>
<tr>
	<td>To Date:</td>
	<td><form:input path="enddate"/></td>
	<td><form:input path="toshift"/></td>
</tr>
<tr>
	<td>Reason:</td>
	<td><form:input path="reason"/></td>
</tr>
<tr>
	<td>Contact	:</td>
	<td><input name="address" value = "${staffInfo.address}"></td>
</tr>
<tr>
	<td>Status	:</td>
	<td>
		<i><b><span>${history.lstatus}</span></b></i>
		<form:hidden path="lstatus"/>
	</td> 
</tr>

<tr>
	<td><form:hidden path ="createdby"/></td>
	<td><form:hidden path ="createddate"/></td>
</tr>
<tr>
	<td><form:hidden path ="updatedby"/></td>
	<td><form:hidden path ="updateddate"/></td>
</tr>
<tr>	
	<td><form:hidden path ="daystaken"/></td>
	<td><form:hidden path ="leaveformid"/></td>
</tr>	
<tr>	
	<td><form:hidden path ="leaveid"/></td>
	<td><form:hidden path ="staffid"/></td>
</tr>
<tr>	
	<td><form:hidden path = "Comment"/></td>
		<td><form:hidden path = "firstname"/></td>
</tr>
<tr>
	<td><form:hidden path="workdissemination"/></td>
</tr>

<tr>
	<td  colspan="2" align="right">
		<input type="submit" value="Update" />
		<!-- <input type="reset" value="Delete" /> -->
		<!--  <input type="hidden" name="canceled" />
			<input type="submit" value="Cancel" name="cancel" onclick="{document.viewhistory.canceled.value=this.value}"/>  -->
	</td>
	
</tr>
</tbody>
</table>
</form:form>
</c:if>
<br/>
<a href="${pageContext.request.contextPath}/history">Go Back</a>
</body>
</html>