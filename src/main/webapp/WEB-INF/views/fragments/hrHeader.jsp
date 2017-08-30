<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <!-- Start of HubSpot Embed Code -->
  <script type="text/javascript" id="hs-script-loader" async defer src="//js.hs-scripts.com/2938379.js"></script>
<!-- End of HubSpot Embed Code -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.loggedInUser.fieldOfficerName==null}">
	<% response.sendRedirect(request.getContextPath()+"/forms/loginForm"); %>
</c:if>


<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/style.css">

</head>

<body> 
<table width="100%" style="border:none; border-collapse:collapse;" height="15%">
	<tr height="10%" bgcolor="#F3F3F3">
		<td colspan="3" align="center">
			<img src="<%=request.getContextPath() %>/images/stiff.png"/>
		</td>
		<td colspan="6" align="left">
			<span class="logoname">STIFF SECURITY</span>
			<br/>
			<span class="labelsubs">&nbsp;Daily Status Reporting System</span>
		</td>
		<td>
			<span class="labelsub">Welcome, ${sessionScope.loggedInUser.fieldOfficerName}
			</span>
			<p></p>
			<form:form action="${pageContext.request.contextPath}/forms/logoutForm">
			<input type="submit" value="Logout" class="gobutton" id="gobutton">
			</form:form>
		</td>
		
	</tr>
	<tr height="40px" class="menu">
		<td width="8%">
		</td>
		<td width="8%">
			
		</td>
		<td width="4%">
		</td>
		<td width="20%">
			
		</td>
		<td width="20%">
			
			
		</td>
		
		<td width="20%">
			
		</td>
		<td width="20%">
			<a href="${pageContext.request.contextPath}/forms/dailyStatusReportForm" ><span class="menuLabel">Daily Status Report</span></a>
		</td>
		<td width="20%">
			
		</td>
		<td width="2%">
		</td>
		<td width="2%">
		</td>
	</tr>



</table>
</body>

</html>