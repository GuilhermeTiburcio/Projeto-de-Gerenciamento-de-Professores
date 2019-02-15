<%@page import="br.com.alpha.tasks.domain.Alternatives"%>
<%@page import="br.com.alpha.tasks.controller.QuestionController"%>
<%@page import="br.com.alpha.tasks.domain.Question"%>
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
<title>Test!</title>

<script>

function validate() {
	alert("Good job!");
	return true;
}


</script>

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
			<h1 class="display-4">
				<center>Good test!</center>
			</h1>
		</div>
		<br> <br>
		<form name="form" method="POST" action="student-test" onsubmit="validate();">

			<%
						int id = Integer.parseInt(request.getParameter("Test"));
						int codStatement = 1;
						int radio = 1;
						int sid = Integer.parseInt(request.getParameter("sid"));
						for(Question q : new LoginController().idQuestion(id)){
							
							Question question = (Question) QuestionController.getElementById(q.getId());
							String[] values = new String[question.getAlternatives().size()];
							boolean[] bool = new boolean[question.getAlternatives().size()];
							int j = 0;
							for(Alternatives a: question.getAlternatives()){
								values[j] = a.getText();
								bool[j] = a.isChecked();
								j++;
							}
							out.println("<h1 class='display-5'>"+codStatement+"º "+question.getStatement()+"</h1><br/>");
							out.println("<label>Check the correct alternative</label></br><br/>");
							if(bool[0])
							 	out.println("a) <input type='radio' id='radio' name='radio"+radio+"' value='certa'> "+values[0]+"<br/><br/>");
							 else
								out.println("a) <input type='radio' id='radio' name='radio"+radio+"' value='errada'>"+values[0]+"<br/><br/>");
							
							if(bool[1])
							 	out.println("b) <input id='radio1' name='radio"+radio+"' type='radio' value='certa'>"+values[1]+"<br/><br/>");
							 else
								out.println("b) <input id='radio1' name='radio"+radio+"' type='radio' value='errada'>"+values[1]+"<br/><br/>");
							
							if(bool[2])
							 	out.println("c) <input id='radio2' name='radio"+radio+"' type='radio' value='certa'>"+values[2]+"<br/><br/>");
							 else
								out.println("c) <input id='radio2' name='radio"+radio+"' type='radio' value='errada'>"+values[2]+"<br/><br/>");
							
							if(bool[3])
							 	out.println("d) <input id='radio3' name='radio"+radio+"' type='radio' value='certa'>"+values[3]+"<br/><br/>");
							 else
								out.println("d) <input id='radio3' name='radio"+radio+"' type='radio' value='errada'>"+values[3]+"<br/><br/>");
							
							if(bool[4])
							 	out.println("e) <input id='radio4' name='radio"+radio+"' type='radio' value='certa'>"+values[4]+"<br/><br/>");
							 else
								out.println("e) <input id='radio4' name='radio"+radio+"' type='radio' value='errada'>"+values[4]+"<br/><br/>");
							out.println("</br>");
							codStatement++;
							radio++;
						}
						radio -= 1;
						codStatement -=1;
						out.println("<input type='hidden' name='qntradios' value='"+radio+"'>");
						out.println("<input type='hidden' name='qntQuestions' value='"+codStatement+"'>");
						
						out.println("<input type='hidden' name='Test' value='"+id+"'>");
						out.println("<input type='hidden' name='sid' value='"+sid+"'>");
			%>
			<br>
			<div class="row d-flex justify-content-center">
				<div class="col-sm-4">
					<div class="container">
						<br /> <br />
						<button type="submit" class="btn btn-outline-info btn-block"
							name="btnCad">Send</button>
					</div>
				</div>
			</div>
		</form>
		<br> <br>

	</div>
</body>
</html>