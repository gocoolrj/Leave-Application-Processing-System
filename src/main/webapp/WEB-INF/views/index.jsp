<!DOCTYPE html>
<html>
<head>
	<title>LAPS</title>
	<style>
	#login_box{
	color: FFFFFF;
	}</style>
</head>
<body>
<div id="wrap">
	<h1>Welcome to Leave Application System</h1>

	<div id="content">
		<div id="login_box">
	
			<form action="${pageContext.request.contextPath}/index_process" method="post">
				Login ID :&nbsp;
			<input type="text" name="empId" class="input name" required="required"/><br/>
			Password :    <input type="password" name="empPass" class="input pwd" required="required"/><br/><br/>
			
			<input type="submit" name="signup" value="Login" class="btn" />

			<input type="reset" name="cancel" value="Cancel" class="btn"   /><br/>
			<p> ${error} </p>
			</form>
		</div><!--End of div="login_box"-->
	</div>
</div>

</body>
</html>