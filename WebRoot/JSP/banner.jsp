<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'banner.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="../CSS/decorate.css">
  </head>
  
  <body>
    <div class="banner">
  	<table width="100%" cellpadding="7">
  		<tr>
  			<td>&nbsp;</td>
  			<td>&nbsp;</td>
  			<td>&nbsp;</td>
  			<td align="right">
  			<a id="a">
  				您好，<font style="text-decoration: underline; color: blue;">XXX</font>
  			</a>
  				
				&nbsp;
  				<a href="#">安全退出</a>
				&nbsp;
			</td>
  		</tr>
  	</table>
  </div>
  
  
    This is my JSP page. <br>
  </body>
</html>
