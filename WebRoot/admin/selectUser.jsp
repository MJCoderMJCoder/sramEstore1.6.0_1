<%@ page language="java" import="java.util.*, com.root.pojo.User" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectUser.jsp' starting page</title>
    
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
		}
	</style>
	<script type="text/javascript" src="/JavaScript/jquery-1.11.1.js"></script>\
	<script type="text/javascript">
		$(document).ready(function(){
		
		});
	</script>
  </head>
  
  <body onload="">
  	<p class="pLocation">
  		当前页面
  		>>>
  		查询用户
  	</p>
  	<table width="100%" cellpadding="20%">
  		<tr style="background-image: url('/image/seachBG.png');">
  			<td>
  			<form action="/UserServlet?method=selectUser" method="post" target="subFrame">
  				帐号:<input type="text" name="userId" value=""/>&nbsp;&nbsp;
  				姓名:<input type="text" name="userName" value=""/>&nbsp;&nbsp;
  				手机:<input type="text" name="userPhone" value=""/>&nbsp;&nbsp;
  				邮箱:<input type="text" name="userEmail" value=""/>&nbsp;&nbsp;
  				<input id="submit" type="submit" value="查   询"/>
  			</form>
  			</td>
  		</tr>
  		
  		<tr>
				<table width="100%" style="border-color: gray; border-style: solid; border-width: thin;" cellpadding="10%">
  				<tr valign="top"><th>帐号</th><th>姓名</th><th>手机</th><th>邮箱</th><th>状态</th><th>操作</th></tr>
  				<%
					List<User> userList = (List<User>) request.getAttribute("userList");
					String temp = null;
					if(userList != null){
						for(User Users : userList){
							
  				%>
  					<tr>
  						<form action="/UserServlet?method=lockUser" method="post" target="subFrame">
  						<td><%=Users.getUserId()%><input type="hidden" name="userId" value="<%=Users.getUserId()%>"/></td>
  						<td><%=Users.getUserName() %><input type="hidden" name="userName" value="<%=Users.getUserName()%>"/></td>
  						<input type="hidden" name="userPassword" value="<%=Users.getUserPassword() %>"/>
  						<td><%=Users.getUserPhone() %><input type="hidden" name="userPhone" value="<%=Users.getUserPhone() %>"/></td>
  						<td><%=Users.getUserEmail() %><input type="hidden" name="userPost" value="<%=Users.getUserEmail() %>"/></td>
  						<td><%=Users.getUserState() %>
  						<% if(Users.getUserState().equals("已激活")){%>
								<input type="hidden" name="userState" value="已销户"/></td>
  						<td><input type="submit" value="销户"/></td>
						<% 	}else{%>
								<input type="hidden" name="userState" value="已激活"/></td>
  						<td><input type="submit" value="激活"/></td>					
						<%	}%>
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
