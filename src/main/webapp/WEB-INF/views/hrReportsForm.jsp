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
	<legend class="labelsub">All Visits</legend>
	<table width="95%" border="0px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable" >
	
		<tr>
			<th><span class="labelsub">Report ID</span></th>
			<th><span class="labelsub">Report Date</span></th>
			<th><span class="labelsub">Filled By</span></th>
			<th><span class="labelsub">Show Details</span></th>
		</tr>
		
		<c:forEach items="${myHRFormList}" var="mdsr">
			<tr>
				<td>${mdsr.hrReportId }</td>
				<td>${mdsr.reportDate }</td>
				<td>${mdsr.filledBy.fieldOfficerName }</td>
				<td><a href="hrReportForm/getHRReport?reportId=${mdsr.hrReportId}" target="_blank">Show Full Report</a></td>
			</tr>
		</c:forEach>
	</table>
	
</fieldset>




</body>

</html>