<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is the Update Leave Application Page</title>
</head>
<body>
<h4>This is the Update Leave Application Page</h4>
<form:form method="POST" commandName="update"  action="/ca/manage/update/${update.leaveformid}">
<table>
			<tr>
				<td>Leave Type : </td>
				<td>
				        <form:select path="leaveid" value="${leavename.leavetype}">					
						<form:option value="1">Annual Leave</form:option>
						<form:option value="4">Medical Leave</form:option>
						<form:option value="3">Compensation Leave</form:option>
					</form:select>				
				
			</tr>
			<tr>		
				<td>
				From : 	
				</td>			
				<td>
					    <form:input type="Date" path="startdate" value="${update.startdate}"/>
					    <form:select path="fromshift">
						<form:option value="am">AM</form:option>
						<form:option value="pm">PM</form:option>
					</form:select>	
					
				</td>							
			</tr>
			<tr>
				<td>
				To : 				
				</td>
				<td>
					<form:input type="Date" path="enddate" value="${update.enddate}"/>
					<form:select path="toshift">
						<form:option value="am">AM</form:option>
						<form:option value="pm">PM</form:option>
					</form:select>	
				</td>		
			</tr>
			<tr>
				<td>Reason :</td>
				<td>
				<form:input path="reason"/>	
				</td>
			</tr>
			<tr>
				<td>Work Dissemination : </td>
				<td>
					<form:input path="workdissemination"/>
				</td>
			</tr>
			<tr>
				<td>Contact : </td>
				<td>
					<input name="address" value="${staff.address}"/>
				</td>
			</tr>
			<tr>
				<td>Status : </td>
				<td>
				    <c:out value="${update.lstatus}"/>
					<span></span>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Update"/>
					<input type="submit" value="Back" onclick="window.location.href('${pageContext.request.contextPath}/manage/view')"/>
		            <input type="hidden" name="cancelled">
					<input type="submit" value="Cancelled" name="btn" onclick="{document.view.cancelled.value=this.value}"/>
		</td>
			</tr>
		</table>
		</form:form>
		
</body>
</html>