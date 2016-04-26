<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="java.util.ArrayList"%>

<%@page import="model.pojo.ProductModel"%>
<%@page import="model.dao.ProductModelDAO"%>
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Telecom Store Inventory</title>
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
			<li><a href="product.jsp">Product</a></li>
			<li class="current_page_item"><a href="stock.jsp">Stock</a></li>
			<li><a href="package.jsp">Packages</a></li>
			<li><a href="retailer.jsp">Retailer</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="sidebar">
			<ul>
				<li>
				
				<div id="search" >	
				<form method="get" action="#">
				<h3> <center>Stock Menu</center></h3>
				</form>	
				</div>
				<div style="clear: both;">&nbsp;</div>
			</li>

			<ul><center>
				<li ><a href="addStock.jsp">Add Stock</a></li>
				<li><a href="updateStock.jsp">Update Stock</a></li>
				<li><a href="thresoldQuantity.jsp">View Stock</a></li>
			</center></ul>
				</li>
				</div>
		
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
								
				<div class="entry">
				<H3>ADDING STOCK</H3>
			
			
			<%
			ArrayList<ProductModel> psList=ProductModelDAO.viewAllProductModel();
			%>		
				<form  name="input"  action="AddStocKController" method="post"   ><BR><BR>
  <table border="0" style="font-size:15px">
   <TR>
      <TH COLSPAN="8"><H3><br/>Enter the details</H3><br/></TH>
   </TR>
						
						<tr><td><b>Product Model ID</b></td><td><select name="PMID">
						
				<% for(ProductModel pm:psList)
					{
				%>
						<option value="<%=pm.getId() %>"><%=pm.getId() %></option>
				<%
					}
				%>		
						
						</select></td></tr>
						</select></td></tr>
						<tr><td><b>Product Name</b></td><td><input type="text" name="PName"></td></tr>
						<tr><td><b>Quantity</b></td><td><input type="text" name="Quantity"></td></tr>
						<tr><td><b>Product Status</b></td><td><input type="radio" id="PStatus" name="PStatus" value="Available"  checked>Available</td></tr>
						<tr><td><input type="submit" value="Submit"><input type="reset" value="Reset"></td></tr>
					</table>	
					</form> 
		
			
				</div>
			</div>
			
	</div>	
		<div style="clear: both;">&nbsp;</div>
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
