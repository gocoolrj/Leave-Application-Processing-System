<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Manager</title>
</head>
<body>
<h1>
	Welcome Manager
</h1>

<table>

<tr>

<td><a href="${pageContext.request.contextPath}/history">>>Subordinate Leave History</a></td>

</tr>

<tr></tr>

<tr></tr>

<tr>

<td><a href="${pageContext.request.contextPath}/approve_reject/approverejectleave">>>Approve/Reject Leave</a></td>

</tr>

<tr></tr>

<tr></tr>
<tr>

<td><a href="${pageContext.request.contextPath}/leave/leave">>>View compensation</a></td>

</tr>
<tr></tr>
<tr></tr>
<tr>

<td><a href="${pageContext.request.contextPath}/report/leave">>>Generate Report</a></td>

</tr>
<tr></tr>
<tr></tr>

<tr>

<td><a href="${pageContext.request.contextPath}/index">>>Log out</a></td>

</tr>
<tr></tr>
<tr></tr>





</table>

</body>
</html>