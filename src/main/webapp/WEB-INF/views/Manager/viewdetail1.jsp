<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h2>Leave Application Detail</h2><br/>
		<table class ="pure-table pure-table-bordered">
			<thead><tr>
				<td>Staff ID</td>
				<td>${staffid}</td>
			</tr></thead>
			<tr>
				<td>Name</td>
				<td>${name}</td>
			</tr>
			<thead><tr>
				<td>Created Date</td>
				<td>${createdate}</td>
			</tr></thead>
			<tr>
				<td>Start Date</td>
				<td>${startdate}</td>
			</tr>
			<thead><tr>
				<td>End Date</td>
				<td>${enddate}</td>
			</tr></thead>
			<tr>
				<td>Days Taken</td>
				<td>${daystaken}</td>
			</tr>
			<thead><tr>
				<td>Reason</td>
				<td>${reason}</td>
			</tr></thead>
		</table>
		<form name="form" action="${pageContext.request.contextPath}/approve_reject/approveorreject" method="post">
			<textarea name="comment" placeholder="Leave a comment here" cols="28" rows="8" ></textarea>
			<br/>
			<input type="hidden" name="Approved"/>
			<input type="hidden" name="Rejected"/>
			<input type="hidden" name="leaveformid" value="${leaveformid}"/>
			<input class="button-success pure-button" name="btn" type="submit" value="Approve" onclick="{document.form.Approved.value=this.value;}"/>&nbsp;&nbsp;&nbsp;
			<input class="button-error pure-button" name="btn" type ="submit" value="Reject" onclick="{document.form.Rejected.value=this.value;}"/>
		</form>
	</center>
</body>
</html>