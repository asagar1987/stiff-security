<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@include file="fragments/header.jsp" %>

	
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
	<legend class="labelsub">All Meetings</legend>
	<table width="95%" border="0px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable" >
	
		<tr>
			<th width="100"><span class="labelsub">Meeting ID</span></th>
			<th width="350"><span class="labelsub">Site Name</span></th>
			<th width="200"><span class="labelsub">Site Address</span></th>
			<th width="100"><span class="labelsub">Meeting Date</span></th>
			<th width="300"><span class="labelsub">Contact Person</span></th>
			<th width="300"><span class="labelsub">Contact Number</span></th>
			<th width="100"><span class="labelsub">Email Address</span></th>
			<th width="100"><span class="labelsub">Your Name</span></th>
			<th width="200"><span class="labelsub">Remarks</span></th>
		</tr>
		<c:forEach items="${myMeetingList}" var="mdsr">
			<tr>
				<td>${mdsr.meetingId }</td>
				<td>${mdsr.siteName }</td>
				<td>${mdsr.siteAddress }</td>
				<td>${mdsr.meetingDate }</td>
				<td>${mdsr.contactPerson}</td>
				<td>${mdsr.contactNumber}</td>
				<td>${mdsr.contactEmail}</td>
				<td>${mdsr.fieldOfficer.fieldOfficerName}</td>
				<td>${mdsr.remarks }</td>
			</tr>
		</c:forEach>
	</table>
	
</fieldset>

<fieldset>
	<legend class="labelsub">All Visits</legend>
	<table width="95%" border="0px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable" >
	
		<tr>
			<th width="100"><span class="labelsub">Visit ID</span></th>
			<th width="350"><span class="labelsub">Site Name</span></th>
			<th width="200"><span class="labelsub">Site Address</span></th>
			<th width="100"><span class="labelsub">Visit Date</span></th>
			<th width="300"><span class="labelsub">Contact Person</span></th>
			<th width="300"><span class="labelsub">Contact Number</span></th>
			<th width="100"><span class="labelsub">Email Address</span></th>
			<th width="100"><span class="labelsub">Marketing Officer</span></th>
			<th width="200"><span class="labelsub">Remarks</span></th>
		</tr>
		<c:forEach items="${myVisitList}" var="mdsr">
			<tr>
				<td>${mdsr.visitId }</td>
				<td>${mdsr.siteName }</td>
				<td>${mdsr.siteAddress }</td>
				<td>${mdsr.visitDate }</td>
				<td>${mdsr.contactPerson}</td>
				<td>${mdsr.contactNumber}</td>
				<td>${mdsr.contactEmail}</td>
				<td>${mdsr.fieldOfficer.fieldOfficerName}</td>
				<td>${mdsr.remarks }</td>
			</tr>
		</c:forEach>
	</table>
	
</fieldset>

<fieldset>
	<legend class="labelsub">All Follow-ups</legend>
	<table width="95%" border="0px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable" >
	
		<tr>
			<th width="100"><span class="labelsub">Follow-up ID</span></th>
			<th width="350"><span class="labelsub">Site Name</span></th>
			<th width="200"><span class="labelsub">Site Address</span></th>
			<th width="100"><span class="labelsub">Follow-up Date</span></th>
			<th width="300"><span class="labelsub">Contact Person</span></th>
			<th width="300"><span class="labelsub">Contact Number</span></th>
			<th width="100"><span class="labelsub">Email Address</span></th>
			<th width="100"><span class="labelsub">Marketing Officer</span></th>
			<th width="200"><span class="labelsub">Remarks</span></th>
		</tr>
		<c:forEach items="${myFollowupList}" var="mdsr">
			<tr>
				<td>${mdsr.followupId }</td>
				<td>${mdsr.siteName }</td>
				<td>${mdsr.siteAddress }</td>
				<td>${mdsr.followupDate }</td>
				<td>${mdsr.contactPerson}</td>
				<td>${mdsr.contactNumber}</td>
				<td>${mdsr.contactEmail}</td>
				<td>${mdsr.fieldOfficer.fieldOfficerName}</td>
				<td>${mdsr.remarks }</td>
			</tr>
		</c:forEach>
	</table>
	
</fieldset>
</body>

</html>