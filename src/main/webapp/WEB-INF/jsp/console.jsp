<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/styles/home.styles.css" type="text/css" rel="stylesheet"/>
<script src="/js/jquery.min.js"></script>
<title>Stiff Security - Employee Portal</title>
</head>
<body style="align:center">
	<div id="headerDiv" class="headerDiv">
		<%@include file="consoleheader.jsp" %>
	</div>
	<div  class="">

      <!-- Unnamed (Vertical Line) -->
      <div id="u16" class="ax_default line">
        <img id="u16_img" class="img " src="/images/u16.png"/>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u17" class="ax_default box_1">
        <div id="u17_div" class=""></div>
        <div id="u17_text" class="text ">
          <%@include file="calendarview.jsp" %>
        </div>
      </div>

      <!-- Unnamed (Rectangle) -->
      <div id="u18" class="ax_default box_1">
        
        <div id="u18_text" class="text ">
        
          <iframe style="background-color:#f2f2f2;"
          src="http://free.timeanddate.com/clock/i5x9uhzp/n771/szw160/szh160/hocaaa/cf100/hnce1ead6" 
          frameborder="0" width="220" height="200">
          </iframe>

        </div>
      </div>

      <!-- Unnamed (Vertical Line) -->
      <div id="u19" class="ax_default line">
        <img id="u19_img" class="img " src="/images/u19.png"/>
      </div>

      <!-- dataContainer (Dynamic Panel) -->
      
    </div>
    
   
</body>
</html>