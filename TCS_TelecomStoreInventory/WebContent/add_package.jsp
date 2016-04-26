<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
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
<script>
</script>
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
			<li ><a href="product.jsp">Product</a></li>
			<li ><a href="stock.jsp">Stock</a></li>
			<li class="current_page_item"><a href="package.jsp">Packages</a></li>
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
						<center><h3>Package Menu</h3></center>
					</form>
					</div>
					<div style="clear: both;">&nbsp;</div>
				</li>
				
					<center><ul>
						<li><a href="add_package.jsp">Add Package</a></li>
						<li><a href="delete_package.jsp">Delete Package</a></li>
						<li><a href="update_package.jsp">Update Package</a></li>
						<li><a href="viewPackage.jsp">View Package</a></li>
						<li><a href="issuePackage.jsp">Issue Package</a></li>
					</ul></center>
			</ul>
				</div>
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
				<div class="entry">
				
				
				
					<h3>COMPLEMENTORY PACKAGE</h3>
<form method="post" name="input" action="AddPackageController" onSubmit="return page_validate_add_package()"><BR><BR>
<table border="0" style="font-size:15px">
<tr>
<th colspan="8"><h3><br/>Enter the details</h3><br/></th>
</tr>
<!-- <tr><td>Package ID</td><td><input type="text"  id="CP_ID" name="PackgID" style="color:#cccccc"  onblur="if (this.value == '') {this.style.color = '#cccccc'; this.value = 'Enter the value'  }" onfocus="if (this.value == 'Enter the value') {this.value = ''; this.style.color = '#333333' }" size="15"  value="Enter the value"/></td></tr>-->
<tr><td>Offers</td><td><input type="text" name="offrs" id="off" style="color:#cccccc"  onblur="if (this.value == '') {this.style.color = '#cccccc'; this.value = 'Enter the value'  }" onfocus="if (this.value == 'Enter the value') {this.value = ''; this.style.color = '#333333' }" size="15"  value="Enter the value"/></td></tr>
<tr><td>Order Value</td><td><input type="text"  id="Desc" name="Ovalu" style="color:#cccccc"  onblur="if (this.value == '') {this.style.color = '#cccccc'; this.value = 'Enter the value'  }" onfocus="if (this.value == 'Enter the value') {this.value = ''; this.style.color = '#333333' } " size="15"  value="Enter the value"/></td></tr>
<tr><td><input type="submit" value="Submit" ><input type="reset"></td></tr>

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
