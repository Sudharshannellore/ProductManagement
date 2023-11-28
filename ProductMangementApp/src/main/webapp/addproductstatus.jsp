<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductMangementApp</title>
<link rel="icon"  href="favicon-32x32.png"/>
<link rel="stylesheet" href="ProductManagement.css"/>
</head>
<body>
<header id="head">
	<div id="con1" >
		<button  class="nav" onclick="window.location.href='Home.html'">EXIT</button><br><br>
	</div>
	<div id="con2" >
		<img id="pic" src="favicon-32x32.png"/>
		<p style="margin-left: 2px; font-weight: bolder; font-size: larger; " >roductMangement</p>
	</div>
</header>
<br>
<br>
<br>	
<main>
	<div>
	      <c:if test="${result == 1 }">
	       <h3><%= request.getParameter("productname") %>..Product Successfully Stored in DataBase..&#128522;</h3>
	      </c:if>
	      <c:if test="${result == 0 }">
	       <h3><%= request.getParameter("productname") %>..Product not Stored in DataBase ...&#128532;</h3>
	      </c:if>
	</div>
</main>
</body>
</html>