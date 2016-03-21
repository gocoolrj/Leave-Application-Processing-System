<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/report/leave" method="post">
<tr>
<td>Leave Type : </td>
<td>
<select name="leaveid" >					
<option value="3">Admin Annual Leave</option>
<option value="2">Professional Annual Leave</option>
<option value="4">Medical Leave</option>
<option value="1">Compensation Leave</option>
</select>				
</td>
</tr>		
<!-- <select name="leave_type">
	<option value="annual" >annual</option>
	<option value="compensation" >compensation</option>
	<option value="medical" >medical</option>
	<option value="all" >all</option>
</select><br> -->
Select a particular period&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
From: <input type="Date" name="startdate" class="date-picker">&nbsp;&nbsp;&nbsp;To: <input type="Date" name="enddate" class="date-picker2">	
<input type="submit" value="Submit" />
</form>
	
</body>
</html>

