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
<title>Stiff Security - Locations</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/style.css">
<%@include file="fragments/header.jsp" %>

</head>

<body>

<fieldset>

	<legend class="labelsub">Add New Site</legend>
	<table width="1300" border="0px" style="border-collapse:collapse;">
 	<form:form action="locationForm" method="post" commandName="locationForm" >
 	<tr>
    <td width="1300" colspan="2"><span class="errors"><form:errors path="locationName"/></span></td>
    </tr>
    <tr>
    <td width="400"><span class="labelsub">Location Name</span></td>
    <td width="900"><form:input path="locationName"/></td>
    </tr>
    <tr>
    <td width="400"><span class="labelsub">Location Address</span></td>
    <td width="900"><form:textarea path="locationAddress" rows="5" cols="30" /></td>
    <tr>
    <td width="400">	
    <span class="labelsub">Select Field Officer*</span>
    </td>
    <td width="900">
    	<select name="siteOfficerId">
    		<c:forEach items="${siteOfficerList}" var="statusVar">
        		<option value="${statusVar.fieldOfficerId}">${statusVar.fieldOfficerName}</option>
        	</c:forEach>
    	</select>
    </td> 
    </tr>
    <tr><td colspan="2"></td></tr>
    <tr><td colspan="2"></td></tr>
    <tr><td colspan="2"><span class="labels"><strong>*Note:</strong> Only Field Officer and above employees are available to be selected as Field Officers.</span></td></tr>
    <tr><td width="400"></td>
    <td width="900" align="right"><input type="submit" value="Add New Location" id="gobutton"/></td>
    </tr>
    </form:form>
	</table>
</fieldset>

<table width="1300" border="1px" style="border-collapse:collapse;" id="dataTable">
		<tr>
			<th width="200"><span class="labelsub">Site Name</span></th>
			<th width="400"><span class="labelsub">Site Address</span></th>
			<th width="300"><span class="labelsub">Field Officer</span></th>
			<th width="400"><span class="labelsub">Field Officer Designation</span></th>
		</tr>
		
		<c:forEach items="${locationList}" var="location">
        	<tr>
        		<td>${location.siteName}</td>
        		<td>${location.siteAddress}</td>
        		<td>${location.fieldOfficer.fieldOfficerName}</td>
        		<td>${location.fieldOfficer.designation.designationName}</td>
        	</tr>
    	</c:forEach>
    	
    	<tr>
    	    	
	</table>
	
	
	

</body>
</html>