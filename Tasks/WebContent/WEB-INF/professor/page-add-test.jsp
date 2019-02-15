<%@page import="br.com.alpha.tasks.domain.Class"%>
<%@page import="br.com.alpha.tasks.controller.ClassController"%>
<%@page import="br.com.alpha.tasks.domain.IDomain"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.alpha.tasks.controller.MatterController"%>
<%@page import="br.com.alpha.tasks.domain.Matter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Test!</title>
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
		if (form.class.value == "Select Class" || form.matter.value == "Select Matter") {
			sweetAlert("Error!", "Fill in all the fields!", "error");
			return false;
		}		
	}
	
	function teste() {
        var con_consulta;
        if (window.XMLHttpRequest) {
            con_consulta = new XMLHttpRequest();
        } else
        {
            con_consulta = new ActiveXObject("Microsoft.XMLHTTP");
        }
        con_consulta.onreadystatechange = function () {
            if (con_consulta.readyState == 4 && con_consulta.status == 200) {
                document.getElementById("recebe").innerHTML = con_consulta.responseText;
            }
        }
        var matter = document.getElementById("matter").value;
        con_consulta.open("GET", "list-of-question?matter=" + matter, true);
        con_consulta.send(null);

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
		<h1 class="display-4">Here you can add Test.</h1>
	</div>
	<br>
	<br>
	<div class="container">
		<form name="form" action="testAdd" method="POST"
			onsubmit="return Validate();">
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-4">
					<div class="container">
						<label for="class">Class</label> <select id="class" name="class"
							class="form-control">
							<option>Select Class</option>
							<%
								for(IDomain m : new ClassController().getList()){
									Class c = (Class) m;
									out.println("<option>"+c.getName()+"</option>");
								}
							%>
						</select>
					</div>
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-4">
					<div class="container">
						<label for="matter">Matter</label> <select id="matter"
							name="matter" class="form-control" onchange="return teste();">
							<option>Select Matter</option>
							<%
								for(IDomain m : new MatterController().getList()){
									Matter mat = (Matter) m;
									out.println("<option>"+mat.getName()+"</option>");
								}
							%>
						</select>
					</div>
				</div>
			</div>

			<div class="row d-flex justify-content-center">
				<div id="recebe"></div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-sm-4">
					<div class="container">
						<br /> <br />
						<button type="submit" class="btn btn-outline-info btn-block"
							name="btnCad" onclick="Validate();">Save</button>
					</div>
				</div>
			</div>
			
			<br/><br/>
		</form>
	</div>
</body>
</html>