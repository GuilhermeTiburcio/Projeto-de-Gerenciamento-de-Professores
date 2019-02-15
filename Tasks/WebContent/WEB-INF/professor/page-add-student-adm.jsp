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
<title>Add Students</title>

<script type="text/javascript">
	function validate() {
		if (form.email.value == "" || form.pass.value == ""
				|| form.confPass.value == "") {
			sweetAlert("Error!", "Fill in all the fields!", "error");
			return false;
		}
		if (form.pass.value != form.confPass.value) {
			sweetAlert("Error!", "The passwords are different!", "error");
			return false;
		}
	}

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
			td = tr[i].getElementsByTagName("td")[0];
			if (td) {
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
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
		<h1 class="display-4">Here you can add Students.</h1>
	</div>
	<br>
	<br>
	<br>
	<div class="container">
		<form name="form" action="studentAddm" method="POST"
			onsubmit="return validate();">
			<div class="row">

				<div class="col-sm-4">
					<div class="container">
						<label for="pass">Name</label> <input type="text" name="name"
							id="name" placeholder="Name" class="form-control">
					</div>
				</div>
				
				<div class="col-sm-4">
					<div class="container">
						<label for="pass">RA</label> <input type="text"
							name="ra" id="ra" placeholder="RA" class="form-control">
					</div>
				</div>
				
				<div class="col-sm-4">
					<div class="container">
						<label for="email">Email address</label> <input type="email"
							name="email" id="email" placeholder="Email" class="form-control"
							aria-describedby="emailHelp">
					</div>
				</div>


			</div>
			<br> <br>
			<div class="row">

				<div class="col-sm-4">
					<div class="container">
						<label for="pass">Password</label> <input type="Password"
							name="pass" id="pass" placeholder="Password" class="form-control">
					</div>
				</div>
				
				<div class="col-sm-4">
					<div class="container">
						<label for="confPass">Confirm your password</label> <input
							type="Password" name="confPass" id="confPass"
							placeholder="Confirm your password" class="form-control">
					</div>
				</div>


				<div class="col-sm-3">
					<div class="container">
						<br>
						<button type="submit" class="btn btn-outline-info btn-block"
							name="btnCad" onclick="validate();">Save</button>
					</div>
				</div>
			</div>




		</form>
	</div>
	<br>
	<br>
</body>
</html>