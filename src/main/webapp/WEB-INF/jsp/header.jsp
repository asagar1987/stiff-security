<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="/styles/menu.style.css">
	<script src="/js/menu.js"></script>

</head>
<body>
	<table width="100%" border="0">
		<tr>
			<td width="20%">
			<img src="images/stiff.png" width="80%"/>
			</td>
			<td width="80%" bgcolor="#444444" valign="bottom">
				<table width="100%" bgcolor="#ffffff">
					<tr>
						<c:forEach items="${sessionScope.displayMenu}" var="menu">
							<td width="10%"><button class="dropbtn" onClick="showDropMenu()">${menu.menuName}</button>
							<div id="myDropdown" class="dropdown-content">
								<c:forEach items="${menu.menuItems}" var="menui">
									<a href="${menui.url}">${menui.displayText}</a>
								</c:forEach>
							</div>
							</td>
						</c:forEach>
					</tr>
				</table>
			</td>
			
		</tr>
	</table>
</body>
</html>