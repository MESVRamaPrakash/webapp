<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<%@include file="css.jsp" %>

<style>
* {
	padding:0;
	margin:0;
	box-sizing-border-box;
}

body {
	background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url('Images/welcomebg.jpg');
	background-size:cover;
	background-position:center;
	background-repeat:no-repeat;
	height:100vh;
	width:100vw;
}
.banner-title {
	display:flex;
	justify-content:center;
	align-items:center;
}

.banner-body {
	display:flex;
	justify-content:center;
	align-items:center;
}

h1{

 	font-size: 5rem;
    font-family: 'Poppins', sans-serif;
    font-weight: 800;
    color: #fff;
    text-shadow: 3px 3px 9px black;
    margin-top:230px;
}

P{
	margin-right:30px;
	margin-top:20px;
    font-size: 1rem;
    font-family: 'Poppins', sans-serif;
    font-weight: 700;
    color: white;
    text-shadow: 3px 3px 9px black;

}
button {
	
	 font-size: 1rem;
}

a{
	color:black;
}

</style>
</head>
<body>
<%@include file="Navbar.jsp"%>

<div class="banner">
<div class ="banner-title">
<h1>Welcome All</h1>
</div>
<div class="banner-body">
<p>Login through Admin Portal</p>
<a href="Admin.jsp"><button class="btn btn-danger btn-lg">Admin</button></a>
</div>
</div>
</body>
</html>