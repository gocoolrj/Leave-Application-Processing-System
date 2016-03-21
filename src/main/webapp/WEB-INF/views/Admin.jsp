<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Administrator</title>
</head>
<body>
	<h1>Welcome Administrator</h1>

	<table>
		<tr>

			<td><a href="${pageContext.request.contextPath}/role/list.html">>>Manage
					User Role</a></td>

		</tr>

		<tr></tr>

		<tr></tr>
		<tr>

			<td><a href="${pageContext.request.contextPath}/staff/list.html">>>Manage Staff</a></td>

		</tr>

		<tr></tr>

		<tr></tr>

		<tr>

			<td><a href="${pageContext.request.contextPath}/leaveType/list.html">>>Manage Leave Type</a></td>

		</tr>

		<tr></tr>

		<tr></tr>

		<tr>

			<td><a href="${pageContext.request.contextPath}/holiday/list.html">>>Manage Holiday</a></td>

		</tr>

		<tr></tr>

		<tr></tr>

		<tr>

			<td><a href="${pageContext.request.contextPath}/entitlement/list.html">>>Manage Leave Entitlement</a></td>

		</tr>

		<tr></tr>

		<tr></tr>

		<tr>

			<td><a href="${pageContext.request.contextPath}/staff/hierarchy/list.html">>>Manage Approval Hierarchy</a></td>

		</tr>

		<tr></tr>

		<tr></tr>

		<tr>

			<td><a href="${pageContext.request.contextPath}/index">>>Log
					out</a></td>

		</tr>

	</table>


</body>
</html>
