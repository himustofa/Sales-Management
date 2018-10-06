<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
        <title>Login</title>

        <!-- AngularJS -->
		<script src="/ref/angularjs/1.6.6/js/angular.min.js"></script>
		
		<!-- Font Awesome -->
		<link rel="stylesheet" href="/ref/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<!-- Bootstrap | jQuery -->
		<link rel="stylesheet" href="/ref/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="/ref/jquery/3.2.1/js/jquery.min.js"></script>
		<script src="/ref/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- Bootstrap Datepicker -->
		<link rel="stylesheet" type="text/css" href="/ref/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css" />
		<script src="/ref/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
		
		<!-- DataTables -->
		<link rel="stylesheet" type="text/css" href="/ref/datatables/1.10.15/css/dataTables.bootstrap.min.css" />
		<script src="/ref/datatables/1.10.15/js/jquery.dataTables.min.js"></script>
		<script src="/ref/datatables/1.10.15/js/dataTables.bootstrap.min.js"></script>
		
		<!-- SweetAlert -->
		<script src="/ref/sweetalert/sweetalert.js"></script>
		<link rel="stylesheet" href="/ref/sweetalert/sweetalert.css">
		
		<!-- W3.CSS -->
		<link rel="stylesheet" href="/ref/w3/w3.css">
        <link rel="stylesheet" href="/ref/w3/w3-theme-red.css">
		
		<!-- Bootstrap Dropdown -->
		<link rel="stylesheet" href="/ref/bootstrap-select/bootstrap-select.min.css">
        <script src="/ref/bootstrap-select/bootstrap-select.min.js"></script>

        <link rel="stylesheet" type="text/css" href="/ref/common/styles.css" />
        

    </head>
    <body>
        <section class="container login-form">
            <section>
                <form:form id="login" method="post" action="body" role="login"  modelAttribute="login">
                    <a href="https://www.facebook.com/hikamal"><img src="/ref/images/sample-company.png" width="50%" alt="" class="img-responsive" /></a>
					
					<%-- <div class="alert alert-block alert-danger hidden">${message}</div> --%>
					<font color="red">${message}</font>
					
                    <div class="form-group">
                        <input type="text" id="user" name="user" required class="form-control" placeholder="Enter username" />
                        <span class="glyphicon"><i class="fa fa-user" aria-hidden="true"></i></span>
                    </div>

                    <div class="form-group">
                        <input type="password" id="password" name="password" required class="form-control" placeholder="Enter password" />
                        <span class="glyphicon"><i class="fa fa-lock" aria-hidden="true"></i></span>
                    </div>

                    <button type="submit" name="go" class="btn btn-primary btn-block">Login Now</button>

                    <a href="#">Reset password</a> or <a href="user/show">create account</a> 
                </form:form>
            </section>

            <div>
                <div class="socialicon"><p><i class="fa fa-facebook" aria-hidden="true"></i></p></div>
                <div class="socialicon"><p><i class="fa fa-twitter" aria-hidden="true"></i></p></div>
                <div class="socialicon"><p><i class="fa fa-youtube-play" aria-hidden="true"></i></p></div>
            </div>
        </section>
        
        <script type="text/javascript">
//         	$('#user').val('hikamal');
//         	$('#password').val('123');
//         	if('${message}'){
//         		$(".alert").removeClass("hidden");
//         	}
        </script>

    </body>
</html>