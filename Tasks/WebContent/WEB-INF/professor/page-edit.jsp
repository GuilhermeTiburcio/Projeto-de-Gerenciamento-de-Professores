<%@page import="java.io.PrintWriter"%>
<%@page import="br.com.alpha.tasks.domain.User"%>
<%@page import="br.com.alpha.tasks.controller.UserController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="Dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="Dist/sweetalert.css">

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
</script>
</head>
<body>
	<%
		User u = new User();
		int id = Integer.parseInt(request.getParameter("Cod"));
		UserController uc = new UserController();
		u = uc.getElementById(id);
		request.getSession().setAttribute("idUser", u.getId());
	%>
	<nav class="navbar navbar-light justify-content-end"
		style="background-color: #FAFAFA">
	<form class="form-inline" action="/Tasks/deslog" method="POST">
		<button type="submit" class="btn btn-outline-danger">Logout</button>
	</form>
	</nav>
	<div class="container">
		<h1 class="display-3">Welcome, Professor!</h1>
		<br>
		<h1 class="display-4">
			You are editing the
			<%
			String nome = u.getLogin();
			String names[] = nome.split("@");
			out.print(names[0]);
		%>.
		</h1>
	</div>
	<br>
	<br>
	<div class="container">
		<form name="form" action="update" method="POST"
			onsubmit="return validate();">
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<label for="email">Name</label> <input type="text" name="name"
							id="name" placeholder="Name" class="form-control"
							aria-describedby="emailHelp" value="<%out.print(u.getName());%>">
					</div>
				</div>

				<div class="col-sm-4">
					<div class="container">
						<label for="email">Email address</label> <input type="email"
							name="email" id="email" placeholder="Email" class="form-control"
							aria-describedby="emailHelp" value="<%out.print(u.getLogin());%>">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="container">
						<label for="pass">Password</label> <input type="Password"
							name="pass" id="pass" placeholder="Password" class="form-control"
							value="<%out.print(u.getPassword());%>">
					</div>
				</div>

			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<label for="confPass">Confirm your password</label> <input
							type="Password" name="confPass" id="confPass"
							placeholder="Confirm your password" class="form-control"
							value="<%out.print(u.getPassword());%>">
					</div>
				</div>

				<div class="col-sm-3">
					<div class="container">
						<br>
						<button type="submit" class="btn btn-outline-info btn-block"
							name="btnCad" onclick="validate();">Edit</button>
					</div>
				</div>
			</div>


		</form>
	</div>
</body>
</html>