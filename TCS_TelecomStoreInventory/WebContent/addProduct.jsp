<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Telecom Store Inventory</title>
<script src="TSI.js"></script>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Telecom Store Inventory  </a></h1>
			<p> Great Inventory store</p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li ><a href="home.jsp">Home</a></li>
			<li class="current_page_item"><a href="product.jsp">Product</a></li>
			<li ><a href="stock.jsp">Stock</a></li>
			<li><a href="package.jsp">Packages</a></li>
			<li><a href="retailer.jsp">Retailer</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	
	<div id="sidebar">
			<ul>
				<li><center>
					<div id="search" >
					<form method="get" action="#">
				<h3>Product Menu</h3>
					</form>
					</div>
					<div style="clear: both;">&nbsp;</div>
				</center></li>
				
			
			          <center><ul>
                  			   <li><a href="addProduct.jsp">Add Product</a></li>
                  		 	   <li><a href="deleteProduct.jsp">Delete Product</a></li>
                  			   <li><a href="updateProduct.jsp">Update Product</a></li>
                  			   <li><a href="viewProduct.jsp">View Product</a></li>
                  			   <li><a href="viewQuantity.jsp">View Quantity</a></li>
                   			   <li><a href="tagProduct.jsp">Tag Product</a></li>
                   			   <li><a href="fileUpload.jsp">Bulk Upload</a></li>
                    	</ul></center>		
               			   
				</ul></div>        
</div>	<!-- end #menu -->
				
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
	<div id="content">
	<div class="post">
	<div class="entry">
			<H3>ADDING PRODUCT</H3>
				<form method="post" name="input" action="AddProductController"  onsubmit="return page_validate_add_product()"/><BR><BR>

                   <table border="0" style="font-size:15px">
                   		<tr><th COLSPAN="8"><h3><br/>Enter the details</h3><br/></th></tr>
	                     
	                    <!--<tr><td>Product Model-ID </td><td><input id="PMID" type="text" name="PMID"></td></tr>-->
	 					<tr><td>Product Model Name</td><td><input id="PMName" type="text" name="PMName"></td></tr>
						<tr><td>Product Model Description</td><td><input id="PMDesc" type="text" name="PMDesc" rows="5" cols="20"></td></tr>
						<tr><td>Product Model Features</td><td><input id="PMFeat" type="text"  name="PMFeat" rows="5" cols="20"></td></tr>
						<tr><td>Price(Rs.)</td><td><input  type="text" id="Price" name="PMPrice"></td></tr>
						<tr><td>Product Model Threshold </td><td><input id="PMTh" type="text"  name="PMTh"></td></tr>
						<tr><td><div align="left"><input type="submit" value="Submit" >
						<input type="reset" value="Reset"></div></td></tr>
                 </table>
                 
				</form>	

	
				
				</div>
			</div>
			
		
	
	</div>
	</div>
	</div>
			
	
</div>
	<!-- end #page -->
</div>
	<div id="footer">
		
</div>
	<!-- end #footer -->
</body>
</html>
