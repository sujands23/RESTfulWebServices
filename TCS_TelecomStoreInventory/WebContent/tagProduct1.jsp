<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@page import="java.util.ArrayList"%>
<%@page import="model.pojo.ProductModel"%>
<%@page import="model.dao.ProductModelDAO"%>
<%@page import="model.dao.RetailerDAO" %>
<%@page import="model.pojo.RetailerInfo" %>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

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
			<li class="current_page_item"><a href="#">Product</a></li>
			<li><a href="stock.jsp">Stock</a></li>
			<li><a href="package.jsp">Packages</a></li>
			<li><a href="retailer.jsp">Retailer</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
 
<div id="sidebar">
	<ul>
				<li>
					<div id="search" >
					<form method="get" action="#">
					 <h3><center>Product Menu</center></h3>
                     
					</form>
					</div>
					<div style="clear: both;">&nbsp;</div>
				</li>
				
                 <center><ul>
                   <li><a href="addProduct.jsp">Add Product</a></li>
                    <li><a href="deleteProduct.jsp">Delete Product</a></li>
                    <li><a href="updateProduct.jsp">Update Product</a></li>
                    <li><a href="viewProduct.jsp">View Product</a></li>
                  	 <li><a href="viewQuantity.jsp">View Quantity</a></li>
                    <li><a href="#">Tag Product</a></li>
                
                 </ul></center>
</div>	<!-- end #menu -->
				
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
			<div class="entry">
				<H3>TAGGING PRODUCT</H3>
				<%
			ArrayList<ProductModel> pmList=ProductModelDAO.viewAllProductModel();
			
			%>
			<%
			ArrayList<RetailerInfo> rtInfo=RetailerDAO.searchAllRetailerId();
			%>
			
					<form name="input"  action="TagRetailerController1" method="post" onsubmit ="return validate()" ><BR><BR>

<table border="0" style="font-size:15px">
   <TR>
      <TH COLSPAN="8"><H3><br/>Enter the details</H3><br/></TH>
   </TR>
	<tr><td>Retailer Id </td><td><select name="RID">
	<% for(RetailerInfo rI: rtInfo)
						{
						%>
						<option value="<%=rI.getRETAILER_ID() %>"><%=rI.getRETAILER_ID() %></option>
						
						<% } %>
	</select></td></tr>
	
	
	<tr><td><div align="left"><input type="submit" value="Submit" onsubmit ="return validate()">
			<input type="reset" value="Reset"></td></tr>



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
