
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
<%@include file="fragments/hrHeader.jsp" %> 
</head>
<body>



<fieldset>
	<legend class="labelsub">Submit HR Daily Status Report</legend>
	<form:form action="hrReportForm" method="post" commandName="hrForm" enctype="multipart/form-data">
	<table width="90%" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		
		<tr>
			<td width="40%"><span class="labelsub">Activity</span></td>
			<td width="10%"><span class="labelsub">Yes</span></td>
			<td width="10%"><span class="labelsub">No</span></td>
			<td width="15%"><span class="labelsub">Not Applicable</span></td>
			<td width="35%"><span class="labelsub">Remarks</span></td>
		</tr>
		
		<tr>
	
			<td width="40%"><span class="labelsub">Mail Check</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="mailCheck" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="mailCheck" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="mailCheck" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="mailCheckRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Process</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportProcess" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportProcess" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="nasReportProcess" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="nasReportProcessRemarks"></form:textarea></span></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Mail</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportMail" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportMail" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="nasReportMail" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="nasReportMailRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Print and Submission to DGM/GM</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportPrint" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportPrint" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="nasReportPrint" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="nasReportPrintRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Attendance Submission</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="attendance" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="attendance" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="attendance" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="attendanceRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Uniform Issue (If Any)</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="uniformIssue" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="uniformIssue" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="uniformIssue" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="uniformIssueRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Uniform Stock</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="uniformStock" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="uniformStock" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="uniformStock" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="uniformStockRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Staff Salary (25th to 28th Each Month)</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="staffSalary" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="staffSalary" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="staffSalary" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="staffSalaryRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">PF and ESI Sheet (5th to 10th Each Month)</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="pfEsiSheet" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="pfEsiSheet" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="pfEsiSheet" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="pfEsiSheetRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Joining Forms</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="joiningForms" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="joiningForms" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="joiningForms" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="joiningFormsRemarks"></form:textarea></span></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">Admin Work</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="adminWork" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="adminWork" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="adminWork" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="adminWorkRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Penalty Report (1-3)</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasPenaltyReport" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasPenaltyReport" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="nasPenaltyReport" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="nasPenaltyReportRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Site Visit</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="siteVisit" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="siteVisit" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="siteVisit" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="siteVisitRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">QR Codes Working</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="qrCodesWorking" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="qrCodesWorking" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="qrCodesWorking" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="qrCodesWorkingRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Submit to Rakesh</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportSubmitToRakesh" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nasReportSubmitToRakesh" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="nasReportSubmitToRakesh" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="nasReportSubmitToRakeshRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">PASARA</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="pasara" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="pasara" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="pasara" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="pasaraRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">NowFloats</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nowFloats" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="nowFloats" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="nowFloats" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="nowFloatsRemarks"></form:textarea></span></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">Rate Revision</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="rateRevision" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="rateRevision" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="rateRevision" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="rateRevisionRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Group Insurance</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="groupInsurance" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="groupInsurance" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="groupInsurance" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="groupInsuranceRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">SMS Software</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="smsSoftware" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="smsSoftware" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="smsSoftware" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="smsSoftwareRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Tendering</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="tendering" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="tendering" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="tendering" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="tenderingRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Trainer</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="trainer" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="trainer" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="trainer" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="trainerRemarks"></form:textarea></span></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Police Verification</span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="policeVerification" value="Yes"/></span></td>
			<td width="10%"><span class="labelsub"><form:radiobutton path="policeVerification" value="No"/></span></td>
			<td width="15%"><span class="labelsub"><form:radiobutton path="policeVerification" value="Not Applicable"/></span></td>
			<td width="35%"><span class="labelsub"><form:textarea path="policeVerificationRemarks"></form:textarea></span></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Select Report Date</span></td>
			
			<td width="35%">
				<form:input id="datepicker" path="reportDate"/>
				<input type="hidden" id="filledBy" name="filledBy" value="${loginDetails.fieldOfficerId}"/>
			</td>
		</tr>
			<tr>
			<td width="40%"></td>
			<td width="10%"></td>
			<td width="10%"></td>
			<td width="15%"></td>
    		<td width="35%" align="right"><input type="submit" value="Submit Report" id="gobutton"/></td>
    	</tr>
    	
	</table>
	</form:form>
	</fieldset>
</body>
</html>