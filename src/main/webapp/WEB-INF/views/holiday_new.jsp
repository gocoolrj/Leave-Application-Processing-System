<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <script>
	  $(function() {
	    $( "#datepicker" ).datepicker();
	  });
  </script>
<title>Add a new holiday</title>
</head>
<body>
<h1>Create New Holiday</h1>
<form method="POST" action="${pageContext.request.contextPath}/holiday/create.html">
<table>
	<tr>
		<td><input type="hidden" name = "hid"/></td>
	</tr>
	<tr>
		<td>Holiday Date</td>
		<td><input type="date" name="hdate"/></td>
	</tr>
	<tr>
		<td>Holiday Description</td>
		<td><input type="text" name = "description"/></td>
	</tr>
	<tr>
		<td><input type="hidden" name = "createdby" value= "test"/></td>
	</tr>
	<tr>
		<td><input type="hidden" name = "createddate" value= "2014-12-01"/></td>
	</tr>
	<tr>
		<td><input type="hidden" name = "updatedby" value= "test"/></td>
	</tr>
	<tr>
		<td><input type="hidden" name = "updateddate" value= "2014-12-01"/></td>
	</tr>
	<tr>
		<td><input type= "submit" value="Add"/></td>
	</tr>
</table>

</form>
<br/>
<a href="${pageContext.request.contextPath}/holiday/list.html">Go to Holiday List</a>
<%-- <form:form method="POST" commandName="holiday" action="${pageContext.request.contextPath}/holiday/addHoliday.html" >
<table>
<tbody>
<tr>
<td><form:hidden path="hid" /></td>
<td><form:errors path="hid" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Holiday Date :</td>
<td><form:input type="date" path="hdate"/></td>
<td><form:input path="hdate" id="datepicker"/></td>
<td><form:errors path="hdate" cssStyle="color: red;"/></td>
<td><c:url var="myurl" value="/holiday/addHoliday">
<c:param name="hdate" value="hdate"></c:param>
</c:url></td>
</tr>
<tr>
<td>Description :</td>
<td><form:input path="description"/></td>
<td><form:errors path="description" cssStyle="color: red;"/></td>
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
</form:form> --%>


</body>
</html>