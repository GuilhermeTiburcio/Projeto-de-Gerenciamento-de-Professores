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
<title>Professor</title>

<script type="text/javascript">
	/* Set the width of the side navigation to 250px */
	function openNav() {
		document.getElementById("mySidenav").style.width = "250px";
	}

	/* Set the width of the side navigation to 0 */
	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
	}

	function search() {
		input = document.getElementById("emailsearch");
		filter = input.value.toUpperCase();
		table = document.getElementById("table");
		tr = table.getElementsByTagName("tr");
		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[1];
			if (td) {
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}

	function altern(valor) {
		if(valor != "All"){
			input = document.getElementById("type");
			filter = input.value.toUpperCase();
			table = document.getElementById("table");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[2];
				if (td) {
					if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
		else{
			input = document.getElementById("type");
			filter = "";
			table = document.getElementById("table");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[2];
				if (td) {
					if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	}
	

</script>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #f0f0f0">
	<!-- Button open side bar --> <img src="img/hamburger.png"
		onclick="openNav();">
	<div class="justify-content-end">
		<form class="form-inline" action="/Tasks/deslog" method="POST">
			<button type="submit" class="btn btn-outline-danger">Logout</button>
		</form>
	</div>
	</nav>

	<!-- Side bar! -->
	<div id="mySidenav" class="sidenav">
		<br> <br> <a href="javascript:void(0)" class="closebtn"
			onclick="closeNav()">&times;</a> <a href="initial">Professors!</a> <br>
		<a href="students">Students!</a> <br> <a href="questions">Questions!</a>
		<br> <a href="class">Class!</a> <br> <a href="matter">Matters!</a>
		<br> <a href="test">Tests!</a>
		<br> <a href="grades">Grades!</a>
		
	</div>
	<!-- End side bar! -->


	<br>
	
	<div class="container">
		<h1 class="display-3">Welcome, Professor!</h1>
		<br>
		<h1 class="display-4">Here are all teachers.</h1>
	</div>
	<br>
	<br>
	<div class="row d-flex justify-content-center">
		<form class="form-inline" action="addservlet" method="GET">
			<button type="submit" class="btn btn-outline-info">Add Professor!</button>
		</form>
	</div>
	<br>
	<br>
	<div class="container">
		<form>
			<div class="row">
				<div class="col-sm-12">
					<div class="container">
						<label for="emailsearch">Search by email</label> <input
							type="email" name="emailsearch" id="emailsearch"
							placeholder="Enter email to filter..." class="form-control"
							aria-describedby="emailHelp" onkeyup="search();">
					</div>
				</div>
			</div>
		</form>
	</div>
	<br>
	<br>
	<div class="container">
		<table class="table" id="table">
			<thead>
				<tr>
					<th scope="col"><center>Name</center></th>
					<th scope="col"><center>Login</center></th>
					<th scope="col"><center>Edit</center></th>
					<th scope="col"><center>Delete</center></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${allUsers}">
					<tr id="tr">
						<td><center>${user.name}</center></td>
						<td><center>${user.login}</center></td>
						<td><center>
								<a href="update?Cod=${user.id}"><button
										class="btn btn-outline-warning" type="button">Edit</button></a>
							</center></td>
						<td><center>
								<a href="delete?Cod=${user.id}&type=${user.type}"><button
										class="btn btn-outline-danger" type="button">Delete</button></a>
							</center></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>