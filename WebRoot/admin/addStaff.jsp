<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStaff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="/JavaScript/checkFilter.js"></script>
	
  </head>
  
  <body>
 	<p class="pLocation">
  		当前页面
  		>>>
  		添加员工
  	</p>
		<table width="100%" height="100%">
	    	<tr>
	    		<td width="55%" align="right"><img src="/image/register.png" style="width: 100%;"/></td>
	    		<td align="center" width="45%">
	    			<table cellspacing="20%">
	    				<form method="post" action="StaffServlet?method=addStaff" target="subFrame">
	    				<tr>
	    					<td align="center" nowrap="nowrap"><b>填写注册信息</b></td>
	    				</tr>
	    				<tr>
				    		<td align="left" nowrap="nowrap">姓名：<input type="text" name="staffName" id="staffName" value=""/><b style="color: red;">&nbsp; *</b></td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">
				    			密码：<input id="password" type="password"  name="staffPassword" value=""/><img style="cursor: pointer;" alt="&nbsp" src="../image/glasses.png" title="显示密码" onmousedown="showPW()" onmouseup="clearPW()"/><b style="color: red;">*</b>
				    		</td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">手机：<input type="text" name="staffPhone" id="staffPhone" value=""/><b style="color: red;">&nbsp; *</b></td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">职务：<select name="staffPost" id="staffPost" style="width: 67%;">
									<option value="超级管理员">超级管理员</option>
									<option value="普通管理员" selected="selected">普通管理员</option>
									<option value="用户管理员">用户管理员</option>
									<option value="订单管理员">订单管理员</option>
									<option value="商品管理员">商品管理员</option>
								</select><b style="color: red;">&nbsp; *</b></td>
				    	</tr>
				    	<tr>
				    		<td align="left" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="提交" id="button" onclick="checkStaffInput()"/>
				    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
				    		</td>
				    	</tr>
				    	</form>
	    			</table>
	    		</td>
	    	</tr>
		</table>
  </body>
</html>
