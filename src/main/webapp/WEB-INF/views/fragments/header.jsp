<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.loggedInUser.fieldOfficerName==null}">
	<% response.sendRedirect(request.getContextPath()+"/forms/loginForm"); %>
</c:if>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <!-- Start of HubSpot Embed Code -->
  <script type="text/javascript" id="hs-script-loader" async defer src="//js.hs-scripts.com/2938379.js"></script>
<!-- End of HubSpot Embed Code -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/style.css">
 
</head>

<body> 
<table width="100%" style="border:none; border-collapse:collapse;" height="15%">
	<tr height="10%" bgcolor="#F3F3F3">
		<td colspan="3" align="center">
			<img src="<%=request.getContextPath() %>/images/stiff.png"/>
		</td>
		<td colspan="8" align="left">
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
		
		<td width="5%">
			
		</td>
		<td width="18%">
			<a href="${pageContext.request.contextPath}/forms/AdminHome" ><span class="menuLabel">Daily Reports</span></a>
		</td>
		<td width="12%">
			<a href="${pageContext.request.contextPath}/forms/employeeForm" ><span class="menuLabel">Employees</span></a>
			
		</td>
		<td width="12%" id="Designations">
			<a href="${pageContext.request.contextPath}/forms/designationForm" ><span class="menuLabel">Designations</span></a>
		</td>
		<td width="12%">
			<a href="${pageContext.request.contextPath}/forms/locationForm" ><span class="menuLabel">Locations</span></a>
		</td>
		<td width="18%">
			<a href="${pageContext.request.contextPath}/forms/marketingReportsForm" ><span class="menuLabel">Marketing/Telecallers</span></a>
		</td>
		<td width="3%">
			
		</td>
		<td width="12%">
			<a href="${pageContext.request.contextPath}/forms/dgmReportsForm" ><span class="menuLabel">DGM</span></a>
		</td>
		<td width="8%">
			<a href="${pageContext.request.contextPath}/forms/hrReportsForm" ><span class="menuLabel">HR</span></a>
		</td>
		<td width="8%">
			<a href="${pageContext.request.contextPath}/forms/hrReportsForm" ><span class="menuLabel"></span></a>
		</td>
		<td width="8%">
			<a href="${pageContext.request.contextPath}/forms/hrReportsForm" ><span class="menuLabel"></span></a>
		</td>
		<td width="8%">
			<a href="${pageContext.request.contextPath}/forms/hrReportsForm" ><span class="menuLabel"></span></a>
		</td>
		
	</tr>



</table>
</body>

</html>