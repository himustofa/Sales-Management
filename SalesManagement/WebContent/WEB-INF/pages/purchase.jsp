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
				<h1>Purchases</h1>      
			</div>
			
			<!-- Add Button -->
			<button type="button" class="btn-purchase-modal btn btn-default btn-add"><span class="fa fa-plus"></span> Add</button>
			<br/>
			<br/>
			
			
			<form:form method="POST" class="ajax " name="form" data-handler="showMessage" data-validator="validate" action="save">
				
			<!-- ==============================================[ Customers ]============================================== -->
			<div class="row">
				
				<div class="col-md-12">
					<div class="table-responsive">
						
						<table data-order='[[ 3, "desc" ]]' class="table table-bordered" id="PurchaseTable">
							<thead>
								<tr style="background:#f1f1f1;">
									<th>Product</th>
									<th>Supplier</th>
									<th>Date</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Payment</th>
									<th>Due</th>
									<th data-orderable="false">Action</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${data.list}" var="purchase">
									<tr>
										<td>${purchase.productName}</td>
										<td>${purchase.supplierName}</td>
										<td>${purchase.purchaseDate}</td>
										<td>${purchase.purchaseProductQuantity}</td>
										<td>${purchase.purchaseProductPrice}</td>
										<td>${purchase.purchasePayment}</td>
										<td>${purchase.purchaseBalance}</td>
										<td>
											<input name="purchase_product_id[]" type="hidden" class="purchase-product-id" value="${purchase.productId}" />
											<input name="purchase_product_name[]" type="hidden" class="purchase-product-name" value="${purchase.productName}" />
											<input name="purchase_supplier_id[]" type="hidden" class="purchase-supplier-id" value="${purchase.supplierId}" />
											<input name="purchase_supplier_name[]" type="hidden" class="purchase-supplier-name" value="${purchase.supplierName}" />
											<input name="purchase_id[]" type="hidden" class="purchase-id" value="${purchase.id}" />
											<input name="purchase_date[]" type="hidden" class="purchase-date" value="${purchase.purchaseDate}" />
											<input name="purchase_product_quantity[]" type="hidden" class="purchase-product-quantity" value="${purchase.purchaseProductQuantity}" />
											<input name="purchase_product_price[]" type="hidden" class="purchase-product-price" value="${purchase.purchaseProductPrice}" />
											<input name="purchase_amount[]" type="hidden" class="purchase-amount" value="${purchase.purchaseAmount}" />
											<input name="purchase_payment[]" type="hidden" class="purchase-payment" value="${purchase.purchasePayment}" />
											<input name="purchase_balance[]" type="hidden" class="purchase-balance" value="${purchase.purchaseBalance}" />
											<input name="purchase_desc[]" type="hidden" class="purchase-desc" value="${purchase.purchaseDescription}" />
											
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
			
			<div id="modal-purchase" data-izimodal-group="" data-izimodal-loop="" data-izimodal-title="Purchase" data-izimodal-subtitle="Create new purchase's information">
				<div style="padding:15px;">
					<div class="alert alert-block alert-danger hidden"></div>
													
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="purchase_product"></label>
								<div class="input-group">
									<!-- <select id="purchase_product" class="requiredsign selectpicker show-tick" data-size="5">
										<option value="-1">Select Product</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31c">Ram</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31c">Processor</option>
									</select> -->
									<select id="purchase_product" class="requiredsign selectpicker show-tick" data-size="5">
										<option value="-1">Select Product</option>
										<c:forEach items="${data.productList}" var="list">
											<option value="${list.id}">${list.productName}</option>
										</c:forEach>
									</select>
								</div>
								<input type="hidden" id="purchase_product_id" name="purchase_product_id" value="">
								<input type="hidden" id="purchase_product_name" name="purchase_product_name" value="">
							</div>
							<div class="form-group">
								<label for="purchase_supplier"></label>
								<div class="input-group">
									<!-- <select id="purchase_supplier" class="requiredsign selectpicker show-tick" data-size="5">
										<option value="-1">Select Supplier</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31a">Mr. X</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31a">Mr. Y</option>
									</select> -->
									<select id="purchase_supplier" class="requiredsign selectpicker show-tick" data-size="5">
									  <option value="-1">Select Supplier</option>
									  <c:forEach items="${data.supplierList}" var="list">
									    <option value="${list.id}">${list.supplierName}</option>
									  </c:forEach>
									</select>
								</div>
								<input type="hidden" id="purchase_supplier_id" name="purchase_supplier_id" value="">
								<input type="hidden" id="purchase_supplier_name" name="purchase_supplier_name" value="">
							</div>
							<div class="form-group">
								<label for="purchase_date"></label>
								<input type="text" id="purchase_date" name="purchase_date" class="form-control modifydatepicker requiredsign" style="width:100%;" value="" placeholder="Purchase Date"/>
								<input type="hidden" id="purchase_id" name="purchase_id" value="">
								<span class="fa fa-calendar"></span>
							</div>
							<div class="form-group">
								<label for="purchase_desc"></label>
								<textarea class="form-control" id="purchase_desc" name="purchase_desc" placeholder="Description"></textarea>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="purchase_product_quantity"></label>
								<input type="text" class="form-control requiredsign" id="purchase_product_quantity" name="purchase_product_quantity" value="" placeholder="Quantity">
							</div>
							<div class="form-group">
								<label for="purchase_product_price"></label>
								<input type="text" class="form-control requiredsign" id="purchase_product_price" name="purchase_product_price" value="" placeholder="Price">
							</div>
							<div class="form-group">
								<label for="purchase_amount"></label>
								<input type="text" class="form-control" id="purchase_amount" name="purchase_amount" value="" placeholder="Total Amount">
							</div>
							<div class="form-group">
								<label for="purchase_payment"></label>
								<input type="text" class="form-control requiredsign" id="purchase_payment" name="purchase_payment" value="" placeholder="Total Payment">
							</div>
							<div class="form-group">
								<label for="purchase_balance"></label>
								<input type="text" class="form-control" id="purchase_balance" name="purchase_balance" value="" placeholder="Total Balance">
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
			$('#PurchaseTable').DataTable({
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
		$(document).on('click', '.btn-purchase-modal', function(event) {
			event.preventDefault();
			//ResetInputs("#PurchaseTable");
			$("tr").removeClass("current-row");
			
			//Disable enter button
			$('html').bind('keypress', function(e) {
				if (e.keyCode == 13) {
					return false;
				}
			});
			
			//==================== For Product & Supplier field ====================
			$('#purchase_product').on('change', function(){
				$("input[name='purchase_product_id']").val($("#purchase_product option:selected").val());
				$("input[name='purchase_product_name']").val($("#purchase_product option:selected").text());
			});
			
			$('#purchase_supplier').on('change', function(){
				$("input[name='purchase_supplier_id']").val($("#purchase_supplier option:selected").val());
				$("input[name='purchase_supplier_name']").val($("#purchase_supplier option:selected").text());
			});
			
			$('input[name="purchase_product_price"]').keyup(function() {
			    var a = $('input[name="purchase_product_quantity"]').val();
			    var b = $(this).val();
			    $('input[name="purchase_amount"]').val(a * b);
			});
			
			$('input[name="purchase_payment"]').keyup(function() {
			    var a = $('input[name="purchase_amount"]').val();
			    var b = $(this).val();
			    $('input[name="purchase_balance"]').val(a - b);
			});
			
			
			// Modify DatePicker
			$('.modifydatepicker').datepicker({
				format: 'dd-M-yyyy',
				//startDate: '-2m',
				endDate: new Date(),		//'+2d'
				autoclose: true,
				orientation: 'left',
			});
			
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth();
			var yyyy = today.getFullYear();	
			//$('#modal_start_date').val(dd+'-'+mm+'-'+yyyy);
			$('#product_expiredate').val(new Date().toString().split(' ').splice(1,3).join('-'));

			$('#modal-purchase').iziModal('open');
		});
		//Add iziModal
		$('#modal-purchase').iziModal({
			headerColor: '#383838',
			width: '50%',
			overlayColor: 'rgba(0, 0, 0, 0.5)',
			fullscreen: true,
			transitionIn: 'comingIn',
			transitionOut: 'fadeOutDown',
			//timeout: 10000,
			pauseOnHover: true,
			timeoutProgressbar: true,
		});
		
		// ==================== Save Row ====================
		$(".btn-save").on('click', function() {
				
			if ($(".current-row").length == 0) {
				$("#PurchaseTable tbody").append('<tr class="current-row"></tr>');
			}
										
			var pid = $("#purchase_product_id").val();
			var pname = $("#purchase_product_name").val();
			var sid = $("#purchase_supplier_id").val();
			var sname = $("#purchase_supplier_name").val();
			var id = $("#purchase_id").val();
			var date = $("#purchase_date").val();
			var quantity = $("#purchase_product_quantity").val();
			var price = $("#purchase_product_price").val();
			var amount = $("#purchase_amount").val();
			var payment = $("#purchase_payment").val();
			var balance = $("#purchase_balance").val();
			var description = $("#purchase_desc").val();

			
			var html = "" +
			'<td>' + pname + '</td>' +
			'<td>' + sname + '</td>' +
			'<td>' + date + '</td>' +
			'<td>' + quantity + '</td>' +
			'<td>' + price + '</td>' +
			'<td>' + payment + '</td>' +
			'<td>' +
			
			'<input name="purchase_product_id[]" type="hidden" class="purchase-product-id" value="' + pid + '" />'+
			'<input name="purchase_product_name[]" type="hidden" class="purchase-product-name" value="' + pname + '" />'+
			'<input name="purchase_supplier_id[]" type="hidden" class="purchase-supplier-id" value="' + sid + '" />'+
			'<input name="purchase_supplier_name[]" type="hidden" class="purchase-supplier-name" value="' + sname + '" />'+
			'<input name="purchase_id[]" type="hidden" class="purchase-id" value="' + id + '" />'+
			'<input name="purchase_date[]" type="hidden" class="purchase-date" value="' + date + '" />'+
			'<input name="purchase_product_quantity[]" type="hidden" class="purchase-product-quantity" value="'+ quantity +'" />'+
			'<input name="purchase_product_price[]" type="hidden" class="purchase-product-price" value="'+ price +'" />'+
			'<input name="purchase_amount[]" type="hidden" class="purchase-amount" value="' + amount + '" />'+
			'<input name="purchase_payment[]" type="hidden" class="purchase-payment" value="' + payment + '" />'+
			'<input name="purchase_balance[]" type="hidden" class="purchase-balance" value="' + balance + '" />'+
			'<input name="purchase_desc[]" type="hidden" class="purchase-desc" value="' + description + '" />'+

			'<button type="button" onclick="editRow(this)" class="btn btn-default btn-sm btn-edit"><span class="fa fa-edit"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this)" class="btn btn-default btn-sm btn-del open-alert"><span class="fa fa-trash"></span></button>' +
			'</td>';
			
			var table = $('#PurchaseTable').dataTable().api();
			table.search( '' ).columns().search( '' ); //Clear search items
			table.row.add($("#PurchaseTable tbody .current-row").html(html)).draw( false ).node();
			
			$("tr").removeClass("current-row");
			$('#modal-purchase').iziModal('close');
		});
		
		// ==================== Edit Row ====================
		function editRow(el) {
			var currentRow = $(el).closest("tr");		
			$("tr").removeClass("current-row");		
			currentRow.addClass("current-row");
			
			// Modify DatePicker
			$('.modifydatepicker').datepicker({
				format: 'dd-M-yyyy',
				//startDate: '-2m',
				//endDate: new Date(),		//'+2d'
				autoclose: true,
				orientation: 'left',
			});
			
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth();
			var yyyy = today.getFullYear();	
			//$('#modal_start_date').val(dd+'-'+mm+'-'+yyyy);
			//$('#product_expiredate').val(new Date().toString().split(' ').splice(1,3).join('-'));
			
			
			$('input[name="purchase_product_price"]').keyup(function() {
			    var a = $('input[name="purchase_product_quantity"]').val();
			    var b = $(this).val();
			    $('input[name="purchase_amount"]').val(a * b);
			});
			
			$('input[name="purchase_payment"]').keyup(function() {
			    var a = $('input[name="purchase_amount"]').val();
			    var b = $(this).val();
			    $('input[name="purchase_balance"]').val(a - b);
			});
			
			$("#purchase_product_id").val(currentRow.find(".purchase-product-id").val());
			$("#purchase_product_name").val(currentRow.find(".purchase-product-name").val());
			$("#purchase_supplier_id").val(currentRow.find(".purchase-supplier-id").val());
			$("#purchase_supplier_name").val(currentRow.find(".purchase-supplier-name").val());
			$("#purchase_id").val(currentRow.find(".purchase-id").val());
			$("#purchase_date").val(currentRow.find(".purchase-date").val());
			$("#purchase_product_quantity").val(currentRow.find(".purchase-product-quantity").val());
			$("#purchase_product_price").val(currentRow.find(".purchase-product-price").val());
			$("#purchase_amount").val(currentRow.find(".purchase-amount").val());
			$("#purchase_payment").val(currentRow.find(".purchase-payment").val());
			$("#purchase_balance").val(currentRow.find(".purchase-balance").val());
			$("#purchase_desc").val(currentRow.find(".purchase-desc").val());
			
			$("#modal-purchase .alert").addClass("hidden"); //Hide the modal alert when the edit modal appears
			$('#modal-purchase').iziModal('open');
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
				var table = $("#PurchaseTable").DataTable();
				table.row($(el).closest("tr")).remove().draw(); //OR $(el).closest('tr').remove(); //Remove row after deleted
				swal("Deleted!", "This record is deleted.", "success");
			});
		};
			
		</script>
		
		
		
		
	</body>
</html>