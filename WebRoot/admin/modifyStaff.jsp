<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.root.pojo.Staff"%>
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

		<title>My JSP 'addStaffSuccess.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="/JavaScript/checkFilter.js"></script>
	</head>

	<body>
		<p class="pLocation">
			当前页面 >>> 员工信息详情
		</p>
		<table width="100%" height="100%">
	    	<tr>
	    		<td width="55%" align="right"><img src="/image/register.png" style="width: 100%;"/></td>
	    		<td align="center" width="45%">
	    			<table cellspacing="20%">
	    				<form method="post" action="StaffServlet?method=modifyStaff" target="subFrame" id="formStaff">
	    				<tr>
	    					<td align="center" nowrap="nowrap"><b>员工信息</b></td>
	    				</tr>
	    				<tr>
				    		<td align="left" nowrap="nowrap">
				    			帐号&nbsp;：<input id="staffId" type="text" name="staffId" value=<%=request.getParameter("staffId")%> readonly="readonly"/>
				    		</td>
				    	</tr>
	    				<tr>
				    		<td align="left" nowrap="nowrap">姓名&nbsp;：<input type="text" name="staffName" id="staffName" value=<%=request.getParameter("staffName")%> /></td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">
				    			密码&nbsp;：<input id="password" type="password"  name="staffPassword" value=<%=request.getParameter("staffPassword")%> /><img style="cursor: pointer;" alt="&nbsp" src="../image/glasses.png" title="显示密码" onmousedown="showPW()" onmouseup="clearPW()"/><b style="color: red;">*</b>
				    		</td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">手机&nbsp;：<input type="text" name="staffPhone" id="staffPhone" value=<%=request.getParameter("staffPhone")%> /></td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">职务&nbsp;：<select name="staffPost" id="staffPost" style="width: 67%;">
									<option value="超级管理员">超级管理员</option>
									<option value="普通管理员" selected="selected">普通管理员</option>
									<option value="用户管理员">用户管理员</option>
									<option value="订单管理员">订单管理员</option>
									<option value="商品管理员">商品管理员</option>
								</select><b style="color: red;">&nbsp; *</b></td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">&nbsp;&nbsp;<input type="button" onclick="checkStaffInput()" id="button" value="修改信息"/>
				    			&nbsp;&nbsp;&nbsp;<input type="submit" value="开除员工" onmousedown="deleteStaff()" id="delete"/>
				    		</td>
				    	</tr>
				    	</form>
	    			</table>
	    		</td>
	    	</tr>
		</table>
	</body>
</html>
