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
			<li><a href="home.jsp">Home</a></li>
			<li><a href="product.jsp">Product</a></li>
			<li><a href="stock.jsp">Stock</a></li>
			<li><a href="package.jsp">Packages</a></li>
			<li class="current_page_item"><a href=#>Retailer</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	
	<div id="sidebar">
			<ul>
				<li>
					<div id="search" >
					<form method="get" action="#">
						<center><h3>Retailer Menu</h3></center>
					</form>
					</div>
					<div style="clear: both;">&nbsp;</div>
				</li>
				
					
					
                  			   <li><center><a href="add_retailer.jsp">Add Retailer</a></center> </li>
                  		 	                  			                   			
               			   				
				</ul>
		</div>
			<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
			<div class="entry">
				<H3>ADDING RETAILER</H3>
					<form method="post"  name="input"  action="AddRetailerController" onsubmit="return page_validate_add_retailer()"><BR><BR>

<table border="0" style="font-size:15px">
   <TR>
      <TH COLSPAN="8"><H3><br/>Enter the details</H3><br/></TH>
   </TR>
	<!--<tr><td>Retailer Id </td><td><input  type="text" name="id"></td></tr>-->
	<tr><td>Retailer Name </td><td><input  type="text" id="name" name="name"></td></tr>
	<tr><td>Location</td><td><input  type="text" id="loc" name="loc"></td></tr>
	<tr><td>License no.</td><td><input  type="text" id="licNo" name="licNo"></td></tr>
		

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

	