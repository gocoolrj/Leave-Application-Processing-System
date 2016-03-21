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
	<h4>Leave Application Detail</h4><br/>
		<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<td>Staff ID</td>
				<td>${param['staffid']}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${param['name']}</td>
			</tr>
			<tr>
				<td>Created Date</td>
				<td>${param['createdate']}</td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td>${param['startdate']}</td>
			</tr>
			<tr>
				<td>End Date</td>
				<td>${param['enddate']}</td>
			</tr>
			<tr>
				<td>Days Taken</td>
				<td>${param['daystaken'] }</td>
			</tr>
			<tr>
				<td>Reason</td>
				<td>${param['reason']}</td>
			</tr>
			
		</table>
		<form name="form" action="${pageContext.request.contextPath}/leave/approveorreject" method="post">
			<textarea name="comment" placeholder="Leave a comment here" cols="28" rows="8" ></textarea>
			<br/>
			<input type="hidden" name="Approved"/>
			<input type="hidden" name="Rejected"/>
			<input type="hidden" name="leaveformid" value="${leaveformid}"/>
			<input class="button-success pure-button" name="btn" type="submit" value="Approve1" onclick="{document.form.Approved.value=this.value;}"/>&nbsp;&nbsp;&nbsp;
			<input class="button-error pure-button" name="btn" type ="submit" value="Reject1" onclick="{document.form.Rejected.value=this.value;}"/>
		</form>
	</center>
</body>
</html>