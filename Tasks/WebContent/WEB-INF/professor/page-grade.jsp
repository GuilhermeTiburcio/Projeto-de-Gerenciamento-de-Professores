<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grades!</title>
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
	
	function search() {
		input = document.getElementById("emailsearch");
		filter = input.value.toUpperCase();
		table = document.getElementById("table");
		tr = table.getElementsByTagName("tr");
		for(i = 0; i < tr.length; i++){
			td = tr[i].getElementsByTagName("td")[0];
			if(td){
				if(td.innerHTML.toUpperCase().indexOf(filter) > -1){
					tr[i].style.display = "";
				}else{
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
		<h1 class="display-4">Here are all the student grades.</h1>
		<br> <br>
		
		<form onsubmit="return false;">
			<div class="row">
				<div class="col-sm-12">
					<div class="container">
						<label for="emailsearch">Enter the name of the student to filter</label> <input
							type="text" name="emailsearch" id="emailsearch"
							placeholder="Enter the name of the student to filter..."
							class="form-control" aria-describedby="emailHelp"
							onkeyup="search();">
					</div>
				</div>
			</div>
		</form>
		<br>
		<br>
		<table class="table" id="table">
			<thead>
				<tr>
					<th scope="col"><center>Students</center></th>
					<th scope="col"><center>Class</center></th>
					<th scope="col"><center>Matter</center></th>
					<th scope="col"><center>Grade</center></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="q" items="${list}">
					<tr id="tr">
						<td><center>${q.student.name}</center></td>
							<td><center>${q.clas.name}</center></td>
						<td><center>${q.matter.name}</center></td>
						<td><center>${q.grade}</center></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</div>
	<br>
</body>
</html>