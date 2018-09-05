<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="<c:url value="/jsfiles/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/useroperation.js"/>"></script>
<script type="text/javascript" src="<c:url value="../js/checkinfo.js"/>"></script>
</head>
<body>
	<div id="message_area">
		<label style="color:red" id="register_message"></label>
	<br>
	</div>
	<form  method="post" id="userregisterform">
		<label for="name">Name: </label>
		<input type="text" id="user_name" name="user_name" value="" tabindex="1">
		<label id="name_warnmsg" style="color:red"></label>
		<br>
		<label for="password">PassWord: </label>
		<input type="password" id="user_password" name="user_password" value="" tabindex="1">
		<label id="password_warnmsg" style="color:red"></label>
		<br>
		<label for="password">RePassWord: </label>
		<input type="password" id="user_repassword" name="user_repassword" value="" tabindex="1">
		<div id="buttons">
			<input type="button" id="checkinfo" tabindex="5" onclick="userregister()" value ="注册">
			
		</div>
	</form>
</body>
</html>