<%@page import="br.com.alpha.tasks.domain.Class"%>
<%@page import="br.com.alpha.tasks.controller.ClassController"%>
<%@page import="br.com.alpha.tasks.domain.IDomain"%>
<%@page import="br.com.alpha.tasks.controller.StudentController"%>
<%@page import="br.com.alpha.tasks.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Class!</title>
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

	function mascaraData(val) {
		var pass = val.value;
		var expr = /[0123456789]/;

		for (i = 0; i < pass.length; i++) {
			// charAt -> retorna o caractere posicionado no índice especificado
			var lchar = val.value.charAt(i);
			var nchar = val.value.charAt(i + 1);

			if (i == 0) {
				// search -> retorna um valor inteiro, indicando a posição do inicio da primeira
				// ocorrência de expReg dentro de instStr. Se nenhuma ocorrencia for encontrada o método retornara -1
				// instStr.search(expReg);
				if ((lchar.search(expr) != 0) || (lchar > 3)) {
					val.value = "";
				}

			} else if (i == 1) {

				if (lchar.search(expr) != 0) {
					// substring(indice1,indice2)
					// indice1, indice2 -> será usado para delimitar a string
					var tst1 = val.value.substring(0, (i));
					val.value = tst1;
					continue;
				}

				if ((nchar != '/') && (nchar != '')) {
					var tst1 = val.value.substring(0, (i) + 1);

					if (nchar.search(expr) != 0)
						var tst2 = val.value.substring(i + 2, pass.length);
					else
						var tst2 = val.value.substring(i + 1, pass.length);

					val.value = tst1 + '/' + tst2;
				}

			} else if (i == 4) {

				if (lchar.search(expr) != 0) {
					var tst1 = val.value.substring(0, (i));
					val.value = tst1;
					continue;
				}

				if ((nchar != '/') && (nchar != '')) {
					var tst1 = val.value.substring(0, (i) + 1);

					if (nchar.search(expr) != 0)
						var tst2 = val.value.substring(i + 2, pass.length);
					else
						var tst2 = val.value.substring(i + 1, pass.length);

					val.value = tst1 + '/' + tst2;
				}
			}

			if (i >= 6) {
				if (lchar.search(expr) != 0) {
					var tst1 = val.value.substring(0, (i));
					val.value = tst1;
				}
			}
		}

		if (pass.length > 10)
			val.value = val.value.substring(0, 10);
		return true;

	}

	function validate() {
		/*if (form.name.value == "" || form.start.value == "" || form.final.value == "") {
			sweetAlert("Error!", "Fill in all the fields!", "error");
			return false;
		}
		var vetor[];
		
			vetor[i] = form.check+i.che;
			alert(form.name.value);
		}*/
		for (var i = 1; i < form.qnt.value; i++) {
			vetor[i] = document.getElementById('check' + i).checked;
		}
		
		for(var j = 0; j < vetor.length; j++){
			alert(vetor[j]);
			return false;
		}
	}
</script>
</head>
<body>
	<% Class c = (Class) new ClassController().getElementById(Integer.parseInt(request.getParameter("Cod"))); %>
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
		<h1 class="display-4">Here you can edit classes.</h1>
		<br> <br> <br> <br>
		<div class="container">
			<form name="form" action="classAdd" method="POST"
				onsubmit="return validate();">
				<input type="hidden" name="qnt" id="qnt"
					value="<%out.println(new StudentController().getList().size());%>">
				<div class="row">
					<div class="col-sm-4">
						<div class="container">
							<label for="name">Name of the class</label> <input type="text"
								name="name" id="name" placeholder="Name" class="form-control" value="<% out.println(c.getName()); %>">
						</div>
					</div>

					<div class="col-sm-4">
						<div class="container">
							<label for="start">Start date</label> <input type="text"
								name="start" id="start" placeholder="Start date"
								class="form-control" maxlength="10"
								onkeypress="mascaraData(this)" value="<% out.println(c.getStartDate()); %>">
						</div>
					</div>

					<div class="col-sm-4">
						<div class="container">
							<label for="final">Final date</label> <input type="text"
								name="final" id="final" placeholder="Final date"
								class="form-control" maxlength="10"
								onkeypress="mascaraData(this)" value="<% out.println(c.getFinalDate()); %>">
						</div>
					</div>
				</div>
				<br /> <br />

				<div class="row">
					<div class="col-sm-4">
						<div class="container">
							<label for="description">Description</label>
							<textarea type="text" name="description" id="description"
								placeholder="Description" class="form-control"><% out.println(c.getDescription()); %></textarea>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="container">
							<br /> <br />
							<button type="submit" class="btn btn-outline-info btn-block"
								name="btnCad" onclick="validate();">Save</button>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="container">
							<label>Select class students</label>
							<table class="table" id="table">
								<thead>
									<tr>
										<th scope="col"><center>Select</center></th>
										<th scope="col"><center>Name</center></th>
										<th scope="col"><center>RA</center></th>
									</tr>
								</thead>
								<tbody>
									<!--  <br />
									
									<c:forEach var="q" items="${List}">
										
											<td><center>
													<input type="checkbox" class="form-control" id="check" name="check" value="${ q.id }"/>
												</center></td>
											<td><center>${q.name}</center></td>
											<td><center>${q.ra}</center></td>
										</tr>
									</c:forEach>-->
									<%
										int i = 1;
											for(IDomain idoman : new StudentController().getList()){
												Student s = (Student) idoman;
												out.println("<tr id='tr'>");
												out.println("<td><center><input type='checkbox' class='form-control' id='check"+i+"' name='check"+i+"' value='"+s.getId()+"'/></center></td>");
												out.println("<td><center>"+s.getName()+"</center></td>");
												out.println("<td><center>"+s.getRa()+"</center></td>");	
												out.println("</tr>");
												i++;
											}
									%>
								</tbody>
							</table>

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