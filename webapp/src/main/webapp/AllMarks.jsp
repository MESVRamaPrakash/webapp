<%@page import="model.marksmodel"%>
<%@page import="java.util.List"%>
<%@page import="dbconnection.studentdb"%>
<%@page import="dao.marksdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Marks</title>
<%@include file="css.jsp" %>
<style type="text/css">
	th,td{
		color:#fff;
	}
	td:hover{
		color:white;	
	}
</style>
</head>
<body style="background-image:linear-gradient(to right,rgb(34,5,111),rgb(109,145,33)); background-repeat: no-repeat; height: 100vh;">

<%@include file="Navbar1.jsp" %>

<div class="container p-5">

<a href="Home.jsp"><button class="btn btn-outline-warning btn-md">Back</button></a>

<p class="text-center text-light" style="font-family: sans-serif; font-size: 2.5rem">Marks Details</p>

<table class="table table-hover" style="font-weight: 700;">

<thead>

<tr>

<th>RollNumber</th>
<th>Telugu</th>
<th>Hindi</th>
<th>English</th>
<th>Maths</th>
<th>Science</th>
<th>Social</th>
<th>TotalMarks<th>
<th>Percentage</th>
<th>Action</th>
</tr>

</thead>

<tbody>

<%

marksdao dao = new marksdao(studentdb.getConn());

 List<marksmodel> list = dao.getAllMarks();
 
 for(marksmodel m : list)
 {
%>


<tr>

<td><%=m.getRollnumber()%></td>
<td><%=m.getTelugu() %></td>
<td><%=m.getHindi() %></td>
<td><%=m.getEnglish() %></td>
<td><%=m.getMaths() %></td>
<td><%=m.getScience() %></td>
<td><%=m.getSocial() %></td>
<td><% int sum =m.getTelugu()+m.getHindi()+m.getEnglish()+m.getMaths()+m.getScience()+m.getSocial(); out.println(sum);%><td>
<td><% out.println((sum*100)/600);%></td>
<td>
<a href="UpdateMarks.jsp?Rollnumber=<%=m.getRollnumber()%>"> <button class="btn btn-outline-light btn-sm" style="font-weight: 700;">Update</button></a>

<a href="deletemark?Rollnumber=<%=m.getRollnumber()%>"><button class="btn btn-outline-light btn-sm" style="font-weight: 700;">delete</button></a>

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