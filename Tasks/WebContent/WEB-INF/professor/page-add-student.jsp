<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="Dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="Dist/sweetalert.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Material Design Bootstrap -->
<link href="css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="css/style.css" rel="stylesheet">
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>


<title>Register Student</title>
<script type="text/javascript">
	function validate(ra, login, senha) {
		if (ra == "" || login == "" || senha == "") {
			sweetAlert("Error!", "Fill in all the fields!", "error");
			return false;
		}
		
        
        if(document.getElementById('veri').value == 1){
        	sweetAlert("Error!", "This RA has already been registered!", "error");
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
        var ra = document.getElementById("ra").value;
        con_consulta.open("GET", "ra-duplicate?ra=" + ra, true);
        con_consulta.send(null);

	}
</script>
</head>
<body>
	<br>
	<br>
	<section class="form-elegant">
	<div id="recebe"><input type="hidden" id="veri" name="veri" value="0"></div>
		<div class="container">
			<!--Form without header-->
			<div class="card">
				<form method="POST" action="saveStudent" onsubmit="return validate(ra.value,email.value,password.value);">
					<div class="card-body mx-4">

						<!--Header-->
						<div class="text-center">
							<h3 class="dark-grey-text mb-5">
								<strong>Register Student</strong>
							</h3>
						</div>
						<br>
						<div class="md-form">
							<input type="text" id="ra" name="ra" class="form-control" onblur="teste();">
							<label for="ra" class="">RA of the student</label>
						</div>

						<br>
						<div class="md-form">
							<input type="text" id="name" name="name" class="form-control">
							<label for="name" class="">Name</label>
						</div>
						<br>
						<div class="md-form">
							<input type="email" id="email" name="email" class="form-control">
							<label for="email" class="">Email</label>
						</div>
						<br>
						<div class="md-form">
							<input type="password" id="password" name="password"
								class="form-control"> <label for="password" class="">Password</label>
						</div>
						<br>
						<div class="text-center mb-4">
							<button type="submit" class="btn btn-danger btn-block z-depth-2" onclick="return validate(ra.value,email.value,password.value);">Sign
								in</button>
						</div>

						<div class="text-center mb-4">
							<a href="index.html"><button type="button"
									class="btn btn-info z-depth-2">Come back</button></a>
						</div>
					</div>

					<!--Footer-->
					<div class="modal-footer mx-5 pt-3 mb-1"></div>
				</form>
			</div>
			<!--/Form without header-->
		</div>
	</section>

	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="js/popper.min.js"></script>

	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="js/mdb.min.js"></script>


</body>
</html>