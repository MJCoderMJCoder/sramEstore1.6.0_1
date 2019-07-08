function home() {
	document.getElementById("subFrame").src = "/admin/MyHome.jsp";

	document.getElementById("staffDL").style.display = "none"; //隐藏员工管理列表
	document.getElementById("userDL").style.display = "none"; //隐藏用户管理列表
	document.getElementById("formDL").style.display = "none"; //隐藏订单管理列表
	document.getElementById("goodsDL").style.display = "none"; //隐藏商品管理列表
}


function staff() {
	var staffList = document.getElementById("staffList");
	staffList.innerHTML = '<dl id="staffDL"><dt class="second" onclick="addStaff()">添加员工</dt><dt class="second" onclick="selectStaff()">查询员工</dt></dl>';
	document.getElementById("staffDL").style.display = "block";
	
	document.getElementById("userDL").style.display = "none"; //隐藏用户管理列表
	document.getElementById("formDL").style.display = "none"; //隐藏订单管理列表
	document.getElementById("goodsDL").style.display = "none"; //隐藏商品管理列表
}
function addStaff() { //添加员工
	document.getElementById("subFrame").src = "/admin/addStaff.jsp";
}
function selectStaff() { //查询员工
	document.getElementById("subFrame").src = "/admin/selectStaff.jsp";
}


function user() {
	var userList = document.getElementById("userList");
	userList.innerHTML = '<dl id="userDL"><dt class="second" onclick="selectUser()">查询用户</dt></dl>';
	document.getElementById("userDL").style.display = "block";

	document.getElementById("staffDL").style.display = "none"; //隐藏员工管理列表
	document.getElementById("formDL").style.display = "none"; //隐藏订单管理列表
	document.getElementById("goodsDL").style.display = "none"; //隐藏商品管理列表
}
function selectUser() { //查询用户
	document.getElementById("subFrame").src = "/admin/selectUser.jsp";
}


function form() {
	var userList = document.getElementById("formList");
	formList.innerHTML = '<dl id="formDL"><dt class="second" onclick="selectForm()">查询订单</dt></dl>';
	document.getElementById("formDL").style.display = "block";
	
	document.getElementById("staffDL").style.display = "none"; //隐藏员工管理列表
	document.getElementById("userDL").style.display = "none"; //隐藏用户管理列表
	document.getElementById("goodsDL").style.display = "none"; //隐藏商品管理列表
}
function selectForm() { //查询订单
	document.getElementById("subFrame").src = "/admin/selectForm.jsp";
}

function goods() {
	var goodsList = document.getElementById("goodsList");
	goodsList.innerHTML = '<dl id="goodsDL"><dt class="second" onclick="selectGoods()">查询商品</dt><dt class="second" onclick="addGoods()">添加商品</dt><dt class="second" onclick="addGoodsType()">添加类别</dt></dl>';
	document.getElementById("goodsDL").style.display = "block";
	
	document.getElementById("staffDL").style.display = "none"; //隐藏员工管理列表
	document.getElementById("formDL").style.display = "none"; //隐藏订单管理列表
	document.getElementById("userDL").style.display = "none"; //隐藏用户管理列表
}
function selectGoods() { //查询商品
	document.getElementById("subFrame").src = "/admin/selectGoods.jsp";
}
function addGoods() { //添加商品
	document.getElementById("subFrame").src = "/admin/addGoods.jsp";
}
function addGoodsType() { //添加商品种类
	document.getElementById("subFrame").src = "/admin/addGoodsType.jsp";
}
　
