<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.productmangeclone.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
<table>
    <thead>
        <th>PRODUCT ID</th>
        <th>PRODUCT NAME</th>
        <th>PRODUCT PRICE</th>
        <th>PRODUCT MADE IN</th>
        <th>PRODUCT COMPANY</th>
        <th>PRODUCT MANUFACTURE DATE</th>
        <th>PRODUCT EXPIRY DATE</th>
        <th>PRODUCT IMAGE</th>
        <th>ACTIONS</th>
        
    </thead>
    <tbody>
        <c:forEach items="<%= ProductDAO.allproducts()%>" var="inf">
            <tr>
                <td>${inf.productid}</td>
                <td>${inf.productName}</td>
                <td>${inf.productPrice}</td>
                <td>${inf.productmadein}</td>
                <td>${inf.productCompany}</td>
                <td>${inf.productmanufacturedate}</td>
                <td>${inf.productexpiredate}</td>
                <td><img src="data:image/jpeg;base64,${inf.base64ProductImage}" alt="Product Image" ></td>   			
   				<td>
                <div style="display: inline-flex;">
   				<form action="./Deleteproductservlet" >   
   				<input type="hidden" name="productid" value="${inf.productid}">
   				<button id="bot1" onclick="submit">DELETE</button>   				
   				</form>
   			    <a id="a1" onclick="window.location.href='EditProduct.jsp'"  href="./Editproductservlet?productid=${inf.productid }">EDIT</a>                
                </div>
                </td>
           </tr>
        </c:forEach>       
    </tbody>
</table>

</main>
</body>
</html>