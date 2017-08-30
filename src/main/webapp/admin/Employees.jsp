<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>Stiff Security - Employees</title>
<link rel="stylesheet" type="text/css" href="../styles/style.css">
<%@include file="../fragments/header.jsp" %>

</head>
<body>
<fieldset>
<legend class="labelsub">Add New Employee</legend>
<table width="1300" border="0px" style="border-collapse:collapse;">
 	<s:form action="AddEmployeeAction" method="post" >
 	<tr></tr>
    <tr>
    <td width="400"><span class="labelsub">Employee Name</span></td>
    <td width="500"><s:textfield  name="employeeName" /></td>
    </tr>
    <tr>
    <td width="400"><span class="labelsub">Select Designation</span></td>
    <td width="500">	
    	<select name="desigName">
    		<s:iterator value="designationList" status="statusVar">
        	
        		<option value="<s:property/>"><s:property/></option>
        	
    	</s:iterator>
    	</select>
    </td> 
    </tr>
    <tr><td width="300"></td>
    <td width="100"></td>
    <td width="400" align="right"><s:submit value="Add New Employee" id="gobutton"/></td></tr>
    <tr></tr>
    </s:form>
	</table>
</fieldset>
<table width="1300" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		<tr>
			<th width="100"><span class="labelsub">Employee ID</span></th>
			<th width="400"><span class="labelsub">Employee Name</span></th>
			<th width="400"><span class="labelsub">Employee Designation</span></th>
		</tr>
		<s:iterator value="employeesList">
        	<tr>
        		<td><s:property value="employeeId" ></s:property></td>
        		<td><s:property value="employeeName" ></s:property></td>
        		<td><s:property value="designationName" ></s:property></td>
        	</tr>
    	</s:iterator>
    	
    	<tr>
    	
	</table>
	
	

</body>
</html>