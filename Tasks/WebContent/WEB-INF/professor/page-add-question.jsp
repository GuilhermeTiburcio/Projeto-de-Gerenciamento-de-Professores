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
<title>Add Question!</title>
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
		if (form.statement.value == "" || form.theme.value == "" || form.matter.value == "") {
			sweetAlert("Error!", "Fill in all the fields!", "error");
			return false;
		}
		
		if(form.Alternative1.value == "" || form.Alternative2.value == "" || form.Alternative3.value == "" || form.Alternative4.value == "" || form.Alternative5.value == ""){
			sweetAlert("Error!", "Fill in all alternatives!", "error");
			return false;
		}
		
		if(!form.radio1.checked && !form.radio2.checked && !form.radio3.checked && !form.radio4.checked && !form.radio5.checked){
				sweetAlert("Error!", "Check the correct alternative!", "error");
				return false;
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
		<h1 class="display-4">Here you can add questions.</h1>
	</div>
	<br>
	<br>
	<div class="container">
		<form name="form" action="addQuestions" method="POST"
			onsubmit="return Validate();">
			<div class="row">
				<div class="col-sm-12">
					<div class="container">
						<label for="statement">Statement</label> 
						<textarea type="text" name="statement" id="statement" placeholder="Statement" class="form-control"></textarea>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
			<div class="col-sm-3">
					<div class="container">
						<label for="level">Level</label> 
						<select id="level" name="level" class="form-control">
						<% 
							for(int i = 1; i <= 10; i++){
								out.println("<option>"+i+"</option>");
							}
						%>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="container">
						<label for="theme">Theme</label> 
						<input type="text" name="theme" id="theme" placeholder="Theme" class="form-control">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="container">
						<label for="matter">Matter</label> 
						<select id="matter" name="matter" class="form-control">
						<% 
							for(IDomain m : new MatterController().getList()){
								Matter mat = (Matter) m;
								out.println("<option>"+mat.getName()+"</option>");
							}
						%>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="container">
						
					</div>
				</div>
				
				<div class="col-sm-7">
					<div class="container">
						<br>
						<br>
						<label>Check the correct alternative</label> 
						<br>
						<br>
						<label class="custom-control custom-radio">  
						 <input
							id="radio1" name="radio" type="radio"
							class="custom-control-input" value="A">
							<span class="custom-control-indicator">  </span>
								<input type="text" name="Alternative1" id="Alternative1" placeholder="Alternative one" class="form-control">
						</label>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<input type="hidden">
					</div>
				</div>	
				<div class="col-sm-7">
					<div class="container">
					<br>
						<label class="custom-control custom-radio">  
						 <input
							id="radio2" name="radio" type="radio"
							class="custom-control-input" value="B">
							<span class="custom-control-indicator">  </span>
								<input type="text" name="Alternative2" id="Alternative2" placeholder="Alternative two" class="form-control">
						</label>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<input type="hidden">
					</div>
				</div>	
				<div class="col-sm-7">
					<div class="container">
					<br>
						<label class="custom-control custom-radio">  
						 <input
							id="radio3" name="radio" type="radio"
							class="custom-control-input" value="C">
							<span class="custom-control-indicator">  </span>
								<input type="text" name="Alternative3" id="Alternative3" placeholder="Alternative three" class="form-control">
						</label>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<input type="hidden">
					</div>
				</div>	
				<div class="col-sm-7">
					<div class="container">
					<br>
						<label class="custom-control custom-radio">  
						 <input
							id="radio4" name="radio" type="radio"
							class="custom-control-input" value="D">
							<span class="custom-control-indicator">  </span>
								<input type="text" name="Alternative4" id="Alternative4" placeholder="Alternative four" class="form-control">
						</label>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<input type="hidden">
					</div>
				</div>	
				<div class="col-sm-7">
					<div class="container">
					<br>
						<label class="custom-control custom-radio">  
						 <input
							id="radio5" name="radio" type="radio"
							class="custom-control-input" value="E">
							<span class="custom-control-indicator">  </span>
								<input type="text" name="Alternative5" id="Alternative5" placeholder="Alternative five" class="form-control">
						</label>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<input type="hidden">
					</div>
				</div>	
				<div class="col-sm-3">
					<div class="container">
						<br>
						<button type="submit" class="btn btn-outline-info btn-block"
							name="btnCad" onclick="Validate();">Save</button>
					</div>
				</div>

			</div>
				<br>
				<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="container">
						<input type="hidden">
					</div>
				</div>	
			</div>
		</form>
	</div>
</body>
</html>