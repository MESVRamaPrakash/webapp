<%@page import="model.studentmodel"%>
<%@page import="dbconnection.studentdb"%>
<%@page import="dao.studentdao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
<%@include file="css.jsp" %>
<style type="text/css">
	th,td{
		color:#fff;
	}
</style>
</head>
<body style="background-image:linear-gradient(to right,rgb(34,5,111),rgb(109,145,33)); background-repeat: no-repeat; height: 100vh;">
<%@include file="Navbar1.jsp" %>

<div class="container p-5">

<a href="Home.jsp"><button class="btn btn-outline-warning btn-md">Back</button></a>

<p class="text-center text-light" style="font-family: sans-serif; font-size: 2.5rem">Students Details</p>

<table class="table table-hover" style="font-weight: 400;" >

<thead>

<tr>

<th>RollNumber</th>
<th>StudentName</th>
<th>Section</th>
<th>Class</th>
<th>Email</th>
<th>Password</th>
<th>FatherName</th>
<th>MotherName</th>
<th>Action</th>
</tr>

</thead>

<tbody>

<%

studentdao dao = new studentdao(studentdb.getConn());

List<studentmodel> list = dao.getAllStudents();

for(studentmodel s : list)

{

%>

<tr>

<td><%=s.getRollnumber()%></td>
<td><%=s.getStudentname()%></td>
<td><%=s.getSection()%></td>
<td><%=s.getClas()%></td>
<td><%=s.getEmail()%></td>
<td><%=s.getPassword()%></td>
<td><%=s.getFathername()%></td>
<td><%=s.getMothername()%></td>

<td>

<a href="update.jsp?Rollnumber=<%=s.getRollnumber()%>"> <button class="btn btn-outline-light btn-sm">Update</button></a>

<a href="delete?Rollnumber=<%=s.getRollnumber()%>"><button class="btn btn-outline-light btn-sm">delete</button></a>
</td>
</tr>

<%
}
%>

</tbody>

</table>
</div>

</body>
</html>