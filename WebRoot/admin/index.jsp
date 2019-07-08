<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="/CSS/adminDecorate.css">
		<script type="text/javascript" src="/JavaScript/adminList.js"></script>
		<script type="text/javascript" src="/JavaScript/checkFilter.js"></script>

	</head>

	<body>
		<jsp:include page="../JSP/banner.jsp"></jsp:include><br />
		<table width="100%" height="87%" cellpadding="20">
			<tr>
				<td width="15%" valign="top" style="border-right-style: solid; border-right-color: #F8F8F8">
					<table width="100%" cellpadding="5">
						<tr><td class="First" align="center"><lable id="homeLabel" onclick="home()">♀本人信息</label><hr/></td></tr>
						<tr><td class="First" align="center"><br/><br/><lable id="staffLabel" onclick="staff()">员工管理&nbsp;<font size="1">∨</font></label><div id="staffList"></div><hr/></td></tr>
						<tr><td class="First" align="center"><br/><br/><lable id="userLabel" onclick="user()">用户管理&nbsp;<font size="1">∨</font></label><div id="userList"></div><hr/></td></tr>
						<tr><td class="First" align="center"><br/><br/><lable id="formLabel" onclick="form()">订单管理&nbsp;<font size="1">∨</font></label><div id="formList"></div><hr/></td></tr>
						<tr><td class="First" align="center"><br/><br/><lable id="goodsLabel" onclick="goods()">商品管理&nbsp;<font size="1">∨</font></label><div id="goodsList"></div><hr/></td></tr>
					</table>
				</td>
				<td valign="top">
				
					<iframe id="subFrame" width="100%" height="100%" frameborder="0" scrolling="no" name="subFrame" src="/admin/MyHome.jsp"></iframe>
				
				</td>
			</tr>
		</table>

		<br>
		<%@ include file="bottom.html"%>
	</body>
</html>
