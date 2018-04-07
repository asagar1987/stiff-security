<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="/styles/console.header.style.css">
<link rel="stylesheet" type="text/css" href="/styles/menu.org.css">
<link rel="stylesheet" type="text/css" href="/styles/ax.style.css">
<link rel="stylesheet" type="text/css" href="/styles/axure.style.css">
<link rel="stylesheet" type="text/css" href="/styles/dataTables.jqueryui.min.css">
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/menu.js"></script>

</head>
<body>

<div id="base" class="">

      <!-- Unnamed (Rectangle) -->
      <div id="u21" class="ax_default box_1">
        <img id="u21_img" class="img " src="/images/u1.png"/>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u22" class="ax_default image">
        <img id="u22_img" class="img " src="/images/u0.png"/>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u23" class="ax_default box_2">
        <div id="u23_div" class=""></div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u24" class="ax_default heading_1">
        <div id="u24_div" class=""></div>
        <div id="u24_text" class="text ">
          <p><span>Stiff Security</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u25" class="ax_default box_2">
        <div id="u25_div" class=""></div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u26" class="ax_default heading_1">
        <div id="u26_div" class=""></div>
        <div id="u26_text" class="text ">
          <p><span>Emplo&nbsp;&nbsp;ee Portal</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u27" class="ax_default box_2">
        <div id="u27_div" class=""></div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u28" class="ax_default label">
        <div id="u28_div" class=""></div>
        <div id="u28_text" class="text ">
          <p><span>Welcome, Administrator</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u29" class="ax_default primary_button">
        <div id="u29_div" class=""></div>
        <div id="u29_text" class="text ">
          <p><span>Log Out</span></p>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u30" class="ax_default link_button">
        <div id="u30_div" class=""></div>
        <div id="u30_text" class="text ">
          <p><span>View My Profile</span></p>
        </div>
      </div>



	  	
      <!-- Unnamed (Menu) -->
      <div id="u31" class="ax_default">
        <img id="u31_menu" class="img " src="/images/u11_menu.png" alt="u31_menu"/>

        <!-- Unnamed (Table) -->
        				
        				
       					<c:forEach items="${sessionScope.displayMenu}" var="menu">
							<div class="dropdown">
								<button class="dropbtn" onClick="showDropMenu(this.id)" id="${menu.menuName}">${menu.menuName}</button>
								<div id="myDropdown-${menu.menuName}" class="dropdown-content">
									<c:forEach items="${menu.menuItems}" var="menui">
										<a href="#" onClick="${menui.itemName}()">${menui.displayText}</a>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
        
        				
        
      </div>
    <div id="containerDiv" class="dataContainerPanel">
	   
    </div>
    <div id="detailDataDiv">
    	
    </div>
    </div>

	
</body>
</html>