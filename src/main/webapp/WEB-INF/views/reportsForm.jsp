<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@taglib uri="http://com.nerderg/ajaxanywhere" prefix="aa" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<%@include file="fragments/header.jsp" %>
</head>

<body >

	<table width="1300" border="1px" style="border-collapse:collapse;margin-left:auto;margin-right:auto;" id="dataTable">
		<tr>
			<th width="180"><span class="labelsub">Site's Name</span></th>
			<th width="180"><span class="labelsub">Site Officer</span></th>
			<th width="150"><span class="labelsub">Report Date</span></th>
			<th width="100"><span class="labelsub">Posts Vacant</span></th>
			<th width="100"><span class="labelsub">Over Times</span></th>
			<th width="200"><span class="labelsub">Absent Guards</span></th>
			<th width="200"><span class="labelsub">Submitted By</span></th>
			<th width="100"><span class="labelsub">Submitted On</span></th>
		</tr>
		<s:iterator value="dailyReportList">
        	<tr>
        		<td><s:property value="top.siteName" ></s:property></td>
        		<td><s:property value="top.officerName" ></s:property></td>
        		<td><s:property value="top.dateTime" ></s:property></td>
        		<td><s:property value="top.postVacant" ></s:property></td>
        		<td><s:property value="top.ot" ></s:property></td>
        		<td>
        			<s:iterator value="top.absentees">
        				<li><s:property/></li>
        			</s:iterator>
        		</td>
        		<td><s:property value="top.filledBy" ></s:property></td>
        		<td><s:property value="top.filledOn" ></s:property></td>
        	</tr>
    	</s:iterator>
    	
    	<tr>
    	
    	
	</table>
	
 </body>

</html>