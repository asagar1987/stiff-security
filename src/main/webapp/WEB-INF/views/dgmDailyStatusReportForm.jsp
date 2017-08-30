
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
 var eNameList='';
 var siteMap = [
                <c:forEach items="${siteList}" var="s">
                	{siteId : "${s.siteId}", siteName : "${s.siteName}", siteAddress : "${s.siteAddress}"},
                </c:forEach>
                
                ]
 
$(document).ready(
		  
		  /* This is the function that will get executed after the DOM is fully loaded */
		  function () {
		    $( "#datepicker" ).datepicker({
		      changeMonth: true,//this option for allowing user to select month
		      changeYear: false,//this option for allowing user to select from year range
		      maxDate: new Date
		    });
		  });



$( function() {
  var availableTags = [
 <c:forEach items="${employeeList}" var="e">"${e.employeeName}",</c:forEach>
   
  ];
  $( "#textarea" ).autocomplete({
    source: availableTags
  });
} );
	  
function addEmployesOverTime()
  {
	  
	  	  var eName = document.getElementById('textarea').value;
	 	  if(eName=="")
		 	 {
	 		 document.getElementById('overTimeError').innerHTML="";
	 		document.getElementById('overTimeError').innerHTML="Please select an Employee";
		 	 }
		 	 else
		     {
		 		document.getElementById('overTimeError').innerHTML="";
				if(eNameList=="")
				  eNameList=eName;
			  else
			  	eNameList = eNameList + ','+eName;
		 	  document.getElementById('overTimeList').innerHTML=document.getElementById('overTimeList').innerHTML+'<li>'+eName;
		 	  //alert(eNameList);
			  document.getElementById('overTimes').value=eNameList;
			  document.getElementById('textarea').value="";
	     }
  }


function getSiteAddress()
{
	var id = document.getElementById('siteId').value;
	var result = $.grep(siteMap, function(e){ return e.siteId == id; });
	document.getElementById('siteAddressDiv').innerHTML=result[0].siteAddress;
}

function addLeaveBoxesField()
{
	var count = document.getElementById('vacantPosts').value;
	
	if(count==0)
	{
		document.getElementById('postVacantError').innerHTML="";
 		document.getElementById('postVacantError').innerHTML="No Leaves will be updated in the System";
	}
	else
	{
		document.getElementById('postVacantError').innerHTML="";
		for(i=0;i<count;i++)
			{
				var input=document.createElement('input');
		    	input.type="file";	
		    	input.name="files["+i+"]";
		    	var br = document.createElement('br');
				document.getElementById('leaveApplicationDiv').appendChild(input);
				document.getElementById('leaveApplicationDiv').appendChild(br);
			}
	}
	
	
}

</script>
<%@include file="fragments/dgmHeader.jsp" %> 
</head>
<body>

<fieldset>
	<legend class="labelsub">My Reports</legend>
	<table width="90%" border="0px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable" >
	
		<tr>
			<th width="100"><span class="labelsub">Report ID</span></th>
			<th width="350"><span class="labelsub">Site Name</span></th>
			<th width="200"><span class="labelsub">Site Address</span></th>
			<th width="100"><span class="labelsub">Shift</span></th>
			<th width="300"><span class="labelsub">List of Overtimes</span></th>
			<th width="300"><span class="labelsub">Leave Applications</span></th>
			<th width="100"><span class="labelsub">Reporting Date</span></th>
			<th width="100"><span class="labelsub">Filled Date</span></th>
		</tr>
		<c:forEach items="${myDailyReportsList}" var="mdsr">
			<tr>
				<td><a href="dailyStatusReportForm/getReport?reportId=${mdsr.reportId}" target="tab">${mdsr.reportId }</a></td>
				<td>${mdsr.site.siteName }</td>
				<td>${mdsr.site.siteAddress }</td>
				<td>${mdsr.shift }</td>
				<td>
					<c:forEach items="${mdsr.overTimes}" var="ot">
						<li>${ot.employeeName}</li>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${mdsr.vacantPostsApplications}" var="vpa">
						<li><a href="dailyStatusReportForm/downloadLeaveApplicationFile?reportId=${mdsr.reportId}&name=${vpa.fileName}">${vpa.fileName}</a></li>
					</c:forEach>
				</td>
				<td>${mdsr.dateTime }</td>
				<td>${mdsr.filledDate }</td>
			</tr>
		</c:forEach>
	</table>
	
</fieldset>

<fieldset>
	<legend class="labelsub">Submit Daily Status Report</legend>
	<form:form action="dgmDailyStatusReportForm" method="post" commandName="dgmDailyStatusReportForm" enctype="multipart/form-data">
	<table width="90%" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		<tr>
			<td width="50%"><span class="labelsub">Select Site Name (Verify Address)</span></td>
			<td width="50%">
			<form:select path="siteId" onChange="getSiteAddress();">
			<option label="Select Site Name" value="Select Site Name"/>
			<c:forEach items="${siteList}" var="top" >
				<option  label="${top.siteName}" value="${top.siteId}"/>
        	</c:forEach>
    		</form:select>
    		<br/>
    		
			</td>
			
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Selected Site Address</span></td>
			<td width="50%">
				<div id="siteAddressDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Select Shift</span></td>
			<td width="50%">
				<form:select path="shift">
					<option value="Normal">Normal</option>
					<option value="Day">Day</option>
					<option value="Night">Night</option>
				</form:select>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Add OverTimes</span></td>
			<td width="50%">
				<input type="text" id="textarea"/>
				<br/>
				<a href="#" id="addOverTime" onClick="addEmployesOverTime();">Add Employee</a>
				<form:input type="hidden" path="overTimes" id="overTimes"/>
				
				<div id="overTimeError"></div>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">List of Selected Employees for overtime</span></td>
			<td width="50%">
				<div id="overTimeList"></div>
			</td>
		</tr>
		<tr>
			<td width="50%"><span class="labelsub">Number of Vacant Posts</span></td>
			<td width="50%">
				<form:input path="vacantPosts"/>
				<br/>
				<a href="#" id="addLeaveBoxes" onClick="addLeaveBoxesField();">Add Leave Applications</a>
				<input type="hidden" id="vacantPostsHidden"/>
				<div id="postVacantError"></div>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Upload Leave Applications for vacant posts</span></td>
			<td width="50%">
				<div id="leaveApplicationDiv">
				
				</div>
			</td>
		</tr>
		
		<tr>
			<td width="50%"><span class="labelsub">Select Report Date</span></td>
			<td width="50%">
				<form:input id="datepicker" path="reportDate"/>
				<input type="hidden" id="filledBy" name="filledBy" value="${loginDetails.fieldOfficerId}"/>
			</td>
		</tr>
			<tr>
			<td width="50%"></td>
    		<td width="50%" align="right"><input type="submit" value="Submit Report" id="gobutton"/></td>
    	</tr>
    	
	</table>
	</form:form>
	</fieldset>
</body>
</html>