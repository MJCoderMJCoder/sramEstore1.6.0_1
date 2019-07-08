<%@ page language="java" import="java.util.*, com.root.pojo.Form" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectForm.jsp' starting page</title>
    
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
  </head>
  
  <body>
  	<p class="pLocation">
  		当前页面
  		>>>
  		查询订单
  	</p>
  	<table width="100%" cellpadding="20%">
  		<tr style="background-image: url('/image/seachBG.png');">
  			<td>
  			<form action="/FormServlet?method=selectForm" method="post" target="subFrame">
  				商品:<input type="text" name="formGoods" value=""/>&nbsp;&nbsp;
  				买家:<input type="text" name="formUser" value=""/>&nbsp;&nbsp;
  				邮编:<input type="text" name="formPostcode" value=""/>&nbsp;&nbsp;
  				状态:<input type="text" name="formState" value=""/>&nbsp;&nbsp;
  				<input id="submit" type="submit" value="查询"/>
  			</form>
  			</td>
  		</tr>
  		
  		<tr>
				<table width="100%" style="border-color: gray; border-style: solid; border-width: thin;" cellpadding="10%">
  				<tr valign="top"><th>订单号</th><th>下单商品</th><th>买家姓名</th><th>发货地址</th><th>邮编</th><th>买家手机</th><th>订单状态</th><th>操作</th></tr>
  				<%
					List<Form> formList = (List<Form>) request.getAttribute("formList");
					String temp = null;
					if(formList != null){
						for(Form forms : formList){
							
  				%>
  					<tr>
  						<form action="/FormServlet?method=lockForm" method="post" target="subFrame">
  						<td><%=forms.getFormId()%><input type="hidden" name="FormId" value="<%=forms.getFormId()%>"/></td>
  						<td><%=forms.getFormGoods()%><input type="hidden" name="FormName" value="<%=forms.getFormGoods()%>"/></td>
  						<td><%=forms.getFormUser() %><input type="hidden" name="FormPhone" value="<%=forms.getFormUser() %>"/></td>
  						<td><%=forms.getFormAddress() %><input type="hidden" name="FormPost" value="<%=forms.getFormAddress() %>"/></td>
  						<td><%=forms.getFormPostcode() %><input type="hidden" name="FormPost" value="<%=forms.getFormPostcode() %>"/></td>
  						<td><%=forms.getFormPhone() %><input type="hidden" name="FormPost" value="<%=forms.getFormPhone() %>"/></td>
  						<td><%=forms.getFormState() %>
  						<% if(forms.getFormState().equals("已下单")){%>
								<input type="hidden" name="FormState" value="已发货"/></td>
  						<td><input type="submit" value="发货"/></td>
						<% 	}else if(forms.getFormState().equals("已发货")){%>
								<input type="hidden" name="FormState" value="已成交"/></td>
  						<td><input type="submit" value="成交"/></td>					
						<%	}else{%>
							<input type="hidden" name="FormState" value="删除"/></td>
  						<td><input type="submit" value="删除"/></td>
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
