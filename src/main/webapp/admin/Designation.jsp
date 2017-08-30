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
<title>Stiff Security - Designations</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/style.css">
<%@include file="../fragments/header.jsp" %>

</head>
<body >
<fieldset>
	<legend class="labelsub">Add New Designation</legend>
	<table width="1300" border="0px" style="border-collapse:collapse;">
 	<s:form action="AddDesignationAction" method="post" name="designation">
    <tr>
    <td width="400"><span class="labelsub">Designation Name</span></td>
    <td width="900"><s:textfield  name="designationName"/></td>
    </tr>
    <tr><td width="400"></td><td width="900" align="right"><s:submit value="Add New Designation" id="gobutton"/></td></tr>
    </s:form>
	</table>
</fieldset>
<br/>

	<table width="1300" border="1px" style="border-collapse:collapse;" id="dataTable">
		<tr>
			<th width="400"><span class="labelsub">Designation ID</span></th>
			<th width="900"><span class="labelsub">Designation Name</span></th>
		</tr>
		<s:iterator value="designationsList">
        	<tr>
        		<td><s:property value="top.designationId" ></s:property></td>
        		<td><s:property value="top.designationName" ></s:property></td>
        	</tr>
    	</s:iterator>
    	
    	<tr>
    	
    	
	</table>
	
	
</body>
</html>