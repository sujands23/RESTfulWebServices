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
			<li s><a href="product.jsp">Product</a></li>
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
					<div id="search">
					<form method="get" action="#">
				  <h3><center>Stock Menu</center></h3>
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
			</ul>	
			
			<div>
						
							
			</font>
			</div>
				</div>
	
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
					<div class="entry">
				<H3>VIEW PRODUCT THRESHOLD</H3>
			<%
			if(request.getParameter("submit")==null){
				ArrayList<ProductModel> pmList=ProductModelDAO.viewAllProductModel();
				System.out.print(pmList.size());
				%>	
			
				
				<form  name="input"  action="ViewthresoldController" method="post" ><BR><BR>
  <table border="0" style="font-size:15px">
   <TR>
      <TH COLSPAN="8"><H3><br/>Enter the details</H3><br/></TH>
   </TR>
			<tr><td><b>Product Model ID</b></td><td><select name="PMID">
						
				<% for(ProductModel pm:pmList)
					{
				%>
						<option value="<%=pm.getId() %>"><%=pm.getId() %></option>
				<%
					}
				%>		
						
						</select></td></tr>
						
						<tr><td><input type="submit" name="submit" value="View"><input type="reset" value="Reset"></td></tr>
					</table>
					</form>
					
				<% 		
					}
						else if(request.getAttribute("product")!=null){
				%>
					<table>
					<form  name="input"  action="ThresholdController" method="post" onsubmit ="return validate()"  >
					<input type="hidden" name="PMID" value="<%= request.getAttribute("PMID") %>"></input> 
					<tr><td><b>Product Model ID</b></td><td><%=request.getAttribute("PMID")%></td></tr>
					<tr><td><b>Existing Quantity</b></td><td><%=request.getAttribute("product")%></td></tr>                         
					<br>
					<br>
					</br>
					</br>
					
					<tr><td><input type="submit" name="submit" value="THRESOHLD"><input type="reset" value="Reset"></td></tr>
					</table>
					</form> 
					<% }
						else{
							String suggestion=(String)request.getAttribute("suggestion");
							String color=(String)request.getAttribute("color");
							String message=(String)request.getAttribute("msg");
							%>
							<table>
                                 
								  <tr>
                                   <td>  <label>Less Than Threshold:</label></td>
                                    <td><input id="modelId" name="modelId" type="text" disabled="true" style="background-color:orangered;color:black;text-align:center "/></td></td>
                                    </tr>
                                    <tr>
                                   <td>  <label>Equals To Threshold:</label></td>
                                    <td><input id="modelId" name="modelId" type="text" disabled="true" style="background-color:gold;color:black;text-align:center "/></td></td>
                                    </tr>
                                    <tr>
                                   <td>  <label>Sufficient Product Quantity:</label></td>
                                    <td><input id="modelId" name="modelId" type="text" disabled="true" style="background-color:MediumSeaGreen;color:black;text-align:center "/></td></td>
                                    </tr>
                                </table>
							<h1><font color=<%=color%>>
							
							<%
							out.print(""+suggestion+"");
							
						}
				
						
					%>	</h1>			
					</font>
					
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