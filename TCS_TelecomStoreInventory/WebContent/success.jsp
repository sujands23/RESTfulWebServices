<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<h1><a href="#">Telecom Store Inventory </a></h1>
<p>Great Inventory store</p>
</div>
</div>
<!-- end #header -->
<div id="menu">
<ul>

	<li><a href="#">Home</a></li>
	<li><a href="product.jsp">Product</a></li>
	<li><a href="stock.jsp">Stock</a></li>
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
				<h3>QUICK LINK</h3>
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
                   			   <li ><a href="addStock.jsp">Add Stock</a></li>
							   <li><a href="updateStock.jsp">Update Stock</a></li>
							   <li><a href="thresoldQuantity.jsp">View Stock</a></li>
							   <li><a href="add_package.jsp">Add Package</a></li>
							   <li><a href="delete_package.jsp">Delete Package</a></li>
							   <li><a href="update_package.jsp">Update Package</a></li>
							   <li><a href="viewPackage.jsp">View Package</a></li>
							   <li><a href="issuePackage.jsp">Issue Package</a></li>
							   <li><a href="add_retailer.jsp">Add Retailer</a></li>
                    	</ul></center>		
               			   
				</ul></div>        
</div>	<!-- end #menu -->
<div id="page">
<div id="page-bgtop">
<div id="page-bgbtm">
<div id="content">
<div class="post">
<h3 class="title"><a href="#">Welcome to Inventory </a></h3>


<div class="entry" style="font-size:15px">
<%
					String abc=request.getParameter("msg");
					
					%>
<p><b><br />
<br />
<br />
<% out.print(request.getAttribute("msg")); %>
</b></p>
<%String p=(String)request.getAttribute("Type");%> <%if(p.equals("Product Model-ID"))
					{%>
<p><b><br />
<br />
<br /><%=(String)request.getAttribute("Product Model-ID") %></b></p>

<% }
					else if(p.equals("retailerId"))
					{%>
<p><b><br />
<br />
<br />
<%=(String)request.getAttribute("retailerId") %>
</b></p>
<%}
					else if(p.equals("id"))
					{%>
<p><b><br />
<br />
<br />
<%=(String)request.getAttribute("id") %>
</b></p>
<%}%>

<p class="links"><a href="home.jsp">LandBack</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a
	href="#">Comments</a></p>
</div>

</div>


<div style="clear: both;">&nbsp;</div>
</div>
</div>
</div>
<!-- end #page --></div>
</div>
<div id="footer"></div>

<!-- end #footer -->
</body>
</html>
