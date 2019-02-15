<%@page import="br.com.alpha.tasks.domain.Test"%>
<%@page import="br.com.alpha.tasks.domain.User"%>
<%@page import="br.com.alpha.tasks.controller.UserController"%>
<%@page import="br.com.alpha.tasks.controller.LoginController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/nav.css">
<script src="Dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="Dist/sweetalert.css">
<title>Student!</title>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #f0f0f0">
	<!-- Button open side bar --> <img src="img/hamburger.png"
		onclick="openNav();" style="visibility: hidden;">
	<div class="justify-content-end">
		<form class="form-inline" action="/Tasks/deslog" method="POST">
			<button type="submit" class="btn btn-outline-danger">Logout</button>
		</form>
	</div>
	</nav>
	<br>
	<div class="container">
		<div class="container">
			<h1 class="display-3">
				<center>Welcome, Student!</center>
			</h1>
		</div>
		<br> <br>

		<%
			int id = Integer.parseInt(request.getSession().getAttribute("studentsIds").toString());

				for(Test t : new LoginController().testStudent(id)){
					if(new LoginController().pesquisaProva(t.getId(), id)){
					out.println("<div class='row d-flex justify-content-center'>");
			out.println("<div class='card' style='width: 18rem;'>"+
					"<div class='card-body'>"+
			"<h5 class='card-title'><center>Class of "+t.getClas().getName()+"!</center></h5>"+
			"	<p class='card-text'><center>You have a test to do, and the subject of the test is "+t.getMatter().getName()+"!</center></p>"+
				"<center><a href='student-test?Test="+t.getId()+"&sid="+id+"' class='btn btn-primary'>Take the test now!</a></center>"+
				"</div>"+
				"</div>");
			out.println("</div>");
			out.println("<br/><br/>");
					}
				}
		%>

		<br> <br>

	</div>
</body>
</html>