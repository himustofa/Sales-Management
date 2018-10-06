<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			/*=========== DatePicker ===========*/
			input.modifydatepicker, input.modifydatepicker:focus {
			background: #fff url(/assets/images/menu-date.png) no-repeat right 2px !important;
			cursor: pointer;
			}
			.fa-calendar {
			float: right;
			margin-right: 10px;
			margin-top: -23px;
			position: relative;
			z-index: 2;
			}
			
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
			footer p{
			font-family: Verdana,sans-serif;
			font-size: 12px;
			color:#9d9d9d;
			}
			
			
			/*=========== Modify Button ===========*/
			.button-modify {
			display: inline-block;
			margin: 0px 0px 0px 0px;
			padding: 8px 20px;
			background-color:#fff;
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
			
			/*=========== Submit Button ===========*/
			.btn-submit{
			float: right;
			background-color:#383838;
			color:white;
			border-radius:0px !important;
			margin-top:25px;
			}
			
			/*=========== Edit & Delete Button ===========*/
			.btn-add, .btn-edit, .btn-del {
			font-size:14px;
			background-color:#383838;
			color:white;
			border-radius: 0px !important;
			}

			/*=========== Input Field ===========*/
			.form-control {
			border-radius: 0px !important;
			}
			
			.requiredsign {
			border-left: 3px solid #ebccd1; /* red */
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
						<li><a href="/supplier/show" data-toggle="tooltip" data-placement="bottom" title="Suppliers">Suppliers</a></li>
						<li><a href="/product/show" data-toggle="tooltip" data-placement="bottom" title="Stock Items">Products</a></li>
						<li><a href="/purchase/show">Purchases</a></li>
						<li><a href="/customer/show">Customers</a></li>
						<li><a href="/sale/show">Sales</a></li>
						</ul>
					<ul class="nav navbar-nav navbar-right">
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
			
			
			<div class="page-header">
				<h1>Suppliers</h1>
			</div>
			
			<!-- Add Button -->
			<button type="button" class="btn-supplier-modal btn btn-default btn-add"><span class="fa fa-plus"></span> Add</button>
			<br/>
			<br/>
			
			
			<form:form method="POST" class="ajax " name="form" data-handler="showMessage" data-validator="validate" action="save">
				
			<!-- ==============================================[ Customers ]============================================== -->
			<div class="row">
				
				<div class="col-md-12">
					<div class="table-responsive">
						
						<table data-order='[[ 0, "desc" ]]' class="table table-bordered" id="SupplierTable">
							<thead>
								<tr style="background:#f1f1f1;">
									<th>Supplier Name</th>
									<th>Company Name</th>
									<th>Phone</th>
									<th>E-Mail</th>
									<th>Address</th>
									<th data-orderable="false">Action</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${data.list}" var="supplier">
									<tr>
										<td>${supplier.supplierName}</td>
										<td>${supplier.supplierCompanyName}</td>
										<td>${supplier.supplierPhoneNumber}</td>
										<td>${supplier.supplierEmail}</td>
										<td>${supplier.supplierAddress}</td>
										<td>
											<input name="supplier_id[]" type="hidden" class="supplier-id" value="${supplier.id}" />
											<input name="supplier_name[]" type="hidden" class="supplier-name" value="${supplier.supplierName}" />
											<input name="supplier_company[]" type="hidden" class="supplier-company" value="${supplier.supplierCompanyName}" />
											<input name="supplier_email[]" type="hidden" class="supplier-email" value="${supplier.supplierEmail}" />
											<input name="supplier_contact[]" type="hidden" class="supplier-contact" value="${supplier.supplierContactPerson}" />
											<input name="supplier_phone[]" type="hidden" class="supplier-phone" value="${supplier.supplierPhoneNumber}" />
											<input name="supplier_address[]" type="hidden" class="supplier-address" value="${supplier.supplierAddress}" />
											<input name="supplier_bank_name[]" type="hidden" class="supplier-bank-name" value="${supplier.supplierBankName}" />
											<input name="supplier_bank_account[]" type="hidden" class="supplier-bank-account" value="${supplier.supplierBankAccount}" />
											<input name="supplier_website[]" type="hidden" class="supplier-website" value="${supplier.supplierWebsite}" />
											<input name="supplier_desc[]" type="hidden" class="supplier-desc" value="${supplier.supplierDescription}" />
											
											<button type="button" onclick="editRow(this)" class="btn btn-default btn-sm btn-edit"><span class="fa fa-edit"></span></button>
											<button type="button" onclick="delRow(this)" class="btn btn-default btn-sm btn-del"><span class="fa fa-trash"></span></button>
										</td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
				
				
				
				
				
				
				
			<!-- <button type="submit" class="btn-save button-modify" style="margin-top:15px;">Save</button> -->
			<button type="submit" class="btn btn-default btn-lg btn-submit">Save</button>
			
			</form:form>
			
			
			
			
			<!-- ================== Modal ================== -->
			
			<div id="modal-supplier" data-izimodal-group="" data-izimodal-loop="" data-izimodal-title="Supplier" data-izimodal-subtitle="Create new supplier's information">
				<div style="padding:15px;">
					<div class="alert alert-block alert-danger hidden"></div>
													
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="supplier_name"></label>
								<input type="text" class="form-control requiredsign" id="supplier_name" name="supplier_name" value="" placeholder="Supplier Name">
								<input type="hidden" id="supplier_id" name="supplier_id" value="" >
							</div>
							<div class="form-group">
								<label for="supplier_company"></label>
								<input type="text" class="form-control" id="supplier_company" name="supplier_company" value="" placeholder="Company Name">
							</div>
							<div class="form-group">
								<label for="supplier_contact"></label>
								<input type="text" class="form-control" id="supplier_contact" name="supplier_contact" value="" placeholder="Contact">
							</div>
							<div class="form-group">
								<label for="supplier_phone"></label>
								<input type="text" class="form-control requiredsign" id="supplier_phone" name="supplier_phone" value="" placeholder="Phone">
							</div>
							<div class="form-group">
								<label for="supplier_address"></label>
								<textarea class="form-control" id="supplier_address" name="supplier_address" placeholder="Address"></textarea>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="supplier_bank_name"></label>
								<input type="text" class="form-control" id="supplier_bank_name" name="supplier_bank_name" value="" placeholder="Bank Name">
							</div>
							<div class="form-group">
								<label for="supplier_bank_account"></label>
								<input type="text" class="form-control" id="supplier_bank_account" name="supplier_bank_account" value="" placeholder="Bank Account">
							</div>
							<div class="form-group">
								<label for="supplier_email"></label>
								<input type="email" class="form-control" id="supplier_email" name="supplier_email" value="" placeholder="E-Mail">
							</div>
							<div class="form-group">
								<label for="supplier_website"></label>
								<input type="text" class="form-control" id="supplier_website" name="supplier_website" value="" placeholder="Website">
							</div>
							<div class="form-group">
								<label for="supplier_desc"></label>
								<textarea class="form-control" id="supplier_desc" name="supplier_desc" placeholder="Description"></textarea>
							</div>
						</div>
					</div>
					
					<button class="btn-save button-modify" style="margin-bottom:15px;">Save</button>
				</div>
			</div>
			
			
			
											
		</div>
		<!-- End: container -->
		
		
		
		
		
		
		
		
		<!-- ================== Footer ================== -->
		<footer class="container-fluid text-center">
			<h6>Welcome to ${data.user.fullName}</h6>
			<p>© Copyright 2017. All Rights Reserved by Kamal</p>
		</footer>
		
		
		
		
		
		
		<script>
		
		
		function Confirm(form){
			alert("Record insert successfully!"); 
			form.submit();
		}
		
		function showMessage(data) {
			if (data.outcome='success') {
				swal("Records are saved!", data.message, "success");
				isDirty = false;
			} else {
				swal("Records were not saved", data.message, "error");
			}
		}
		
		//Tooltips
		$(document).ready(function(){
			$('[data-toggle="tooltip"]').tooltip();   
		});
		
		
		
		// ==================== DataTable ====================
		$(document).ready(function() {
			$('#SupplierTable').DataTable({
				"oLanguage" : {
					"sLengthMenu" : "Show _MENU_ Rows",
					"sSearch" : "",
					"sSearchWidth" : "300px",
					"sSearchPlaceholder": "Search records ....",
					"oPaginate" : {
						"sPrevious" : "<span class='fa fa-chevron-left'></span>",
						"sNext" : "<span class='fa fa-chevron-right'></span>"
					},
				},		
			});
		});
		
		// ==================== Add Row ====================
		$(document).on('click', '.btn-supplier-modal', function(event) {
			event.preventDefault();
			//ResetInputs("#SupplierTable");
			$("tr").removeClass("current-row");
			
			//Disable enter button
			$('html').bind('keypress', function(e) {
				if (e.keyCode == 13) {
					return false;
				}
			});
			$('#modal-supplier').iziModal('open');
		});
		//Add iziModal
		$('#modal-supplier').iziModal({
			headerColor: '#383838',
			width: '50%',
			overlayColor: 'rgba(0, 0, 0, 0.5)',
			fullscreen: true,
			transitionIn: 'comingIn',
			transitionOut: 'fadeOutDown',
			timeout: 10000,
			pauseOnHover: true,
			timeoutProgressbar: true,
		});
		
		// ==================== Save Row ====================
		$(".btn-save").on('click', function() {
				
			if ($(".current-row").length == 0) {
				$("#SupplierTable tbody").append('<tr class="current-row"></tr>');
			}
			
			var id = $("#supplier_id").val();
			var name = $("#supplier_name").val();
			var company = $("#supplier_company").val();
			var email = $("#supplier_email").val();
			var contact = $("#supplier_contact").val();
			var phone = $("#supplier_phone").val();
			var address = $("#supplier_address").val();
			var bank = $("#supplier_bank_name").val();
			var account = $("#supplier_bank_account").val();
			var website = $("#supplier_website").val();
			var description = $("#supplier_desc").val();
			
			var html = "" +
			'<td>' + name + '</td>' +
			'<td>' + address + '</td>' +
			'<td>' + contact + '</td>' +
			'<td>' + email + '</td>' +
			'<td>' + phone + '</td>' +
			'<td>' +
			'<input name="supplier_id[]" type="hidden" class="supplier-id" value="' + id + '"/>' +
			'<input name="supplier_name[]" type="hidden" class="supplier-name" value="' + name + '"/>' +
			'<input name="supplier_company[]" type="hidden" class="supplier-company" value="' + company + '"/>' +
			'<input name="supplier_email[]" type="hidden" class="supplier-email" value="' + email + '"/>' +
			'<input name="supplier_contact[]" type="hidden" class="supplier-contact" value="' + contact + '"/>' +
			'<input name="supplier_phone[]" type="hidden" class="supplier-phone" value="' + phone + '"/>' +
			'<input name="supplier_address[]" type="hidden" class="supplier-address" value="' + address + '"/>' +
			'<input name="supplier_bank_name[]" type="hidden" class="supplier-bank-name" value="' + bank + '"/>' +
			'<input name="supplier_bank_account[]" type="hidden" class="supplier-bank-account" value="' + account + '"/>' +
			'<input name="supplier_website[]" type="hidden" class="supplier-website" value="' + website + '"/>' +
			'<input name="supplier_desc[]" type="hidden" class="supplier-desc" value="' + description + '"/>' +

			'<button type="button" onclick="editRow(this)" class="btn btn-default btn-sm btn-edit"><span class="fa fa-edit"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this)" class="btn btn-default btn-sm btn-del open-alert"><span class="fa fa-trash"></span></button>' +
			'</td>';
			
			var table = $('#SupplierTable').dataTable().api();
			table.search( '' ).columns().search( '' ); //Clear search items
			table.row.add($("#SupplierTable tbody .current-row").html(html)).draw( false ).node();
			
			$("tr").removeClass("current-row");
			$('#modal-supplier').iziModal('close');
		});
		
		// ==================== Edit Row ====================
		function editRow(el) {
			var currentRow = $(el).closest("tr");		
			$("tr").removeClass("current-row");		
			currentRow.addClass("current-row");
			
			$("#supplier_id").val(currentRow.find(".supplier-id").val());
			$("#supplier_name").val(currentRow.find(".supplier-name").val());
			$("#supplier_company").val(currentRow.find(".supplier-company").val());
			$("#supplier_email").val(currentRow.find(".supplier-email").val());
			$("#supplier_contact").val(currentRow.find(".supplier-contact").val());
			$("#supplier_phone").val(currentRow.find(".supplier-phone").val());
			$("#supplier_address").val(currentRow.find(".supplier-address").val());
			$("#supplier_bank_name").val(currentRow.find(".supplier-bank-name").val());
			$("#supplier_bank_account").val(currentRow.find(".supplier-bank-account").val());
			$("#supplier_website").val(currentRow.find(".supplier-website").val());
			$("#supplier_desc").val(currentRow.find(".supplier-desc").val());
			
			$('#modal-supplier').iziModal('open');
		}
		
		
		// ==================== Delete Button ====================
		var delRow = function(el) {
			swal({
				title: "Are you sure?",
				text: "Are you sure to delete this record?",
				type: "warning",
				showCancelButton: true,
				confirmButtonClass: "btn-danger",
				confirmButtonText: "Yes, delete it!",
				closeOnConfirm: false
				},function(){
				var table = $("#SupplierTable").DataTable();
				table.row($(el).closest("tr")).remove().draw(); //OR $(el).closest('tr').remove(); //Remove row after deleted
				swal("Deleted!", "This record is deleted.", "success");
			});
		};
			
		</script>
		
		
		
		
	</body>
</html>