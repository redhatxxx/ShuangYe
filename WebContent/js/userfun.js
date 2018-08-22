/**
 * 
 */

function jumptologin(){
	//window.location.href='/FunFamily/user/login';
	setTimeout("javascript:location.href='/FunFamily/user/login'", 0); 
}
function jumptoregister(){
	//window.location.href='/FunFamily/user/login';
	setTimeout("javascript:location.href='/FunFamily/user/register'", 0); 
}
//删除用户
function deleteuser(id){
	$.get("/FunFamily/user/deleteuser?userId="+id,function(result){
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
	document.getElementById("userregisterform").submit();
}

//用户登录
function user_login(){
	var username = document.getElementById("user_name").value;
	var userpassword = document.getElementById("user_password").value;
	if(isNull(username)){
		document.getElementById("name_warnmsg").innerHTML="用户名不能为空！";
		return false;
	}
	if(isNull(userpassword)){
		document.getElementById("password_warnmsg").innerHTML="密码不能为空！";
		return false;
	}
	document.getElementById("userloginform").submit();
}
//用户登录
function submituser(){
	var param = $("#loginform").serializeArray();
	$.ajax({
		type: "post",
		url:"/FunFamily/user/user_login",
		data:param
	});
}
//用户登出
function userlogout(){
	logoutdeletecookie("username");
	logoutdeletecookie("fun_u_uuid");
	setTimeout("javascript:location.href='/FunFamily/user/user_logout'", 0); 
	//window.location.href="/FunFamily/user/user_logout";  
}

function jumptouserinfo(){
	setTimeout("javascript:location.href='/FunFamily/user/edit_userinfo'", 0); 
}
//跳转至编辑用户头像
function jumptoeidtpic(){
	setTimeout("javascript:location.href='/FunFamily/user/jumpuserpic'", 0); 
}

function loginwithuuid(uuid){
	setTimeout(window.location.href='/FunFamily/user/loginwithuuid?uuid='+uuid, 0);
//	setTimeout("javascript:location.href='/FunFamily/user/loginwithuuid?uuid='"+uuid, 0); 
}