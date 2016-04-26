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
			<h1><a href="#">Telecom Store Inventory  </a></h1>
			<p> Great Inventory store</p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			
		</ul>
	</div>
<br/><br/><br/>
<center><b>You are Successfully Logged Out!!!<br/>
Welcome Again..
</b></center><br/>
<% 

HttpSession session1=request.getSession(false);
session1.invalidate();



%>

<p class="links"><a href="login.jsp"><h3></>Login again</h3></a></p>
</div>
			
		
		<div style="clear: both;">&nbsp;</div>
	<!-- end #page -->
	</body>
</html>

