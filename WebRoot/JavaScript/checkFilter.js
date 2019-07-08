function checkBrowser() { // 检查浏览器
	var browser = navigator.appName
	var b_version = navigator.appVersion
	var version = parseFloat(b_version)
	if ((browser == "Netscape") && (version >= 4)) {
	} else {
		alert("建议使用Mozilla Firefox浏览器（效果更佳）")
	}
}

function login() { // 会员登录界面显示
	var login = document.getElementById("loginDiv");
	login.innerHTML = '<div id="login"></div><form action="" method="post"><table id="loginTable" width="295" cellspacing="8%"><tr><td width="25%" nowrap="nowrap">会员登录</td><td align="right" width="75%" nowrap="nowrap"><label style="cursor: pointer" onclick="closeLogin()">关闭</label></td></tr><tr><td align="right" nowrap="nowrap">帐号：</td><td nowrap="nowrap"><input type = "text" name = "userNo" id="userNo" value="" onfocus="clearUserNo()"/><b style="color: red;">&nbsp; *</b></td></tr><tr><td  align="right" nowrap="nowrap">密码：</td><td nowrap="nowrap"><input type = "password" id="password" name = "password" value=""/><img style="cursor: pointer;" alt="&nbsp" src="../image/glasses.png" title="显示密码" onmousedown="showPW()" onmouseup="clearPW()"/><b style="color: red;">*</b></td></tr><tr><td align="center" nowrap="nowrap" colspan="2"><a href="#">找回帐号</a>&nbsp;&nbsp;&nbsp;<a href="#">忘记密码</a></td></tr><tr><td align="center" nowrap="nowrap" colspan="2"><input type="button" id="loginButton" onclick="checkLogin()" value="登 录"/>&nbsp;&nbsp;&nbsp;<input type = "reset" value="重 置"/></td></tr></table></form>';
	document.getElementById("login").style.display = "block";
	document.getElementById("loginTable").style.display = "block";

}

function adminLogin() { //管理员登录界面显示
	var login = document.getElementById("loginDiv");
	login.innerHTML = '<div id="login"></div><form action="" method="post"><table id="loginTable" width="295" cellspacing="8%"><tr><td width="25%" nowrap="nowrap">管理员登录</td><td align="right" width="75%" nowrap="nowrap"><label style="cursor: pointer" onclick="closeLogin()">关闭</label></td></tr><tr><td align="right" nowrap="nowrap">帐号：</td><td nowrap="nowrap"><input type = "text" name = "userNo" id="userNo" value="" onfocus="clearUserNo()"/><b style="color: red;">&nbsp; *</b></td></tr><tr><td  align="right" nowrap="nowrap">密码：</td><td nowrap="nowrap"><input type = "password" id="password" name = "password" value=""/><img style="cursor: pointer;" alt="&nbsp" src="../image/glasses.png" title="显示密码" onmousedown="showPW()" onmouseup="clearPW()"/><b style="color: red;">*</b></td></tr><tr><td align="center" nowrap="nowrap" colspan="2"><a href="#">找回帐号</a>&nbsp;&nbsp;&nbsp;<a href="#">忘记密码</a></td></tr><tr><td align="center" nowrap="nowrap" colspan="2"><input type="button" id="loginButton" onclick="checkLogin()" value="登 录"/>&nbsp;&nbsp;&nbsp;<input type = "reset" value="重 置"/></td></tr></table></form>';
	document.getElementById("login").style.display = "block";
	document.getElementById("loginTable").style.display = "block";
}

function clearUserNo(){
	var userNo = document.getElementById("userNo").value="";
}
function checkLogin() {
	var userNo = document.getElementById("userNo").value;
	var password = document.getElementById("password").value;
	if(userNo!=null && password!=null && userNo!="" && password!="" && userNo!="VIP帐号、手机、邮箱"){
		document.getElementById("loginButton").type="submit";
	}else{
		alert("登录信息有误，请重新输入");
	}
}
function closeLogin() { // 关闭登录界面
	document.getElementById("login").style.display = "none";
	document.getElementById("loginTable").style.display = "none";
}
function showPW() { // 显示密码
	var pw = document.getElementById("password");
	pw.type = "text";
}
function clearPW() { // 隐藏密码
	var pw = document.getElementById("password");
	pw.type = "password";
}
function checkInput() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	var phoneRegex=new RegExp("1"+"\\d{10}");
//	alert(phoneRegex.test(phone));
	var emailRegex=new RegExp("\\S+"+"@"+"\\w+"+"."+"\\w+");
//	alert(emailRegex.test(email));
	if(username!=null && password!=null && username!=""  && password!="" && phoneRegex.test(phone) && emailRegex.test(email)){
		document.getElementById("button").type="submit";
	}else{
		alert("信息填写有误，请重新输入");
	}
}
function checkStaffInput() {
	var staffName = document.getElementById("staffName").value;
	var staffPassword = document.getElementById("password").value;
	var staffPhone = document.getElementById("staffPhone").value;
	var staffPost = document.getElementById("staffPost").value;
	var phoneRegex=new RegExp("1"+"\\d{10}");
//	alert(phoneRegex.test(phone));
	if(staffName!=null && staffPassword!=null && staffName!=""  && staffPassword!="" && phoneRegex.test(staffPhone) && staffPost!=null && staffPost!=""){
		document.getElementById("button").type="submit";
	}else{
		alert("信息填写有误，请重新输入");
	}
}

function deleteStaff() { //删除员工
	document.getElementById("formStaff").action="StaffServlet?method=deleteStaff";
}