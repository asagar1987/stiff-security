<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import= "com.stiff.security.daily.status.model.HRForm" %>
	<%@include file="fragments/headerblank.jsp" %>

	
</head>
<script>
function windowpop(url, width, height) {
    var leftPosition, topPosition;
    //Allow for borders.
    leftPosition = (window.screen.width / 2) - ((width / 2) + 10);
    //Allow for title and status bars.
    topPosition = (window.screen.height / 2) - ((height / 2) + 50);
    //Open the window.
    window.open(url, "Window2", "status=no,height=" + height + ",width=" + width + ",resizable=yes,left=" + leftPosition + ",top=" + topPosition + ",screenX=" + leftPosition + ",screenY=" + topPosition + ",toolbar=no,menubar=no,scrollbars=no,location=no,directories=no");
}
</script>
<body>


<fieldset>
	<legend class="labelsub">HR Report</legend>
	<table width="90%" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		
		<tr>
			<th width="40%"><span class="labelsub">Activity</span></th>
			<th width="20%"><span class="labelsub">Response</span></th>
			<th width="40%"><span class="labelsub">Remarks</span></th>
		</tr>
		
		<tr>
	
			<td width="40%"><span class="labelsub">Mail Check</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.mailCheck}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.mailCheckRemarks}"/></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Process</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.nasReportProcess}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.nasReportProcessRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Mail</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.nasReportMail}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.nasReportMailRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Print and Submission to DGM/GM</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.nasReportPrint}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.nasReportPrintRemarks}"/></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">Attendance Submission</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.attendance}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.attendanceRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Uniform Issue (If Any)</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.uniformIssue}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.uniformIssueRemarks}"/></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">Uniform Stock</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.uniformStock}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.uniformStockRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Staff Salary (25th to 28th Each Month)</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.staffSalary}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.staffSalaryRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">PF and ESI Sheet (5th to 10th Each Month)</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.pfEsiSheet}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.pfEsiSheetRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Joining Forms</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.joiningForms}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.joiningFormsRemarks}"/></td>
		</tr>
		
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Admin Work</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.adminWork}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.adminWorkRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Penalty Report (1-3)</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.nasPenaltyReport}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.nasPenaltyReportRemarks}"/></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">Site Visit</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.siteVisit}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.siteVisitRemarks}"/></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">QR Codes Working</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.qrCodesWorking}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.qrCodesWorkingRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">NAS Report Submit to Rakesh</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.nasReportSubmitToRakesh}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.nasReportSubmitToRakeshRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">PASARA</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.pasara}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.pasaraRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">NowFloats</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.nowFloats}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.nowFloatsRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Rate Revision</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.rateRevision}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.rateRevisionRemarks}"/></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">Group Insurance</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.groupInsurance}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.groupInsuranceRemarks}"/></td>
		</tr>
		
		<tr>
			<td width="40%"><span class="labelsub">SMS Software</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.smsSoftware}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.smsSoftwareRemarks}"/></td>
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">Tendering</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.tendering}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.tenderingRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Trainer</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.trainer}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.trainerRemarks}"/></td>
		</tr>
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Police Verification</span></td>
			<td width="20%"><c:out value="${sessionScope.linkReport.policeVerification}"/></td>
			<td width="40%"><c:out value="${sessionScope.linkReport.policeVerificationRemarks}"/></td>
		</tr>
		
		
		
		
		
		<tr>
			<td width="40%"><span class="labelsub">Report Date</span></td>
			<td width="60%" colspan="2"><c:out value="${sessionScope.linkReport.reportDate}"/></td>
			
		</tr>
		
		
		<tr>
			<td width="40%"><span class="labelsub">Filled By</span></td>
			<td width="60%" colspan="2"><c:out value="${sessionScope.linkReport.filledBy.fieldOfficerName}"/></td>
			
		</tr>
		
		
    	
	</table>
	
</fieldset>




</body>

</html>