<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>


<%@page import="model.dao.ProductModelDAO"%>
<%@page import="model.pojo.ProductModel"%><html>
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
                    	</ul></center>		
               			   
				</ul></div>	<!-- end #menu -->
								<H3>VIEW PRODUCT DETAILS</H3>
			<%
			ArrayList<ProductModel> pmList=ProductModelDAO.viewAllProductModel();
			%>
			
			<%ProductModel pList=(ProductModel)request.getAttribute("PList"); 
				
			%>	
			
				
				<form  name="input"  action="ViewProductModelController" method="post" onsubmit ="return validate()"  ><BR><BR>
  <table border="0" style="font-size:15px">
   <TR>
      <TH COLSPAN="8"><H3><br/>Enter the details</H3><br/></TH>
   </TR>
			
			<tr><td>Product Model ID</td><td><select name="PMID">
						
				<% for(ProductModel pm:pmList)
						{
						%>
						<option value="<%=pm.getId() %>"><%=pm.getId() %></option>
						
						<% } %>
						</select></td></tr>
						
						<tr><td><input type="submit" name="submit" value="View"><input type="reset" value="Reset"></td></tr>
					</table>
					<% if(request.getAttribute("PList")!=null)
						{%>
					<table>
					<tr><td>Product Name</td><td><select name"">
					<option value="<%=pList.getName() %>"><%=pList.getName() %></option></td></tr>
					<tr><td>Product Description</td><td><select name"">
					<option value="<%=pList.getDescription() %>"><%=pList.getDescription() %></option></td></tr>
					<tr><td>Product Features</td><td><select name"">
					<option value="<%=pList.getFeatures() %>"><%=pList.getFeatures() %></option></td>
					<tr><td>Product pirce</td><td><select name"">
					<option value="<%=pList.getPrice() %>"><%=pList.getPrice() %></option></td>
					<tr><td>Product Threshold</td><td><select name"">
					<option value="<%=pList.getThreshold() %>"><%=pList.getThreshold() %></option></td>
					<%} %>
					</table>
					</form> 
					
		<p class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Comments</a></p>
			
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