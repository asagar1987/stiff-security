
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://com.nerderg/ajaxanywhere" prefix="aa" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stiff Security - Daily Status Report</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">


 <script type="text/javascript">
 
$(document).ready(
		  
		  /* This is the function that will get executed after the DOM is fully loaded */
		  function () {
		    $( "#datepicker" ).datepicker({
		      changeMonth: true,//this option for allowing user to select month
		      changeYear: false,//this option for allowing user to select from year range
		      maxDate: new Date
		    });
		  });

</script>
<%@include file="fragments/header3.jsp" %> 
</head>
<body>

<fieldset>
	<legend class="labelsub">Submit Visit or Mail Sent Report</legend>
	<form:form action="${pageContext.request.contextPath}/forms/visitForm" method="post" commandName="visitForm" >
	<table width="90%" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		<tr>
			<td width="50%"><span class="labelsub">Site/Client Name</span></td>
			<td width="50%"><form:input path="siteName"/></td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Site/Client Address</span></td>
			<td width="50%">
				<form:textarea path="siteAddress"/>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Select Visit/Mail Date</span></td>
			<td width="50%">
				<form:input id="datepicker" path="visitDate"/>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Contact Person</span></td>
			<td width="50%">
				<form:input path="contactPerson"/>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Contact Number</span></td>
			<td width="50%">
				<form:input path="contactNumber"/>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Contact Email Address</span></td>
			<td width="50%"><form:input path="contactEmail"/></td>
		</tr>
		<tr>
			<td width="50%"><span class="labelsub">Remarks</span></td>
			<td width="50%">
				<form:textarea path="remarks"/>
			</td>
		</tr>
		
		<tr>
			<td width="50%"></td>
    		<td width="50%" align="right"><input type="submit" value="Submit Visit/Mail Report" id="gobutton"/></td>
    	</tr>
    	
	</table>
	</form:form>
	</fieldset>
</body>
</html>