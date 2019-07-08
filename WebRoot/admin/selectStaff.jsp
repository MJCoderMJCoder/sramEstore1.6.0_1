<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.root.pojo.Staff"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    
    <title>My JSP 'selectStaff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		td{
			text-align: center;
		}
		th{
			text-align: center;
			width: 20%;
		}
	</style>
  </head>
  
  <body>
  	<p class="pLocation">
  		当前页面
  		>>>
  		查询员工
  	</p>
  	<table width="100%" cellpadding="20%">
  		<tr style="background-image: url('/image/seachBG.png');">
  			<td>
  			<form action="/StaffServlet?method=selectStaff" method="post" target="subFrame">
  				帐号:<input type="text" name="staffId" value=""/>&nbsp;&nbsp;
  				姓名:<input type="text" name="staffName" value=""/>&nbsp;&nbsp;
  				手机:<input type="text" name="staffPhone" value=""/>&nbsp;&nbsp;
  				职务:<input type="text" name="staffPost" value=""/>&nbsp;&nbsp;
  				<input id="submit" type="submit" value="查   询"/>
  			</form>
  			</td>
  		</tr>
  		
  		<tr>
				<table width="100%" style="border-color: gray; border-style: solid; border-width: thin;" cellpadding="10%">
  				<tr valign="top"><th>帐号</th><th>姓名</th><th>手机</th><th>职务</th><th>操作</th></tr>
  				<%
					Staff staff = (Staff) request.getAttribute("staff");
					List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");
					if(staff != null){
				%>	
					<tr>
					<form action="/admin/modifyStaff.jsp" method="post" target="subFrame">
  						<td><%=staff.getStaffId()%><input type="hidden" name="staffId" value="<%=staff.getStaffId()%>"/></td>
  						<td><%=staff.getStaffName() %><input type="hidden" name="staffName" value="<%=staff.getStaffName()%>"/></td>
  						<input type="hidden" name="staffPassword" value="<%=staff.getStaffPassword() %>"/>
  						<td><%=staff.getStaffPhone() %><input type="hidden" name="staffPhone" value="<%=staff.getStaffPhone() %>"/></td>
  						<td><%=staff.getStaffPost() %><input type="hidden" name="staffPost" value="<%=staff.getStaffPost() %>"/></td>
  						<td><input type="submit" value="修改/删除"/></td>
  					</form>
  					</tr>
  				<%
					}
					if(staffList != null){
						for(Staff staffs : staffList){
  				%>
  					<tr>
  						<form action="/admin/modifyStaff.jsp" method="post" target="subFrame">
  						<td><%=staffs.getStaffId()%><input type="hidden" name="staffId" value="<%=staffs.getStaffId()%>"/></td>
  						<td><%=staffs.getStaffName() %><input type="hidden" name="staffName" value="<%=staffs.getStaffName()%>"/></td>
  						<input type="hidden" name="staffPassword" value="<%=staffs.getStaffPassword() %>"/>
  						<td><%=staffs.getStaffPhone() %><input type="hidden" name="staffPhone" value="<%=staffs.getStaffPhone() %>"/></td>
  						<td><%=staffs.getStaffPost() %><input type="hidden" name="staffPost" value="<%=staffs.getStaffPost() %>"/></td>
  						<td><input type="submit" value="修改/删除"/></td>
  						</form>
  					</tr>
  				<%
  					}}
  				%>
  			</table>
  		</tr>
  		
  	</table>
  </body>
</html>
