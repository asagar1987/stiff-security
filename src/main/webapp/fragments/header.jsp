<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="http://code.jquery.com/jquery-1.10.2.min.js" >
</script>

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
		<td width="2%">
		</td>
		<td width="2%">
			
		</td>
		<td width="2%">
		</td>
		<td width="20%">
			<s:url action="ReportsAction.action" var="ReportTag" >
    		</s:url>
			<a href="<s:property value="#ReportTag" />" ><span class="menuLabel">Daily Reports</span></a>
		</td>
		<td width="18%">
			<s:url action="EmployeeAction.action" var="EmployeeTag" >
    		</s:url>
			<a href="<s:property value="#EmployeeTag" />" ><span class="menuLabel">Employees</span></a>
			
		</td>
		<td width="18%" id="Designations">
			<s:url action="DesignationAction.action" var="DesignationTag" >
    		</s:url>
			<a href="<s:property value="#DesignationTag" />" ><span class="menuLabel">Designations</span></a>
		</td>
		<td width="18%">
			<s:url action="LocationAction.action" var="LocationTag" >
    		</s:url>
			<a href="<s:property value="#LocationTag" />" ><span class="menuLabel">Locations</span></a>
		</td>
		<td width="4%">
			<s:url action="CreateLoginAction.action" var="LoginTag" >
    		</s:url>
			<a href="<s:property value="#LoginTag" />" ><span class="menuLabel">Logins</span></a>
		</td>
		<td width="18%">
			
		</td>
		
		<td width="2%">
		</td>
		<td width="2%">
		</td>
	</tr>



</table>
</body>

</html>