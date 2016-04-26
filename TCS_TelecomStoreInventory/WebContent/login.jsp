<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h1>Telecom Store Inventory </a></h1>
			<p> Great Inventory Store</p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		
	</div>
	<!-- end #menu -->
	<div id="page">
	
	
		<div id="content">
			<div class="post">
				<h2 class="title">Welcome to Inventory</h2>
				
		
					<p>This is <strong>Inventory  </strong>, a fully standards-compliant management system for You.This free template is released under  license, so you’re pretty much free to do whatever you want with it (even use it commercially) provided you keep the links in the footer intact. Aside from that, have fun with it :)</p>
					
			</div>		
		</div>
				<div style="width:1px;height:350px;background-color:#787878;float:left;"></div>
				<div id="sidebar">
			
				
					
					<form name="login" action="LoginAsValidator" onsubmit="return page_validate_login()" method="post">
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					
				<pre>
	Select Actor<span style="color:red">*</span>	<select name="login_actor" id="actor" style ="width: 250px">
<option selected>Select option</option>

<option value="1">Retailer</option>
<option value="2">Inventory Manager</option>

</select>

	Enter id<span style="color:red">*</span>	<input type="text" style="height: 15px; width:250px" id="login_id" name="login_id" />

	Password<span style="color:red">*</span>	<input type="password" style="height: 15px; width:250px" id="login_pass" name="login_pass" />


			<input type="submit" value="Login" style ="width:80px"/> 	<input type="reset" value="cancel" style ="width:80px"/>
		
			
<div>
			<%
			if(request.getParameter("msg")!=null)
				out.println("<font color=red>"+request.getParameter("msg")+"</font>");
			if(request.getParameter("msg1")!=null)
				out.println("<font color=red>"+request.getParameter("msg1")+"</font>");
			%>
</div>
</pre>	
</form>
<br>

<%--
if(request.getAttribute("msg")!=null)
	out.println("inahagsj");
	
--%>
	
	<!-- end #page -->
</div>
	
	<!-- end #footer -->
</body>
</html>