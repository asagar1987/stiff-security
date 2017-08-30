<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/style.css">

</head>

<body> 
<table width="100%" style="border:none; border-collapse:collapse;" height="15%">
	<tr height="10%" bgcolor="#F3F3F3">
		<td colspan="3" align="center">
			<img src="<%=request.getContextPath()%>/images/stiff.png"/>
		</td>
		<td colspan="6" align="left">
			<span class="logoname">STIFF SECURITY</span>
		</td>
		<td>
			<span class="labelsub">Welcome, <s:property value="#session.loginId" />
			</span>
			<p></p>
			<s:form action="logout">
			<input type="submit" value="Logout" class="gobutton" id="gobutton">
			</s:form>
		</td>
		
	</tr>
	<tr height="40px" class="menu">
		<td width="100%" align="center" colspan="10">
		<span class="menuLabel">Daily Status Report</span>
		</td>
		
	</tr>



</table>
</body>

</html>