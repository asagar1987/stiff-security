<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "com.stiff.security.daily.status.model.DailyStatusReport" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/style.css">
<title>Daily Status Report</title>

</head>
<body>


	<table width="90%" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		<tr>
			<th colspan="2" align="left" width="20%">
				<img src="<%=request.getContextPath() %>/images/stiff.png"/>
			</th>
			<th colspan="6" style="text-align:center;" width="80%">
				<span class="logoname" >STIFF SECURITY</span><br/><span class="labelsub">DAILY STATUS REPORT</span>
			</th>
		</tr>
		
		<tr>
		<td colspan="4">
			<p><span class="labelsub">SITE NAME</span></p>
		</td>
		<td colspan="4">
			<p><c:out value="${sessionScope.linkReport.site.siteName}"/></p>
		</td>
		</tr>
		<tr>
		<td colspan="4">
			<p><span class="labelsub">SITE OFFICER</span></p>
		</td>
		<td colspan="4">
			<p><c:out value="${sessionScope.linkReport.fieldOfficer.fieldOfficerName}"/></p>
		</td>
		</tr>
		<tr>
		<td colspan="4">
			<p><span class="labelsub">SITE ADDRESS</span></p>
		</td>
		<td colspan="4">
			<p><c:out value="${sessionScope.linkReport.site.siteAddress}"/></p>
		</td>
		</tr>
		<tr>
		<td colspan="4">
			<p><span class="labelsub">NUMBER OF VACANT POSTS</span></p>
		</td>
		<td colspan="4">
			<p><c:out value="${ sessionScope.linkReport.vacantPosts}"/></p>
		</td>
		</tr>
		<tr>
		<td colspan="4">
			<p><span class="labelsub">REPORT DATE</span></p>
		</td>
		<td colspan="4">
			<p><c:out value="${ sessionScope.linkReport.dateTime}"/></p>
		</td>
		</tr>
		<tr>
		<td colspan="4">
			<p><span class="labelsub">LIST OF EMPLOYEES WITH OVERTIME RECORDS</span></p>
		</td>
		<td colspan="4">
			<p>
				<c:forEach items="${sessionScope.linkReport.overTimes}" var="o">
					<li><c:out value="${o.employeeName}"/></li>
				</c:forEach>
			</p>
		</td>
		</tr>
		<tr>
		<td colspan="4">
			<p><span class="labelsub">VACANT POST LEAVE APPLICATIONS</span></p>
		</td>
		<td colspan="4">
			<p>
				<c:forEach items="${sessionScope.linkReport.vacantPostsApplications}" var="o">
					<li><c:out value="${o.fileName}"/></li>
				</c:forEach>
			</p>
		</td>
		</tr>
		
		<tr>
		<td colspan="4">
			<p><span class="labelsub">SIGNATURE</span></p>
		</td>
		<td colspan="4">
			<p><span class="labelsub">FILLED BY : <c:out value="${sessionScope.linkReport.fieldOfficer.fieldOfficerName}"/></span>
			
			<p>
			<p><span class="labelsub">DATED : <c:out value="${sessionScope.linkReport.filledDate}"/></span> 
			</p>
		</td>
		</tr>
		
		
	</table>

	
</body>
</html>