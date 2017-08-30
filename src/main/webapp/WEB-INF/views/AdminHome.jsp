<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
	<legend class="labelsub">Submitted Reports</legend>
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
			<th width="100"><span class="labelsub">Filled By</span></th>
		</tr>
		<c:forEach items="${myDailyReportsList}" var="mdsr">
			<tr>
				<td><a onClick="return windowpop(this.href, 800, 533);" href="dailyStatusReportForm/getReport?reportId=${mdsr.reportId}" target="_blank">${mdsr.reportId }</a></td>
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
				<td>${mdsr.fieldOfficer.fieldOfficerName }</td>
			</tr>
		</c:forEach>
	</table>
	
</fieldset>
</body>

</html>