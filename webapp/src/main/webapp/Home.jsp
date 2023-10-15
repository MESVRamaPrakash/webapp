<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="css.jsp" %>

</head>

<style>
body {
	background-image:linear-gradient(to right,rgb(34,5,111),rgb(109,145,33));
}

a{

margin-left: 1rem;

}

.banner-body {
     
    font-size: 3rem;
    margin-left:12rem;
    margin-bottom:3rem;
    font-family: 'Poppins', sans-serif;
    font-weight: 800;
    color: #000;
    text-shadow:  3px 3px 9px black;
    margin:100px 0 50px 400px;

}


</style>
<body>

<%@include file="Navbar1.jsp" %>



<div class="banner-body">

<h1 style="margin-left:250px;color:#fff;margin-bottom:50px;">Welcome Admin</h1>

<a href="AddStudents.jsp"><button class="btn btn-outline-light btn-md">Add Student</button></a>
<a href="Marks.jsp"><button class="btn btn-outline-light btn-md">Add Students Marks</button></a>
<a href="AllStudents.jsp"><button class="btn btn-outline-light btn-md">Student Details</button></a>
<a href="AllMarks.jsp"><button class="btn btn-outline-light btn-md">Students Marks</button></a>
<a href="Admin.jsp"><button class="btn btn-outline-light btn-md">Logout</button></a>

</div>

</body>
</html>