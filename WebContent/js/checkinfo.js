/**
 * 用于进行前端数据校验的js文件
 * 如登录注册时校验
 */
function isValidate(){
		form = document.getElementById("rf");
		user_name = form.username.value;
		pass_word = form.userpassword.value;
		re_password = form.repassword.value;
		email = form.email.value;
		if(isNull(user_name)){
			document.getElementById("userwarn").innerHTML="用户名为空";
			return false;
		}
		if(isNull(pass_word)){
			alert("pass_word");
			return false;
		}
		if(isNull(re_password)){
			alert("re_password");
			return false;
		}
		if(isNull(email)){
			alert("email");
			return false;
		}
		if(!isEmail2(email)){
			alert("email wrong");
			return false;
		}
		document.getElementById("rf").submit();
	}
//为空判断
function isNull(str) {
	if (str.length == 0)
		return true;
	else
		return false;
}
//最小长度校验
function minlength(str, length) {
	if (str.length < length)
		return false;
	else
		return true;
}
//最大长度校验
function maxlength() {
	if (str.length > length)
		return false;
	else
		return true;
}
//日期格式校验××××-××-××
function isDate(date) {
	//查找分隔符
	index1 = date.indexOf("-");
	//分隔符存在与否
	if (index1 < 0)
		return false;

	//分割取年月日
	year = date.substring(0, index1);

	date = date.substring(index1 + 1);
	index2 = date.indexOf("-");
	if (index2 < 0)
		return false;

	month = date.substring(0, index2);
	day = date.substring(index2 + 1);
	if (isNumber(year) && isNumber(month) && isNumber(day)) {
		if (month <= 0 || month > 12)
			return false;
		if (day <= 0)
			return false;
		if (year <= 0)
			return false;
		if (month == 1 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 || month == 3) {
			if (day > 31)
				return false;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 30)
				return false;
		}
		if (month == 2) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				if (day > 29)
					return false;
			} else {
				if (day > 28)
					return false;
			}
		}
	} else {
		return false;
	}

	return true;
}
//数字校验
function isNumber(str) {
	for (i = 0; i < str.length; i++) {
		if (str.charAt(i) >= '0' && str.charAt(i) <= '9' || str.charAt(i) == "-" && i == 0)
			continue;
		else
			return false;
	}
	return true;
}
//数字校验
function isNumber2(str) {
	if (str.match("^[0-9]{4}$"))
		return true;
	else
		return false;
}

//email校验
function isEmail(email) {
	if (email.length == 0)
		return false;
	index1 = email.indexOf("@");
	index2 = email.indexOf("\.");
	if (index1 < 1 || index2 < 3 || (index2 - index1 < 2) || (index2 + 1 == email.length))
		return false;
	else
		return true;
}
//email校验
function isEmail2(email) {
	if (email.match("^[a-zA-Z0-9_\-]*@([a-zA-Z0-9_-\]+\.)+[a-z]{2,3}"))
		return true;
	else
		return false;
}