<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Stiff Security - Daily Status Report</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Daily Status Reporting">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/style.css">


  </head>
  
  <body>
  <p></p>
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  <div class="rcorners2" id="watermark">
  <form:form action="forms/loginForm" commandName="loginForm" method="post">
  <table width="400" style="margin-left: auto; margin-right: auto; border-collapse:collapse;">
    	<tr>
    		<td align="center" colspan="3"><span class="logoname">STIFF SECURITY</span></td>
    	</tr>
    	<tr>
    		<td align="center" colspan="3"><span class="labelsub">DAILY STATUS REPORT</span></td>
    	</tr>
    	<tr>
    		<td align="center" colspan="3">
			    		
   						<div class="errors">
					    	<form:errors path="username"/>
					    	<form:errors path="password"/>
					   </div>
						
    		</td>
    	</tr>
    	<tr>
    		<td rowspan="3" width="160">
    			<img src="<%=request.getContextPath()%>/images/stiff.png"/>
    		</td>
    		
    		
    		<td width="50">
    			<span class="labels">User Name </span>
    			
    		</td>
    		<td width="140"><form:input path="username"/></td>
    		
    	</tr>
    	<tr>
    		<td width="50">
    			<span class="labels">Password &nbsp;</span>
    			
    		</td>
    		<td width="140"><form:password path="password"/></td>
    	</tr>	
    	<tr>
    		
    		<td>
    			<input type="submit" value="Login" id="goButton"/>
    		</td>
    	
    	</tr>
    </table>
    </form:form>
    </div>
    </body>
</html>
