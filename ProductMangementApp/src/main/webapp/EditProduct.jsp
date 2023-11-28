<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page  import="com.productmangeclone.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductMangementApp</title>
<link rel="icon"  href="favicon-32x32.png"/>
<link rel="stylesheet" href="ProductManagement.css"/>
<script src="ProductMangeValidatitons.js" ></script>
</head>
<body>
	<header id="head">
	<div>
	   <div id="con1" >
		<button  class="nav" onclick="window.location.href='Home.html'">EXIT</button><br><br>
	   </div>
	</div>
	</header>
	<main>
		<div id="con2" >
		   <img id="pic" src="favicon-32x32.png"/>
		   <p style="margin-left: 2px; font-weight: bolder; font-size: larger; " >roductMangement</p>
	</div>
		
	<div id="con4"  >
		<form method="post" action="./Updateproductservlet"   id="form1"  onsubmit="return productvalidation()" enctype="multipart/form-data" >
			<div class="group" >
				<label class="label1" >Product Id :</label>
				<input class="in" type="text" name="productid" placeholder="Product Id" id="pid" value="${existingproduct.productid}" />
			</div>
			 <div class="group">
				<label class="label1">Product Name :</label>
				<input class="in" type="text" name="productname" placeholder="Product Name" id="pname"  value="${existingproduct.productName}"  />
			</div>
             <div class="group">
				<label class="label1">Price :</label>
				<input class="in" type="number" name="price" placeholder="Price" id="price" value="${existingproduct.productPrice}"/>
			</div>
			 <div class="group">
				<label class="label1">Made In :</label>
				<input class="in" type="text" name="madein" placeholder="Made In" id="made" value="${existingproduct.productmadein}" />
			</div>
			 <div  class="group">
				<label class="label1">Brand :</label>
				<input class="in" type="text" name="brand" placeholder="Brand" id="brand"  value="${existingproduct.productCompany}" />
			</div>			
			 <div  class="group">
				<label class="label1">Manufacturing Date :</label>
				<input class="in"  type="date" name="manfacturedate" id="mandate" value="${existingproduct.productmanufacturedate}"   />
			</div>
			 <div  class="group">
				<label class="label1">Expiry Date :</label>
				<input class="in" type="date" name="expirydate" id="expdate" value="${existingproduct.productexpiredate}"  />
			</div>
			 <div  class="group">
				<label class="label1">Product Image:</label>
				<input type="file" name="productimage" id="pimage" value="${existingproduct.productimage}" />
			</div>
			<button id="bot" type="submit">AddProduct</button>												
		</form>
	</div>
	
	</main>
</body>
</html>