<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Leave Application</title>
</head>
<body>
	<center>
		<table class="pure-table pure-table-bordered">
			<thead>
			<tr>
				<th>Number</th>
				<th>First Name</th>
				<th>View Detail</th>
			</tr>
			</thead>
			<tbody>
			 <c:forEach var="leave" items="${leaveform}" varStatus="status">
				<tr>
					<td>
						<c:out value="${status.index+1 }"/>
					</td>
					<td>
						<c:out value="${leave.firstname}"/>
					</td>
					<td>
						<c:url var="view" scope="page" value="${pageContext.request.contentType}/approve_reject/viewdetail">
						<c:param name="staffid" value="${leave.staffid}"></c:param>
						<c:param name="name" value="${leave.firstname}"></c:param>
						<c:param name="createdate" value="${leave.createddate}"></c:param>
						<c:param name="startdate" value="${leave.startdate}"></c:param>
						<c:param name="enddate" value="${leave.enddate}"></c:param>
						<c:param name="daystaken" value="${leave.daystaken}"></c:param>
						<c:param name="reason" value="${leave.reason}"></c:param>
						<c:param name="leaveformid" value="${leave.leaveformid}"></c:param>
					</c:url>
					<a href="${view}"><c:out value="View Detail"/></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
	</center>
	<a href="${pageContext.request.contextPath}/Manager/Manager">Home Screen</a>
</body>
</html>