<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="model.pojo.RewardPackage"%>
<%@page import="model.dao.PackageDAO"%><html>

<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Telecom Store Inventory</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<script>

function rr_val()
{
	var CP_ID=document.getElementById("CP_ID").value;
	var off=document.getElementById("off").value;
	var Desc=document.getElementById("Desc").value;
	if(CP_ID=="" ||CP_ID=="Enter the value")
	{
  		alert("Package ID cannot be empty");
  	}
	else if(off==""||off=="Enter the value" )
	{
  		alert("offer cannot be empty");
  	}
	
	else if(Desc=="" || Desc=="Enter the value")
	{
  		alert("Order Value cannot be empty");
  	}

}
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
			<li ><a href="homeRetailer.jsp">Home</a></li>
			<li ><a href="viewProductRetailer.jsp">Product</a></li>
			
			<li class="current_page_item"><a href="viewPackageRetailer.jsp">Packages</a></li>
			
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
						
						<li><a href="viewPackageRetailer.jsp">View Package</a></li>
						
					</ul></center>
			</ul>
				</div>
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
				<div class="entry">
				<H3>VIEW PACKAGE</H3>
			
			<%
			ArrayList<RewardPackage> pmList=PackageDAO.searchAllPackage();
			%>
			
			<%RewardPackage pList=(RewardPackage)request.getAttribute("PList"); 
				
			%>	
			
				
				<form  name="input"  action="ViewPackageController1" method="post" onsubmit ="return validate()"  ><BR><BR>
  <table border="0" style="font-size:15px">
   <TR>
      <TH COLSPAN="8"><H3><br/>Enter the details</H3><br/></TH>
   </TR>
			
			<tr><td>Order_value</td><td><select name="PMID">
						
				<% for(RewardPackage pm:pmList)
						{
						%>
						<option value="<%=pm.getOrder_value() %>"><%=pm.getOrder_value() %></option>
						
						<% } %>
						</select></td></tr>
						
						<tr><td><input type="submit" name="submit" value="View"></td></tr>
					</table>
					<% if(request.getAttribute("PList")!=null)
						{%>
					<table>
					<tr><td>PackageId</td><td><select name"">
					<option value="<%=pList.getId() %>"><%=pList.getId() %></option></td></tr>
					<tr><td>Offers</td><td><select name"">
					<option value="<%=pList.getOffers() %>"><%=pList.getOffers() %></option></td></tr>
					<%} %>
					</table>
					</form> 
					
		<p class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Comments</a></p>
			
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