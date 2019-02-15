<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Matters!</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/nav.css">
<script src="Dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="Dist/sweetalert.css">
<script type="text/javascript">
	/* Set the width of the side navigation to 250px */
	function openNav() {
		document.getElementById("mySidenav").style.width = "250px";
	}

	/* Set the width of the side navigation to 0 */
	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
	}
	
	function Validate() {
		if(form.matter.value == ""){
			return false;
		}
		return true;
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
		<h1 class="display-4">Here you can add matters.</h1>
		<br> <br> <br> <br>
		<div class="container">
			<form name="form" action="matteradd" method="POST"
				onsubmit="return Validate();">
				<div class="row">
					<div class="col-sm-12">
						<div class="container">
							<label for="theme">Name of the matter</label> <input type="text"
								name="matter" id="matter" placeholder="Matter"
								class="form-control">
						</div>
					</div>
				</div>
				<br /> <br />
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<div class="container">
							<br>
							<button type="submit" class="btn btn-outline-info btn-block"
								name="btnCad" onclick="Validate();">Save</button>
						</div>
					</div>

				</div>
			</form>
		</div>
		<br> <br>

	</div>
	<br>
</body>
</html>