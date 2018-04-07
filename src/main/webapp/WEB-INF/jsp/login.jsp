
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Stiff Security - Daily Status Report</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Daily Status Reporting">
	
	<link rel="stylesheet" type="text/css" href="styles/style.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	
  </head>
  
  <body>
  <table width="90%" align="center">
  
  <tr height="550"> 
  <td width="55%">
  <img src="images/stiff.png" width="80%"/>
  </td>
  <td width="10%">
  <div style="border-left:medium #CC0000 solid; height:550px;" />
  </td>
  <td width="35%">
  <div id="loginFormDiv">
  <form name="loginform" id="loginform" action="login" method="post">
	<table width="90%" border="1" style="background-color:rgb(214,220,229)">
		<tr height="20px"><td colspan="3" align="center">
		<span style="font-size:36px; color:#0032ff">STIFF SECURITY</span>
		</td>
		</tr>
		<tr height="20px">
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Username</td>
			<td>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="username" placeholder="Enter your username" id="username"></td>
		</tr>
		<tr height="20px">
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Password</td>
			<td>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><input type="password" name="password" placeholder="Enter your password" id="password"></td>
		</tr>
		<tr height="10">
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#">
			<span style="font-size:10px">Forgot your password?</span>
			</a></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><button type="submit" name="login">Login</button></td>
		</tr>
		<tr height="20px">
		</tr>
	</table>
	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	</div>
  </td>
  </tr>
  </table>
  </body>
</html>
