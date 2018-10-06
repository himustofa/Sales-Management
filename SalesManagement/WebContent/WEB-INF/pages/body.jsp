<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Sales Management</title>
		<link rel="shortcut icon" href="/ref/images/logo.png">
		
		
		<!-- AngularJS -->
		<script src="/ref/angularjs/1.6.6/js/angular.min.js"></script>
		
		<!-- Font Awesome -->
		<link rel="stylesheet" href="/ref/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<!-- Bootstrap | jQuery -->
		<link rel="stylesheet" href="/ref/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="/ref/jquery/3.2.1/js/jquery.min.js"></script>
		<script src="/ref/jquery/1.17.0/js/jquery.validate.min.js"></script>
		<script src="/ref/jquery/1.17.0/js/additional-methods.min.js"></script>
		<script src="/ref/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- Bootstrap Datepicker -->
		<link rel="stylesheet" type="text/css" href="/ref/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css" />
		<script src="/ref/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
		
		<!-- DataTables -->
		<link rel="stylesheet" type="text/css" href="/ref/datatables/1.10.15/css/dataTables.bootstrap.min.css" />
		<script src="/ref/datatables/1.10.15/js/jquery.dataTables.min.js"></script>
		<script src="/ref/datatables/1.10.15/js/dataTables.bootstrap.min.js"></script>
		
		<!-- jQuery iziModal -->
		<link rel="stylesheet" href="/ref/iziModal/1.5.1/css/iziModal.min.css" />
		<script src="/ref/iziModal/1.5.1/js/iziModal.min.js"></script>
		
		<!-- SweetAlert -->
		<script src="/ref/sweetalert/sweetalert.js"></script>
		<link rel="stylesheet" href="/ref/sweetalert/sweetalert.css">
		
		<!-- W3.CSS -->
		<link rel="stylesheet" href="/ref/w3/w3.css">
		<link rel="stylesheet" href="/ref/w3/w3-theme-red.css">
		
		<!-- Bootstrap Dropdown -->
		<link rel="stylesheet" href="/ref/bootstrap-select/bootstrap-select.min.css">
		<script src="/ref/bootstrap-select/bootstrap-select.min.js"></script>
		
		
		
		<style type="text/css" media="screen">
			/*=========== Toolbar/Navbar | Remove the navbar's default margin-bottom and rounded borders ===========*/ 
			.navbar {
			background-color: #383838;
			margin-bottom: 0;
			border-radius: 0;
			padding: 20px;
			margin: 0px 0px 20px 0px;
			}
			.navbar-inverse .navbar-toggle {
			border-color: white;
			}
			/*=========== Footer ===========*/
			footer {
			background-color: #383838;
			color: white;
			padding: 20px;
			margin: 50px 0px 0px 0px;
			}
			p{
			font-family: Verdana,sans-serif;
			font-size: 12px;
			color:#9d9d9d;
			}
			
			
			/*=========== Modify Button ===========*/
			.button-modify {
			display: inline-block;
			margin: 0px 20px 20px 0px;
			padding: 8px 20px;
			background:#fff;
			border:1px #333 solid;
			font-size:14px;
			color:#333;
			float: right;
			}
			.button-modify:hover {
			color: #FFFFFF; /*3c763d*/
			background-color: #808080; /*dff0d8*/
			border-color: #383838; /*00AF66*/
			}

		</style>
		
	</head>
	<body>
		
		<!-- ================== Header | Toolbar ================== -->
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>                      
					</button>
					<a class="navbar-brand" href="https://www.facebook.com/hikamal" data-toggle="tooltip" data-placement="bottom" title=""><img height="140%" width="" src="/ref/images/company-logo.png"></img></a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<!-- <li class="active"><a href="#">Home</a></li> -->
						<li><a href="/supplier/show" data-toggle="tooltip" data-placement="bottom" title="Suppliers">Suppliers</a></li>
						<li><a href="/product/show" data-toggle="tooltip" data-placement="bottom" title="Stock Items">Products</a></li>
						<li><a href="/purchase/show">Purchases</a></li>
						<li><a href="/customer/show">Customers</a></li>
						<li><a href="/sale/show">Sales</a></li>
						</ul>
					<ul class="nav navbar-nav navbar-right">
						<!-- <li><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li> -->
						<li><a href="" data-toggle="tooltip" data-placement="bottom" title="Home"><span class="glyphicon glyphicon-home"></span></a></li>
						<li><a href="/setting/show" data-toggle="tooltip" data-placement="bottom" title="Administrator/Settings"><span class="glyphicon glyphicon-cog"></span></a></li>
						<li><a href="https://www.facebook.com/hikamal" data-toggle="tooltip" data-placement="bottom" title="Help?"><span class="glyphicon glyphicon-question-sign"></span></a></li>
						<li><a href="/user/show" data-toggle="tooltip" data-placement="bottom" title="Sign Up"><span class="glyphicon glyphicon-user"></span></a></li>
						<li><a href="/login" data-toggle="tooltip" data-placement="bottom" title="Login"><span class="glyphicon glyphicon-log-in"></span></a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		
		
		
		
		
		
		
		<!-- Start: container -->
		<div class="container">
			
			<form:form method="POST" class="ajax " data-handler="showMessage" data-validator="validate" action="save">
			</form:form>
			
			<h2 class="main-title">Sales Management</h2>
			
			
		
			
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="/ref/images/img1.jpg" alt="Kamal" style="width:100%; height:400px; opacity:0.8">
					</div>
					<div class="item">
						<img src="/ref/images/img2.jpg" alt="Kamal" style="width:100%; height:400px; opacity:0.8">
					</div>
					<div class="item">
						<img src="/ref/images/img3.jpg" alt="Kamal" style="width:100%; height:400px; opacity:0.8">
					</div>
				</div>
				
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			
			
		</div>
		<!-- End: container -->
		
		
		
		
		
		
		<!-- ================== Footer ================== -->
		<footer class="container-fluid text-center">
			<h6>Welcome to ${username}</h6>
			<p>© Copyright 2017. All Rights Reserved by Kamal</p>
		</footer>
		
		
		
		
		
		
		<script>
		
		//Tooltips
		$(document).ready(function(){
			$('[data-toggle="tooltip"]').tooltip();   
		});
		
		$(".main-title").text($(".main-title").text().toUpperCase());
			
		</script>
		
		
		
		
	</body>
</html>