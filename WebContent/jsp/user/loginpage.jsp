<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<c:url value="../js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/useroperation.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/checkinfo.js"/>"></script>
<title>用户登录</title>
</head>
<body>
	<div>
<!-- 		<form method="post" id="userloginform"> -->
			<label for="name">Name: </label> <input type="text" id="user_name"	name="user_name" value="" tabindex="1"> 
			<label for="password">PassWord: </label> <input type="password"	id="user_password" name="user_password" value="" tabindex="1">
			<br>
			<label style="color:red" id="login_message"></label>
			<br>
			<div id="buttons">
				<input type="button" id="submit_login" tabindex="5"
					onclick="user_login()" value="Login">
			</div>
<!-- 		</form> -->
	</div>

</body>
</html>