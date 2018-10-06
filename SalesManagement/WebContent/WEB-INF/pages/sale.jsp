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
				<h1>Sales</h1>      
			</div>
			
			<!-- Add Button -->
			<button type="button" class="btn-sale-modal btn btn-default btn-add"><span class="fa fa-plus"></span> Add</button>
			<br/>
			<br/>
			
			
			<form:form method="POST" class="ajax " name="form" data-handler="showMessage" data-validator="validate" action="save">
				
			<!-- ==============================================[ Customers ]============================================== -->
			<div class="row">
				
				<div class="col-md-12">
					<div class="table-responsive">
						
						<table data-order='[[ 2, "desc" ]]' class="table table-bordered" id="SaleTable">
							<thead>
								<tr style="background:#f1f1f1;">
									<th>Product</th>
									<th>Quantity</th>
									<th>Date</th>
									<th>Customer</th>
									<th>Discount</th>
									<th>Payment</th>
									<th>Due</th>
									<th data-orderable="false">Action</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${data.list}" var="sale">
									<tr>
										<td>${sale.productName}</td>
										<td>${sale.productQuantity}</td>
										<td>${sale.salesDate}</td>
										<td>${sale.customerName}</td>
										<td>${sale.salesDiscount}</td>
										<td>${sale.salesPayment}</td>
										<td>${sale.salesBalance}</td>
										<td>
											<input name="sale_product_id[]" type="hidden" class="sale-product-id" value="${sale.productId}" />
											<input name="sale_product_name[]" type="hidden" class="sale-product-name" value="${sale.productName}" />
											<input name="sale_product_quantity[]" type="hidden" class="sale-product-quantity" value="${sale.productQuantity}" />
											<input name="purchase_product_quantity[]" type="hidden" class="purchase-product-quantity" value="${sale.purchaseProductQuantity}" />
											<input name="sale_customer_id[]" type="hidden" class="sale-customer-id" value="${sale.customerId}" />
											<input name="sale_customer_name[]" type="hidden" class="sale-customer-name" value="${sale.customerName}" />
											<input name="sale_id[]" type="hidden" class="sale-id" value="${sale.id}" />
											<input name="sale_date[]" type="hidden" class="sale-date" value="${sale.salesDate}" />
											<input name="sale_discount[]" type="hidden" class="sale-discount" value="${sale.salesDiscount}" />
											<input name="sale_vat[]" type="hidden" class="sale-vat" value="${sale.salesVat}" />
											<input name="sale_amount[]" type="hidden" class="sale-amount" value="${sale.salesAmount}" />
											<input name="sale_payment[]" type="hidden" class="sale-payment" value="${sale.salesPayment}" />
											<input name="sale_balance[]" type="hidden" class="sale-balance" value="${sale.salesBalance}" />
											<input name="sale_desc[]" type="hidden" class="sale-desc" value="${sale.salesDescription}" />
											
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
			
			<div id="modal-sale" data-izimodal-group="" data-izimodal-loop="" data-izimodal-title="Sale" data-izimodal-subtitle="Create new sale's information">
				<div style="padding:15px;">
					<div class="alert alert-block alert-danger hidden"></div>
													
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="sale_product"></label>
								<div class="input-group">
									<!-- <select id="sale_product" class="requiredsign selectpicker show-tick" data-size="5">
										<option value="-1">Select Product</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31c">Ram</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31c">Processor</option>
									</select> -->
									<select id="sale_product" class="requiredsign selectpicker show-tick" data-size="5">
										<option value="-1">Select Product</option>
										<c:forEach items="${data.purchaseList}" var="list">
											<option value="${list.id}">${list.productName}</option>
										</c:forEach>
									</select>
								</div>
								<input type="hidden" id="sale_product_id" name="sale_product_id" value="">
								<input type="hidden" id="sale_product_name" name="sale_product_name" value="">
							</div>
							 <table>
							  <tr>
							    <td>
							    <div class="form-group">
									<label for="sale_product_quantity"></label>
									<input type="text" class="form-control requiredsign" id="sale_product_quantity" name="sale_product_quantity" value="" placeholder="Quantity">
								</div>
							    </td>
							    <td>
							    <div class="form-group">
									<label for="purchase_product_quantity"></label>
									<input type="text" class="form-control" id="purchase_product_quantity" name="purchase_product_quantity" value="" placeholder="Store" disabled>
									 <input type="hidden" id="purchase_product_price" name="purchase_product_price" value="purchase_product_price">
								</div>
								</td>
							  </tr>
							</table> 
							<div class="form-group">
								<label for="sale_customer"></label>
								<div class="input-group">
									<!-- <select id="sale_customer" class="selectpicker show-tick" data-size="5">
										<option value="-1">Select Customer</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31a">Mr. X</option>
										<option value="b8bf11d9-5956-4af6-a28a-c51327d5a31a">Mr. Y</option>
									</select> -->
									<select id="sale_customer" class="requiredsign selectpicker show-tick" data-size="5">
										<option value="-1">Select Customer</option>
										<c:forEach items="${data.customerList}" var="list">
											<option value="${list.id}">${list.customerName}</option>
										</c:forEach>
									</select>
								</div>
								<input type="hidden" id="sale_customer_id" name="sale_customer_id" value="">
								<input type="hidden" id="sale_customer_name" name="sale_customer_name" value="">
							</div>
							<div class="form-group">
								<label for="sale_date"></label>
								<input type="text" id="sale_date" name="sale_date" class="form-control modifydatepicker requiredsign" style="width:100%;" value="" placeholder="Sales Date"/>
								<input type="hidden" id="sale_id" name="sale_id" value="">
								<span class="fa fa-calendar"></span>
							</div>
							<div class="form-group">
								<label for="sale_desc"></label>
								<textarea class="form-control" id="sale_desc" name="sale_desc" placeholder="Description"></textarea>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="sale_discount"></label>
								<input type="text" class="form-control" id="sale_discount" name="sale_discount" value="" placeholder="Discount">
							</div>
							<div class="form-group">
								<label for="sale_vat"></label>
								<input type="text" class="form-control" id="sale_vat" name="sale_vat" value="" placeholder="VAT (%)">
							</div>
							<div class="form-group">
								<label for="sale_amount"></label>
								<input type="text" class="form-control" id="sale_amount" name="sale_amount" value="" placeholder="Total Amount">
							</div>
							<div class="form-group">
								<label for="sale_payment"></label>
								<input type="text" class="form-control requiredsign" id="sale_payment" name="sale_payment" value="" placeholder="Total Payment">
							</div>
							<div class="form-group">
								<label for="sale_balance"></label>
								<input type="text" class="form-control" id="sale_balance" name="sale_balance" value="" placeholder="Total Balance">
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
			$('#SaleTable').DataTable({
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
		$(document).on('click', '.btn-sale-modal', function(event) {
			event.preventDefault();
			//ResetInputs("#SaleTable");
			$("tr").removeClass("current-row");
			
			//Disable enter button
			$('html').bind('keypress', function(e) {
				if (e.keyCode == 13) {
					return false;
				}
			});
			
			
			//Product quantity and price from Purchase Table
			$('#sale_product').on('change', function(){
		    	var purchaseId = $("#sale_product option:selected").val();
		    	var purchaseList = JSON.parse('${data.purchaseListJson}');
		    	var purchaseListSize = '${data.purchaseListSize}';

		    	for (var i = 0; i < purchaseListSize; i++) {
			    	var id = purchaseList[i].id; //Model branchName
			    	if(purchaseId == id){
			    		var q = purchaseList[i].purchaseProductQuantity;
			    		var p = purchaseList[i].purchaseProductPrice;
			    		$("#purchase_product_quantity").val(q);
			    		$("#purchase_product_price").val(p);
			    	}
				}
		    });
			
			//Initial Sale Amount Price
			$('input[name="sale_product_quantity"]').keyup(function() {
			    var a = $('input[name="purchase_product_price"]').val();
			    var b = $(this).val();
			    $('input[name="sale_amount"]').val(a * b);
			});
			
			//Discount and Vat calculation
			$('input[name="sale_vat"]').keyup(function() {
				var quantity = $('input[name="sale_product_quantity"]').val();
				var price = $('input[name="purchase_product_price"]').val();
				var discount = $('input[name="sale_discount"]').val();
				var vat = $('input[name="sale_vat"]').val();
				var amount = $('input[name="sale_amount"]').val();
			    $('input[name="sale_amount"]').val( ((quantity * price) - discount) + ((((quantity * price) - discount) * vat) / 100) );
			});
			
			//Total Balance
			$('input[name="sale_payment"]').keyup(function() {
			    var a = $('input[name="sale_amount"]').val();
			    var b = $(this).val();
			    $('input[name="sale_balance"]').val(a - b);
			});
			
			//==================== For Product & Supplier field ====================
			$('#sale_product').on('change', function(){
				$("input[name='sale_product_id']").val($("#sale_product option:selected").val());
				$("input[name='sale_product_name']").val($("#sale_product option:selected").text());
			});
			
			
			$('#sale_customer').on('change', function(){
				$("input[name='sale_customer_id']").val($("#sale_customer option:selected").val());
				$("input[name='sale_customer_name']").val($("#sale_customer option:selected").text());
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
			
			//$("#modal_degree, #modal_institute").attr("autocomplete", "off");
			//$("#modal_degree").addClass("required");
			//$("#modal-sale .alert").addClass("hidden"); //Initial modal alert hidden
			$('#modal-sale').iziModal('open');
		});
		//Add iziModal
		$('#modal-sale').iziModal({
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
				$("#SaleTable tbody").append('<tr class="current-row"></tr>');
			}
										
			var pid = $("#sale_product_id").val();
			var pname = $("#sale_product_name").val();
			var quantity = $("#sale_product_quantity").val();
			var purchasequantity = $("#purchase_product_quantity").val();
			var sid = $("#sale_customer_id").val();
			var sname = $("#sale_customer_name").val();
			var id = $("#sale_id").val();
			var date = $("#sale_date").val();
			var discount = $("#sale_discount").val();
			var vat = $("#sale_vat").val();
			var amount = $("#sale_amount").val();
			var payment = $("#sale_payment").val();
			var balance = $("#sale_balance").val();
			var description = $("#sale_desc").val();
			
			var html = "" +
			'<td>' + pname + '</td>' +
			'<td>' + quantity + '</td>' +
			'<td>' + date + '</td>' +
			'<td>' + sname + '</td>' +
			'<td>' + discount + '</td>' +
			'<td>' + amount + '</td>' +
			'<td>' +

			'<input name="sale_product_id[]" type="hidden" class="sale-product-id" value="' + pid + '" />'+
			'<input name="sale_product_name[]" type="hidden" class="sale-product-name" value="' + pname + '" />'+
			'<input name="sale_product_quantity[]" type="hidden" class="sale-product-quantity" value="' + quantity + '" />'+
			'<input name="purchase_product_quantity[]" type="hidden" class="purchase-product-quantity" value="' + purchasequantity + '" />'+
			'<input name="sale_customer_id[]" type="hidden" class="sale-customer-id" value="' + sid + '" />'+
			'<input name="sale_customer_name[]" type="hidden" class="sale-customer-name" value="' + sname + '" />'+
			'<input name="sale_id[]" type="hidden" class="sale-id" value="' + id + '" />'+
			'<input name="sale_date[]" type="hidden" class="sale-date" value="' + date + '" />'+
			'<input name="sale_discount[]" type="hidden" class="sale-discount" value="' + discount + '" />'+
			'<input name="sale_vat[]" type="hidden" class="sale-vat" value="' + vat + '" />'+
			'<input name="sale_amount[]" type="hidden" class="sale-amount" value="' + amount + '" />'+
			'<input name="sale_payment[]" type="hidden" class="sale-payment" value="' + payment + '" />'+
			'<input name="sale_balance[]" type="hidden" class="sale-balance" value="' + balance + '" />'+
			'<input name="sale_desc[]" type="hidden" class="sale-desc" value="' + description + '" />'+

			'<button type="button" onclick="editRow(this)" class="btn btn-default btn-sm btn-edit"><span class="fa fa-edit"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this)" class="btn btn-default btn-sm btn-del open-alert"><span class="fa fa-trash"></span></button>' +
			'</td>';
			
			var table = $('#SaleTable').dataTable().api();
			table.search( '' ).columns().search( '' ); //Clear search items
			table.row.add($("#SaleTable tbody .current-row").html(html)).draw( false ).node();
			
			$("tr").removeClass("current-row");
			$('#modal-sale').iziModal('close');
		});
		
		// ==================== Edit Row ====================
		function editRow(el) {
			var currentRow = $(el).closest("tr");		
			$("tr").removeClass("current-row");		
			currentRow.addClass("current-row");
			
			//$("#modal_degree").addClass("required");
			
			
			$('#sale_product').on('change', function(){
		    	var purchaseId = $("#sale_product option:selected").val();
		    	var purchaseList = JSON.parse('${data.purchaseListJson}');
		    	var purchaseListSize = '${data.purchaseListSize}';

		    	for (var i = 0; i < purchaseListSize; i++) {
			    	var id = purchaseList[i].id; //Model branchName
			    	if(purchaseId == id){
			    		var q = purchaseList[i].purchaseProductQuantity;
			    		var p = purchaseList[i].purchaseProductPrice;
			    		$("#purchase_product_quantity").val(q);
			    		$("#purchase_product_price").val(p);
			    	}
				}
		    });
			
			$('input[name="sale_product_quantity"]').keyup(function() {
			    var a = $('input[name="purchase_product_price"]').val();
			    var b = $(this).val();
			    $('input[name="sale_amount"]').val(a * b);
			});
			
			//Discount and Vat calculation
			$('input[name="sale_vat"]').keyup(function() {
				var quantity = $('input[name="sale_product_quantity"]').val();
				var price = $('input[name="purchase_product_price"]').val();
				var discount = $('input[name="sale_discount"]').val();
				var vat = $('input[name="sale_vat"]').val();
				var amount = $('input[name="sale_amount"]').val();
			    $('input[name="sale_amount"]').val( ((quantity * price) - discount) + ((((quantity * price) - discount) * vat) / 100) );
			});
			
			//Total Balance
			$('input[name="sale_payment"]').keyup(function() {
			    var a = $('input[name="sale_amount"]').val();
			    var b = $(this).val();
			    $('input[name="sale_balance"]').val(a - b);
			});
			
			$("#sale_product_id").val(currentRow.find(".sale-product-id").val());
			$("#sale_product_name").val(currentRow.find(".sale-product-name").val());
			$("#sale_product_quantity").val(currentRow.find(".sale-product-quantity").val());
			$("#purchase_product_quantity").val(currentRow.find(".purchase-product-quantity").val());
			$("#sale_customer_id").val(currentRow.find(".sale-customer-id").val());
			$("#sale_customer_name").val(currentRow.find(".sale-customer-name").val());
			$("#sale_id").val(currentRow.find(".sale-id").val());
			$("#sale_date").val(currentRow.find(".sale-date").val());
			$("#sale_discount").val(currentRow.find(".sale-discount").val());
			$("#sale_vat").val(currentRow.find(".sale-vat").val());
			$("#sale_amount").val(currentRow.find(".sale-amount").val());
			$("#sale_payment").val(currentRow.find(".sale-payment").val());
			$("#sale_balance").val(currentRow.find(".sale-balance").val());
			$("#sale_desc").val(currentRow.find(".sale-desc").val());
			
			$("#modal-sale .alert").addClass("hidden"); //Hide the modal alert when the edit modal appears
			$('#modal-sale').iziModal('open');
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
				var table = $("#SaleTable").DataTable();
				table.row($(el).closest("tr")).remove().draw(); //OR $(el).closest('tr').remove(); //Remove row after deleted
				swal("Deleted!", "This record is deleted.", "success");
			});
		};
			
		</script>
		
		
		
		
	</body>
</html>