<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questions!</title>
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
		<h1 class="display-4">Here you can see all the questions.</h1>
		<br> <br>
		<div class="row d-flex justify-content-center">
			<form class="form-inline" action="addQuestions" method="GET">
				<button type="submit" class="btn btn-outline-info">Add question!</button>
			</form>
		</div>
		<br> <br>
		<form onsubmit="return false;">
			<div class="row">
				<div class="col-sm-12">
					<div class="container">
						<label for="emailsearch">Enter the name of the course to filter</label> <input
							type="text" name="emailsearch" id="emailsearch"
							placeholder="Enter the name of the course to filter..."
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
					<th scope="col"><center>Statement</center></th>
					<th scope="col"><center>Theme</center></th>
					<th scope="col"><center>Level</center></th>
					<th scope="col"><center>Edit</center></th>
					<th scope="col"><center>Delete</center></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="q" items="${allQuestions}">
					<tr id="tr">
						<td><center>${q.statement}</center></td>
						<td><center>${q.theme}</center></td>
						<td><center>${q.level}</center></td>
						
												<td><center>
								<a href="edit_question?Cod=${q.id}"><button
										class="btn btn-outline-warning" type="button">Edit</button></a>
							</center></td>
						<td><center>
								<a href="delete-question?Cod=${q.id}"><button
										class="btn btn-outline-danger" type="button">Delete</button></a>
							</center></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</div>
	<br>
</body>
</html>