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
<title>Stiff Security - Employees</title>
<link rel="stylesheet" type="text/css" href="../styles/style.css">
	
  
  
 
<%@include file="fragments/header.jsp" %>

</head>
<body>
<fieldset>
<legend class="labelsub">Add New Employee</legend>
<table width="1300" border="0px" style="border-collapse:collapse;" id="example">
 	<form:form action="${pageContext.request.contextPath}/forms/employeeForm" method="post" commandName="employeeForm" >
 	<tr></tr>
    <tr>
    <td width="200"><span class="labelsub">Employee Name</span></td>
    <td width="300"><form:input path="employeeName"/><form:hidden path="employeeId"/></td>
    
    <td width="200"><span class="labelsub">Select Designation</span></td>
    <td width="500">	
    	<select name="designationId">
    		<c:forEach items="${designationList}" var="statusVar">
    			<c:choose>
	    			<c:when test="${employeeForm.designationId ne statusVar.designationId}">
        				<option value="${statusVar.designationId}">${statusVar.designationName}</option>
        			</c:when>
        			<c:otherwise>
        				<option value="${statusVar.designationId}" selected>${statusVar.designationName}</option>
        			</c:otherwise>
        		</c:choose>
        	</c:forEach>
    	</select>
    </td> 
    </tr>
    <tr>
    <td width="100">
    <span class="labelsub">Shift</span>
    </td>
    <td width="300">
      	<form:select path="shift">
    		
        		<c:choose>
				    <c:when test="${employeeForm.shift eq 'Normal'}">
				       <option value="Normal" selected>Normal</option>
				    </c:when>    
				    <c:otherwise>
				        <option value="Normal">Normal</option>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${employeeForm.shift eq 'Night'}">
				       <option value="Night" selected>Night</option>
				    </c:when>    
				    <c:otherwise>
				        <option value="Night">Night</option>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${employeeForm.shift eq 'Day'}">
				       <option value="Day" selected>Day</option>
				    </c:when>    
				    <c:otherwise>
				        <option value="Day">Day</option>
				    </c:otherwise>
				</c:choose>
    	
    	</form:select>
    	
    </td>
    <td width="200"><span class="labelsub">Site Description</span></td>
    
    <td width="400">
    	<form:select path="siteId">
    		<c:forEach items="${locationList}" var="loc">
    			<c:choose>
	    			<c:when test="${employeeForm.siteId ne loc.siteId}">
	        			<option value="${loc.siteId}">${loc.siteName},${loc.siteAddress}</option>
	        		</c:when>
	        		<c:otherwise>
	        			<option value="${loc.siteId}" selected>${loc.siteName},${loc.siteAddress}</option>
	        		</c:otherwise>
	        	</c:choose>
	    	</c:forEach>
    	</form:select>
    </td>
    </tr>
    <tr>
    <td width="100">
    <span class="labelsub">Username</span>
    </td>
    <td width="300">
      	<form:input path="username"/>    	
    </td>
    <td width="200"><span class="labelsub">Password</span></td>
    <td width="400">
    	<form:password path="password"/>
    </td>
    
    
    </tr>
    <tr>
    <td width="400"></td>
    <td width="500" align="right">
    <c:choose>
    <c:when test="${employeeForm.employeeId == 0}">
    <input type="submit" value="Add New Employee" id="gobutton"/>
    <input type="hidden" name="act" value="add">
    </c:when>
    <c:otherwise>
    <input type="submit" value="Update Employee" id="gobutton"/>
    <input type="hidden" name="act" value="update">
    </c:otherwise>
    </c:choose>
    </td>
    </tr>
    </form:form>
	</table>
</fieldset>
<table width="1300" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		<thead>
		<tr>
			<th width="100"><span class="labelsub">Employee ID</span></th>
			<th width="200"><span class="labelsub">Employee Name</span></th>
			<th width="200"><span class="labelsub">Employee Designation</span></th>
			<th width="200"><span class="labelsub">Shift</span></th>
			<th width="200"><span class="labelsub">Site Name</span></th>
			<th width="200"><span class="labelsub">Site Address</span></th>
			<th width="200"><span class="labelsub">Site Officer</span></th>
			<th width="50"><span class="labelsub">Modify</span></th>
		</tr>
		</thead>
		<c:forEach items="${employeesList}" var="emp">
        	<tr>
        		<td>${emp.employeeId}</td>
        		<td>${emp.employeeName}</td>
        		<td>${emp.designation.designationName}</td>
        		<td>${emp.shift}</td>
        		<td>${emp.site.siteName}</td>
        		<td>${emp.site.siteAddress}</td>
        		<td>${emp.site.fieldOfficer.fieldOfficerName}</td>
        		<td><a href="${pageContext.request.contextPath}/forms/employeeForm/editEmployee?id=${emp.employeeId}&designation=${emp.designation.designationName}">Edit</a>
        		<br/>
        		<a href="${pageContext.request.contextPath}/forms/employeeForm/removeEmployee?id=${emp.employeeId}&designation=${emp.designation.designationName}">Delete</a>
        		</td>
        	</tr>
    	</c:forEach>
    	
    	<tr>
    	
	</table>
	
	

</body>
</html>