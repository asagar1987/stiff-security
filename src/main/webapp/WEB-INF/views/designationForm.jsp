<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%@include file="fragments/header.jsp" %>

</head>
<body >
<fieldset>
	<legend class="labelsub">Add New Designation</legend>
	<table width="1300" border="0px" style="border-collapse:collapse;">
 	<form:form action="designationForm" commandName="designationForm" method="post">
 	<tr><td width="1300" colspan="2"><span class="errors"><form:errors path="designationName"/></span></tr>
    <tr>
    <td width="400"><span class="labelsub">Designation Name</span></td>
    <td width="900"><form:input  path="designationName"/></td>
    </tr>
    <tr><td width="400"></td><td width="900" align="right"><input type="submit" value="Add New Designation" id="gobutton"/></td></tr>
    </form:form>
	</table>
</fieldset>
<br/>

	<table width="1300" border="1px" style="border-collapse:collapse;" id="dataTable">
		<tr>
			<th width="400"><span class="labelsub">Designation ID</span></th>
			<th width="900"><span class="labelsub">Designation Name</span></th>
		</tr>
		<c:forEach var="listValue" items="${designationList}">
        	<tr>
        		<td>${listValue.designationId}</td>
        		<td>${listValue.designationName}</td>
        	</tr>
    	</c:forEach>
    	
    	<tr>
    	
    	
	</table>
	
	
</body>
</html>