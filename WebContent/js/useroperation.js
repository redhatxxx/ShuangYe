/**
 * 
 */

function jumptologin(){
	setTimeout("javascript:location.href='/ShuangYe/User/login'", 0); 
}
function jumptoregister(){
	setTimeout("javascript:location.href='/ShuangYe/User/register'", 0); 
}
//删除用户
function deleteuser(id){
	$.get("/ShuangYe/User/deleteuser?userId="+id,function(result){
		if(result.flag=="1"){
			alert("删除成功");
			window.location.reload();
		}else{
			alert("删除失败");
		}
	});
}
//用户注册
function userregister(){
	var username = document.getElementById("user_name").value;
	var userpassword = document.getElementById("user_password").value;
	var userrepassword = document.getElementById("user_repassword").value;
	if(isNull(username)){
		document.getElementById("name_warnmsg").innerHTML="用户名不能为空！";
		return false;
	}
	if(isNull(userpassword)){
		document.getElementById("password_warnmsg").innerHTML="密码不能为空！";
		return false;
	}
	if(isNull(userrepassword)){
		document.getElementById("password_warnmsg").innerHTML="重复密码不能为空！";
		return false;
	}
	if(userpassword!=userrepassword){
		document.getElementById("password_warnmsg").innerHTML="两次密码不一致！";
		return false;
	}
		$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json",
		url : "/ShuangYe/User/user_register",
		//提交内容，富文本信息及当前用户id
		data :JSON.stringify({
			'username' : username,
			'password':userpassword
		}),
		success : function(data) {
			var backstatus = data.backstatus;
			if (backstatus == "success") {
				setTimeout("javascript:location.href='/ShuangYe/Note/getAllInfo'", 0); 
			} else if (backstatus == "fail") {
				document.getElementById("register_message").innerHTML=data.errormsg;
			} else {
				document.getElementById("register_message").innerHTML="注册用户出现错误！";
			}
		},
		error : function() {
			document.getElementById("register_message").innerHTML="注册用户出现错误！";
		}
	});
}

//用户登录
function user_login(){
	var username = document.getElementById("user_name").value;
	var userpassword = document.getElementById("user_password").value;
	if(isNull(username)){
		document.getElementById("login_message").innerHTML="用户名不能为空！";
		return false;
	}
	if(isNull(userpassword)){
		document.getElementById("login_message").innerHTML="密码不能为空！";
		return false;
	}
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json",
		url : "/ShuangYe/User/user_login",
		//提交内容，富文本信息及当前用户id
		data :JSON.stringify({
			'username' : username,
			'password' : userpassword
		}),
		success : function(data) {
			var backstatus = data.backstatus;
			if (backstatus == "success") {
				setTimeout("javascript:location.href='/ShuangYe/Note/getAllInfo'", 0); 
			} else if (backstatus == "fail") {
				document.getElementById("login_message").innerHTML=data.errormsg;
			} else {
				document.getElementById("login_message").innerHTML="登录出现错误！";
			}
		},
		error : function() {
			document.getElementById("login_message").innerHTML="登录出现错误！";
		}
	});
	//旧登录方式
	// document.getElementById("userloginform").submit();
}

//用户登出
function userlogout(){
	setTimeout("javascript:location.href='/ShuangYe/User/user_logout'", 0); 
	//window.location.href="/ShuangYe/User/user_logout";  
}

function jumptouserinfo(){
	setTimeout("javascript:location.href='/ShuangYe/User/edit_userinfo'", 0); 
}
//跳转至编辑用户头像
function jumptoeidtpic(){
	setTimeout("javascript:location.href='/ShuangYe/User/jumpuserpic'", 0); 
}