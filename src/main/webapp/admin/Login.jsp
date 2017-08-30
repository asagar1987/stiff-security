<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stiff Security - Logins</title>
</head>
<body>
	<%@include file="../fragments/header.jsp"%>
	
<fieldset>
	<legend class="labelsub">Add New Employee Login</legend>
	<table width="1300" border="0px" style="border-collapse:collapse;">
 	<s:form action="AddLoginAction" method="post" >
    <tr>
    <td width="400">
    <span class="labelsub">Employee Name</span></td>
    <td width="900">	
    	<select name="fieldOfficerId">
    		<s:iterator value="officersList" status="statusVar">
        		<option value="<s:property value="top.employeeId"/>"><s:property value="top.employeeName"/></option>
        	
    	</s:iterator>
    	</select>
    </td> 
    </tr>
    <tr>
    <td width="400"><span class="labelsub">User Name</span></td>
    <td width="900"><s:textfield  name="loginName"/></td>
    </tr>
    <tr>
    <td width="400">
    <span class="labelsub">Password</span>
    <td width="900">
    <s:textfield  name="loginPassword"/></td>
    
    </tr>
    <tr>
    <td width="400"></td>
    <td width="900" align="right"><s:submit value="Add New Employee Login" id="gobutton"/></td></tr>
    </s:form>
	</table>
</fieldset>	
	
<table width="1300" border="1px" style="border-collapse:collapse;" id="dataTable">
		<tr>
			<th width="450"><span class="labelsub">Employee Name</span></th>
			<th width="350"><span class="labelsub">User Name</span></th>
			<th width="500"><span class="labelsub">Employee Designation</span></th>
		</tr>
		<s:iterator value="loginsList">
        	<tr>
        		<td><s:property value="loginEmployee" ></s:property></td>
        		<td><s:property value="loginUser" ></s:property></td>
        		<td><s:property value="loginDesignation" ></s:property></td>
        	</tr>
    	</s:iterator>
    	
    	<tr>
    	
    	
	</table>
	
	
	
	
</body>
</html>