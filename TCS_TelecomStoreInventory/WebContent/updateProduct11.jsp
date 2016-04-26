<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="model.pojo.ProductModel"%>
<%@page import="model.dao.ProductModelDAO"%><html>

 
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="TSI.js"></script>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<title>Telecom Store Inventory</title>
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
                  <li><a href="#">Update Product</a></li>
            	   <li><a href="viewProduct.jsp">View Product</a></li>
                  	<li><a href="viewQuantity.jsp">View Quantity</a></li>
                   	<li><a href="tagProduct.jsp">Tag Product</a></li>
               
                </ul> </center>
			</ul>
</div>	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
								
				<div class="entry">
				<H3>TO UPDATE PRODUCT</H3><BR/><BR/>
				<%ProductModel pList=(ProductModel)request.getAttribute("temp2"); 
				
			%>
				
					<form name="input" action="UpdateProductController" method="post" onsubmit="return page_validate_add_product()"><BR/><BR/>

<TABLE  BORDER="0" style="font-size:15px">
   <TR>
      <TH COLSPAN="6"><H3>Choose Product to Update</H3><BR>
      </TH> </TR>
  
    <tr><td>Product Model ID</td><td><input  id="PMid" type="text"   name="id" value=<%=pList.getId() %> >
					</td></tr>
  	<tr><td>Product Model Name</td><td><input id="PMName" type="text"  name="name" value=<%=pList.getName() %>></td></tr>
	<tr><td>Product Model Description</td><td><input id="PMDesc" type="textarea"  name="description" rows="5" cols="20" value=<%=pList.getDescription() %>></td></tr>
	<tr><td>Product Model Features</td><td><input id="PMFeat" type="textarea"  name="features" rows="5" cols="20" value=<%=pList.getFeatures() %>></td></tr>
	<tr><td>Price(Rs.)</td><td><input  type="text" id="Price" name="price" value=<%=pList.getPrice() %>></td></tr>
	<tr><td>Product Model Threshold </td><td><input id="PMTh" type="text"  name="threshold" value=<%=pList.getThreshold() %>></td></tr> 
     <tr><td><input type="submit" value="Submit"><input type="reset"  value="Reset"></td></tr>
</table>
	<p class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Comments</a></p>
				</div>
			</div>
			
		
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
	<div id="sidebar">
	
</div>
	<!-- end #page -->
</div>
	<div id="footer">
		
	</div>
	<!-- end #footer -->
</body>
</html>