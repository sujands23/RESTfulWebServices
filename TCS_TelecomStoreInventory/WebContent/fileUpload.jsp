<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD><TITLE>Display file upload form to the user</TITLE>
<link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
</HEAD>
<BODY>
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
<FORM ENCTYPE="multipart/form-data" ACTION="ReadFromCsvController" METHOD=POST>
<br><br><br>
<center><table border="2" >
<tr><center><td colspan="2"><p align=
"center"><B>UPLOAD THE FILE</B><center></td></tr>
<tr><td><b>Choose the file To Upload:</b>
</td>
<td><INPUT NAME="file" TYPE="file"></td></tr>
<tr><td colspan="2">
<p align="right"><INPUT TYPE="submit" VALUE="Send File" ></p></td></tr>
<table>
</center>
<% if(request.getAttribute("msg")!=null){%>
<%=request.getAttribute("msg")%>
<a href="DownloadController">DownLoad Here</a>
<% }%> 
</FORM>
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

</BODY>
</HTML>