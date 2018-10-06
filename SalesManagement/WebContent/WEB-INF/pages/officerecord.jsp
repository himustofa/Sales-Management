<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Update Personal Info for Official Records</title>
		
		
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
		
		
		
		<style>
			td {
			max-width:200px; word-wrap:break-word;
		    }
		    input.modifydatepicker, input.modifydatepicker:focus {
			background: #fff url(/assets/images/menu-date.png) no-repeat right 2px !important;
			cursor: pointer;
			}
			.col-md-auto { 
			width: auto; position:relative; float:left; min-height:1px; padding-right:0px;
			}
			.align-right {
			text-align: right;
			}
			.modal-header, .modal-footer{
			border-bottom:1px solid #bce8f1; background:#800080;
			}
			.modal-body{
			/*background: #F8F8F8;*/
			}
			body{
			background:#F8F8F8; background:#DDA0DD;
			}
			.table{
			background:#FFFFFF;
			}
			.fa-calendar {
				float:right; margin-right:10px; margin-top:-23px; position:relative; z-index:2;
			}
			.panel, .panel-group .panel-heading+.panel-collapse>.panel-body{
				border-top:none; border-bottom:1px solid #ddd; border-left:1px solid #ddd; border-right:1px solid #ddd;
			}
			.btn-primary{
			background:#800080;
			}
			
			/* -- Social Icon -- */
			.social-icon {
			cursor:pointer; color:white; font-size:20px;
			}
			.social-icon:hover {
			color:#55ACEE;
			}
			
			/*header and footer div*/
			#header{
			height:120px; width:100%; margin-bottom:-90px; background:#337AB7; background:#800080;
			}
			#footer{
			height:100px; width:100%; margin-top:40px; border-top:6px solid #d9edf7; padding-top:40px; background:#337AB7; background:#800080; 
			}
		</style>
		
	</head>
	<body>
		
		<div id="header"></div>
		
		
		<!-- Start: Employee -->
		<div class="container">
			
			<!-- Start: PAGE TITLE -->
			<div class="row" style="margin-bottom:30px;">
				<h2 style="color:white;">Update Personal Info for Official Records</h2>
				<ul class="list-inline">
					<li><a href="#">Human Resources</a></li>
					<li><a href="#">Employee Database</a></li>
					<li><a href="#">Data Entry and Processing</a></li>
					<li class="active"><a href="#">Employee</a></li>
				</ul>
			</div>
			<!-- End: PAGE TITLE -->
			
			<form:form method="POST" class="ajax " data-handler="showMessage" data-validator="validate" action="save">
			<%-- <cts:AjaxForm action="/save" dataHandler="showMessage"> --%>
				<div>
					
					<div class="alert alert-block alert-danger hidden main-alert"></div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="company">Company</label>
								<%-- <cts:Select list="${data.companyCodes}" name="company_code" value="${data.companyCode}" cssClass="sync-option-text required" /> --%>
								<div class="input-group">
									<select id="company" name="company" class="selectpicker show-tick" data-size="5">
										<option value="MKL">MK Enterprise Ltd.</option>
										<option value="OCL">Other Company Ltd.</option>
									</select>
								</div>
								<input type="hidden" id="company_code" name="company_code" value="">
								<input type="hidden" id="company_name" name="company_name" value="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="emp">Employee</label>
								<div class="input-group">
									<select id="emp" name="emp" class="selectpicker show-tick" data-size="5">
										<option value="MK">Mustofa Kamal</option>
										<option value="ZF">Zahra Fatima</option>
									</select>
								</div>
								<input type="hidden" id="emp_code" name="emp_code" value="">
								<input type="hidden" id="emp_name" name="emp_name" value="">
							</div>
						</div>
					</div>
					
					<br>
					
					
					<div class="row">
						
						<div class="tabbable">
							
							
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#panel_edu">Employee Education</a></li>
								<li><a data-toggle="tab" href="#panel_awd">Employee Award</a></li>
								<li><a data-toggle="tab" href="#panel_exp">Employee Experience</a></li>
							</ul>
							
							<div class="tab-content">
								
								<div id="panel_edu" class="tab-pane fade in active">
								
									<!-- Start: Bootstrap Panels -->
									<div class="panel-group">
										<div class="panel panel-info">
											<div class="panel-body">
												<!-- Start: Bootstrap Panels -->
									
												<!-- ==============================================[ EDUCATION ]============================================== -->
												<div class="row">
													
													<div style="margin-top:20px; margin-bottom:20px; margin-right:15px; float: right;">
														<button type="button" id="btnAddEmployeeEducation" class="btn btn-primary" data-toggle="modal" data-target="#EmployeeEducationModal" title="Add Education" data-toggle="tooltip"><span class="fa fa-plus"></span></button>
													</div>
													
													<div class="col-md-12">
														<div class="table-responsive">
															
															<table data-order='[[ 2, "desc" ]]' class="table table-bordered table-striped" id="EmployeeEducation">
																<thead>
																	<tr>
																		<th>Degree</th>
																		<th>Institute</th>
																		<th>Passing Year</th>
																		<th>Result</th>
																		<th>Education Type</th>
																		<th>Remark</th>
																		<th data-orderable="false">Action</th>
																	</tr>
																</thead>
																<tbody>
																	
																	<c:forEach items="${data.empEduList}" var="empEdu">
																		<c:if test="${empEdu.companyCode == data.companyCode}">
																			<tr>
																				<td>${empEdu.degree}</td>
																				<td>${empEdu.institute}</td>
																				<td>${empEdu.passingYear}</td>
																				<td>${empEdu.result}</td>
																				<td>${empEdu.educationType}</td>
																				<td>${empEdu.remark}</td>
																				<td>
																					<input name="education_id[]" type="hidden" class="education-id" value="${empEdu.getId()}" />
																					<input name="degree[]" type="hidden" class="degree-name" value="${empEdu.degree}" />
																					<input name="institute[]" type="hidden" class="institute-name" value="${empEdu.institute}" />
																					<input name="passing_year[]" type="hidden" class="passing-year" value="${empEdu.passingYear}" />
																					<input name="result[]" type="hidden" class="education-result" value="${empEdu.result}" />
																					<input name="education_type[]" type="hidden" class="education-type" value="${empEdu.educationType}" />
																					<input name="remark[]" type="hidden" class="remark" value="${empEdu.remark}" />
																					
																					<button type="button" onClick="editRowEdu(this)" class="btn-success btn btn-xs btn-edit-edu"><span class="fa fa-edit"></span></button>&nbsp;
																					<button type="button" onclick="delRowEdu(this)" class="btn-danger btn btn-xs"><span class="fa fa-trash"></span></button>
																				</td>
																			</tr>
																		</c:if>
																	</c:forEach>
																	
																</tbody>
															</table>
														</div>
													</div>
													
												</div>
									
									<!-- End: Bootstrap Panels -->
											</div>
										</div>
									</div>
									<!-- End: Bootstrap Panels -->
									
									<!-- ------------------/ Education Modal /------------------ -->
									<div id="EmployeeEducationModal" class="modal fade" role="dialog">
										<div class="modal-dialog modal-lg">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" id="btnModalclose">&times;</button>
													<h4 class="modal-title">Employee Education</h4>
												</div>
												<div class="modal-body">
													
													<div class="alert alert-block alert-danger hidden"></div>
													
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label for="modal_degree">Degree</label>
																<input type="text" class="form-control" id="modal_degree" name="modal_degree" value=""> <!-- maxlength="150" -->
																<input type="hidden" class="form-control" id="modal_education_id" name="modal_education_id" value="">
															</div>
															<div class="form-group">
																<label for="modal_institute">Institute</label>
																<input type="text" class="form-control" id="modal_institute" name="modal_institute" value=""> <!-- maxlength="255" -->
															</div>
															<div class="form-group">
																<label for="modal_passing_year">Passing Year</label>
																<!-- <select id="modal_passing_year" name="modal_passing_year" class="form-control required"></select> -->
																<div class="input-group">
																	<select id="modal_passing_year" name="modal_passing_year" class="selectpicker show-tick" data-size="10">
																	</select>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="modal_result">Result</label>
																<input type="text" class="form-control" id="modal_result" name="modal_result" value=""> <!-- maxlength="50" -->
															</div>
															<div class="form-group">
																<label for="modal_education_type">Education Type</label>
																<input type="text" class="form-control" id="modal_education_type" name="modal_education_type" value=""> <!-- maxlength="50" -->
															</div>
															<div class="form-group">
																<label for="modal_remark">Remarks</label>
																<input type="text" class="form-control" id="modal_remark" name="modal_remark" value=""> <!-- maxlength="255" -->
															</div>
														</div>
													</div>
													
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
													<button class="btn btn-default" id="btnOk" type="button"><span class="fa fa-check"></span>OK</button>
												</div>
											</div>
											
										</div>
									</div>
									<!-- ------------------/ END : Education Modal /------------------ -->
								</div><!-- END : Education Panel -->
								
								<div id="panel_awd" class="tab-pane fade">
									
									<!-- Start: Bootstrap Panels -->
									<div class="panel-group">
										<div class="panel panel-info">
											<div class="panel-body">
												<!-- Start: Bootstrap Panels -->
												
												<!-- ==============================================[ AWARD ]============================================== -->
												<div class="row">
													
													<div style="margin-top:20px; margin-bottom:20px; margin-right:15px; float: right;">
														<button type="button" id="btnAddEmployeeAward" class="btn btn-primary" data-toggle="modal" data-target="#EmployeeAwardModal" title="Add Award" data-toggle="tooltip"><span class="fa fa-plus"></span></button>
													</div>
													
													<div class="col-md-12">
														<div class="table-responsive">
															<table data-order='[[ 2, "desc" ]]' class="table table-bordered table-striped" id="EmployeeAward">
																<thead>
																	<tr>
																		<th>Award Name</th>
																		<th>Organization Name</th>
																		<th>Achievement Date</th>
																		<th data-orderable="false">Action</th>
																	</tr>
																</thead>
																<tbody>
																	
																	<c:forEach items="${data.empAwdList}" var="empAwd">
																		<c:if test="${empAwd.companyCode == data.companyCode}">
																			<tr>
																				<td>${empAwd.getAwardName()}</td>
																				<td>${empAwd.getOrganizationName()}</td>
																				<td>${empAwd.getAchievementDate()}</td>
																				<td>
																					<input name="award_id[]" type="hidden" class="award-id" value="${empAwd.getId()}"/>
																					<input name="award_name[]" type="hidden" class="award-name" value="${empAwd.getAwardName()}"/>
																					<input name="organization_name[]" type="hidden" class="organization-name" value="${empAwd.getOrganizationName()}"/>
																					<input name="achievement_date[]" type="hidden" class="achievement-date" value="${empAwd.getAchievementDate()}"/>
																					
																					<button type="button" onclick="editRowAwd(this)" class="btn-success btn btn-xs btn-edit-awd"><span class="fa fa-edit"></span></button>&nbsp;
																					<button type="button" onclick="delRowAwd(this)" class="btn-danger btn btn-xs"><span class="fa fa-trash"></span></button>
																				</td>
																			</tr>
																		</c:if>
																	</c:forEach>
																	
																</tbody>
															</table>
														</div>											 
													</div>	
													
												</div>
									
									<!-- End: Bootstrap Panels -->
											</div>
										</div>
									</div>
									<!-- End: Bootstrap Panels -->
									
									<!-- ------------------/ Award Modal /------------------ -->
									<div id="EmployeeAwardModal" class="modal fade" role="dialog">
										<div class="modal-dialog modal-lg">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" id="btnModalAwardClose">&times;</button>
													<h4 class="modal-title">Employee Award</h4>
												</div>
												<div class="modal-body">
													
													<div class="alert alert-block alert-danger hidden"></div>
													
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label for="modal_award_name">Award Name</label>
																<input type="text" class="form-control" id="modal_award_name" name="modal_award_name" value=""> <!-- maxlength="150" -->
																<input type="hidden" class="form-control" id="modal_award_id" name="modal_award_id" value="">
															</div>
															<div class="form-group">
																<label for="modal_organization_name">Organization Name</label>
																<input type="text" class="form-control" id="modal_organization_name" name="modal_organization_name" value=""> <!-- maxlength="255" -->
															</div>
															<div class="form-group">
																<label for="modal_achievement_date">Achievement Date</label>
																<input type="text" id="modal_achievement_date" name="modal_achievement_date" value="" class="form-control modifydatepicker " style="width:100%;"/>
																<span class="fa fa-calendar"></span>
															</div>
														</div>
													</div>
													
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
													<button class="btn btn-default" id="btnAwardOk" type="button"><span class="fa fa-check"></span>OK</button>
												</div>
											</div>
											
										</div>
									</div>
									<!-- ------------------/ END : Award Modal /------------------ -->
								</div> <!-- END : Award Panel -->
								
								<div id="panel_exp" class="tab-pane fade">
								
									<!-- Start: Bootstrap Panels -->
									<div class="panel-group">
										<div class="panel panel-info">
											<div class="panel-body">
												<!-- Start: Bootstrap Panels -->
												
												<!-- ==============================================[ EXPERIENCE ]============================================== -->
												<div class="row">
													
													<div style="margin-top:20px; margin-bottom:20px; margin-right:15px; float: right;">
														<button type="button" id="btnAddEmployeeExprience" class="btn btn-primary" data-toggle="modal" data-target="#EmployeeExprienceModal" title="Add Experience" data-toggle="tooltip"><span class="fa fa-plus"></span></button>
													</div>
													
													<div class="col-md-12">
														<div class="table-responsive">
															<table data-order='[[ 2, "desc" ]]' class="table table-bordered table-striped" id="EmployeeExprience">
																<thead>
																	<tr>
																		<th>Organization</th>
																		<th>Role</th>
																		<th>From</th>
																		<th>To</th>
																		<th>Remark</th>
																		<th data-orderable="false">Action</th>
																	</tr>
																</thead>
																<tbody>
																	
																	<c:forEach items="${data.empExpList}" var="empExp">
																		<c:if test="${empExp.companyCode == data.companyCode}">
																			<tr>
																				<td>${empExp.getOrginations()}</td>
																				<td>${empExp.getRole()}</td>
																				<td>${empExp.getStartDate()}</td>
																				<td>${empExp.getEndDate()}</td>
																				<td>${empExp.getRemark()}</td>
																				<td>
																					<input name="experience_id[]" type="hidden" class="experience-id" value="${empExp.getId()}"/>
																					<input name="org_name[]" type="hidden" class="org-name" value="${empExp.getOrginations()}"/>
																					<input name="role[]" type="hidden" class="role" value="${empExp.getRole()}"/>
																					<input name="start_date[]" type="hidden" class="start-date" value="${empExp.getStartDate()}"/>
																					<input name="end_date[]" type="hidden" class="end-date" value="${empExp.getEndDate()}"/>
																					<input name="remark_experience[]" type="hidden" class="remark-experience" value="${empExp.getRemark()}"/>
																					
																					<button type="button" onclick="editRowExp(this)" class="btn-success btn btn-xs btn-edit-exp"><span class="fa fa-edit"></span></button>&nbsp;
																					<button type="button" onclick="delRowExp(this)" class="btn-danger btn btn-xs"><span class="fa fa-trash"></span></button>
																				</td>
																			</tr>
																		</c:if>
																	</c:forEach>
																	
																</tbody>
															</table>
														</div>											 
													</div>			 
													
												</div>
									
									<!-- End: Bootstrap Panels -->
											</div>
										</div>
									</div>
									<!-- End: Bootstrap Panels -->
									
									<!-- ------------------/ Experience Modal /------------------ -->
									<div id="EmployeeExprienceModal" class="modal fade" role="dialog">
										<div class="modal-dialog modal-lg">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" id="btnModalExperienceclose">&times;</button>
													<h4 class="modal-title">Employee Experience</h4>
												</div>
												<div class="modal-body">
													
													<div class="alert alert-block alert-danger hidden"></div>
													
													
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label for="modal_org_name">Organization</label>
																<input type="text" class="form-control" id="modal_org_name" name="modal_org_name" value=""> <!-- readonly="readonly" --> <!-- maxlength="150" -->
																<input type="hidden" class="form-control" id="modal_experience_id" name="modal_experience_id" value="">
															</div>
															<div class="form-group">
																<label for="modal_role">Role</label>
																<input type="text" class="form-control" id="modal_role" name="modal_role" value=""> <!-- readonly="readonly" --> <!-- maxlength="200" -->
															</div>
															<div class="form-group">
																<table>
																	<thead>
																		<tr>
																			<th>From</th>
																			<th>To</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td><input type="text" id="modal_start_date" name="modal_start_date" value="" class="form-control modifydatepicker" style="width:100%;"/><span class="fa fa-calendar"></span></td>
																			<td><input type="text" id="modal_end_date" name="modal_end_date" value="" class="form-control modifydatepicker" style="width:100%;"/><span class="fa fa-calendar"></span></td>
																		</tr>
																	</tbody>
																</table>
															</div>		
															<div class="form-group">
																<label for="modal_remark_experience">Remarks</label>
																<input type="text" class="form-control" id="modal_remark_experience" name="modal_remark_experience" value="" /> <!-- maxlength="255" -->
															</div>
														</div>
													</div>
													
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
													<button class="btn btn-default" id="btnExpOk" type="button"><span class="fa fa-check"></span>OK</button>
												</div>
											</div>
											
										</div>
									</div>
									<!-- ------------------/ END : Experience Modal /------------------ -->
								</div><!-- END : Award Panel -->
								
							</div>	<!-- END : tab-content -->
							
							
						</div> <!-- End tabbable -->
						
					</div> <!-- End Row -->
					
					
					
					<div class="row" style="margin-top:30px;">
						<div class="col-md-auto">
							<!-- onclick="location.href='http://google.com';" -->
							<button type="button" class="btn btn-primary btn-lg" onclick="window.location.reload()" title="Refresh" data-toggle="tooltip"><span class="fa fa-refresh"></span> </button>
							<button type="button" class="btn btn-primary btn-lg" title="Help" onclick="window.open('http://google.com','_blank')" data-toggle="tooltip"><span class="fa fa-question"></span> </button>
						</div>
						<div class="align-right">
							<button type="submit" class="btn btn-primary btn-lg" onclick="submitMethod()">Save</button>
							<!-- <input type="button"  class="btn btn-primary" onclick="location.href='/show'" value="URL Button" > -->
						</div>
					</div>
					
				</div>
			
			 <%-- </cts:AjaxForm> --%>
			</form:form>
			
		</div>
		<!-- End: container | Employee -->
		
		<div id="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<p style="font-size: 12px; text-align:left; color: white;">© Copyright 2017. All Rights Reserved by Mustofa Kamal.</p>
					</div>
					<div class="col-md-4" style="text-align:center;">
						<i class="fa fa-facebook social-icon" aria-hidden="true"></i>
						<i class="fa fa-twitter social-icon" aria-hidden="true"></i>
						<i class="fa fa-youtube-play social-icon" aria-hidden="true"></i>
					</div>
					<div class="col-md-4">
						<p style="font-size: 12px; text-align:right; color: white;">Terms of Use | Legal Disclaimer | Privacy Policy</p>
					</div>
				</div>
			</div>
		</div>
		

		
		<script>
		
		//==================== Clear search box before submit ====================
		function submitMethod() {
			var table = $('#EmployeeEducation, #EmployeeAward, #EmployeeExprience').DataTable();
			table.search('').columns().search('').draw(false).node();
		}
			
		//==================== For company_name & emp_code field ====================
		$("input[name='company_name']").val($("#company option:selected").text());
		$("input[name='company_code']").val($("#company option:selected").val());
		$("input[name='emp_name']").val($("#emp option:selected").text());
		$("input[name='emp_code']").val($("#emp option:selected").val());
		
		$('#company').on('change', function(){
			$("input[name='company_name']").val($("#company option:selected").text());
			$("input[name='company_code']").val($("#company option:selected").val());
			
			//Load officerecord page
		    var url = 'show/?company_code=' + $("#company_code").val() + '&' + 'company_name=' + $("#company_name").val() + '&' + 'emp_code=' + $("#emp_code").val() + "&" + "emp_name=" + $("#emp_name").val();
			$.get(url);
		});
		
		$('#emp').on('change', function(){
			$("input[name='emp_name']").val($("#emp option:selected").text());
			$("input[name='emp_code']").val($("#emp option:selected").val());
			
			//Load officerecord page
		    var url = 'show/?company_code=' + $("#company_code").val() + '&' + 'company_name=' + $("#company_name").val() + '&' + 'emp_code=' + $("#emp_code").val() + "&" + "emp_name=" + $("#emp_name").val();
			$.get(url);
		});
		
		//==================== Successfully & Unsuccessfully ====================
		function showMessage(data) {
		    if (data.outcome == 'success') {	    	
		        //ShowSuccessMsg('Records are saved', data.message);
		        swal("Records are saved!", data.message, "success");
		        isDirty = false;
		        $(".alert").addClass("hidden");
		        
		        //Reload office page by submit save
		        LoadMainContent('show/?company_code=' + $("#company_code").val() + '&' + 'company_name=' + $("#company_name").val() + '&' + 'emp_code=' + $("#emp_code").val() + "&" + "emp_name=" + $("#emp_name").val());
		    } else {
		        //ShowErrorMsg('Records were not saved', data.message);
		        
		        swal("Records were not saved", data.message, "error");
		        
		        var errorsMessage = ConcatWithBR(data.error);
		        if(errorsMessage.length != 0){
		        	$(".main-alert").html(errorsMessage);
		            $(".main-alert").removeClass("hidden");
		        }
		    }
		}
		
		//==================== Passing year field ====================
		$(function() {
			var start_year = new Date().getFullYear();
			for (var i = start_year; i > start_year - 118; i--) {	//start_year + 118
				if (i == start_year) {
					$('#modal_passing_year').append('<option value="'+i+'" selected>' + i + '</option>');
					$("#modal_passing_year").selectpicker("refresh");
					} else {
					$('#modal_passing_year').append('<option value="' + i + '">' + i + '</option>');
					$("#modal_passing_year").selectpicker("refresh");
				}
			}
		});
		
		// ==================== DataTable ====================
		$(document).ready(function() {
			$('#EmployeeEducation, #EmployeeAward, #EmployeeExprience').DataTable({
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
		} );
		
		//==================== Modify DatePicker ====================
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
		$('#modal_start_date').val(new Date().toString().split(' ').splice(1,3).join('-'));
		$('#modal_achievement_date, #modal_end_date').val(new Date().toString().split(' ').splice(1,3).join('-'));
		
		//==================== Current Tab Active on Page Reload ====================
		/*$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
			localStorage.setItem('activeTab', $(e.target).attr('href'));
			});
			var activeTab = localStorage.getItem('activeTab');
			if(activeTab){
			$('#myTab a[href="' + activeTab + '"]').tab('show');
		}*/
		
		
		/**********************************************************[ EDUCATION ]***********************************************************/
			
		
		// ==================== Add Button ====================
		$("#btnAddEmployeeEducation").on("click", function() {
			ResetInputs("#EmployeeEducationModal");
			
			$("tr").removeClass("current-row");
			
			//Disable enter button
			$('html').bind('keypress', function(e) {
				if (e.keyCode == 13) {
					return false;
				}
			});
			
			$("#modal_degree, #modal_institute, #modal_passing_year, #modal_result, #modal_education_type, #modal_remark").attr("autocomplete", "off");
			$("#modal_degree").addClass("required");
			$("#modal_passing_year").addClass("required");
			
			$(".modal-title").text("Add Employee's Education"); //Title change after the click add
			$(".modal-body-education .alert").addClass("hidden"); //Initial modal alert hidden
			$("#EmployeeEducationModal").modal();
		});
		
		
		//==================== Modal Ok Button ====================
		$("#btnOk").on('click', function() {
			
			if ($(".current-row").length == 0) {
				$("#EmployeeEducation tbody").append('<tr class="current-row"></tr>');
			}
			
			var eduId = $("#modal_education_id").val();
			var degree = $("#modal_degree").val();
			var institute = $("#modal_institute").val();
			var passing_year = $("#modal_passing_year").val();
			var result = $("#modal_result").val();
			var education_type = $("#modal_education_type").val();
			var remark = $("#modal_remark").val();
			
			var html = "" +
			'<td>' + degree + '</td>' +
			'<td>' + institute + '</td>' +
			'<td>' + passing_year + '</td>' +
			'<td>' + result + '</td>' +
			'<td>' + education_type + '</td>' +
			'<td>' + remark + '</td>' +
			'<td>' +
				'<input name="education_id[]" type="hidden" class="education-id" value="' + eduId + '"/>' +
				'<input name="degree[]" type="hidden" class="degree-name" value="' + degree + '"/>' +
				'<input name="institute[]" type="hidden" class="institute-name" value="' + institute + '"/>' +
				'<input name="passing_year[]" type="hidden" class="passing-year" value="' + passing_year + '"/>' +
				'<input name="result[]" type="hidden" class="education-result" value="' + result + '"/>' +
				'<input name="education_type[]" type="hidden" class="education-type" value="' + education_type + '"/>' +
				'<input name="remark[]" type="hidden" class="remark" value="' + remark + '"/>' +
				
				'<button type="button" onClick="editRowEdu(this)" class="btn-success btn btn-xs btn-edit-edu"><span class="fa fa-edit"></span></button>&nbsp;' +
				'<button type="button" onclick="delRowEdu(this)" class="btn-danger btn btn-xs"><span class="fa fa-trash"></span></button>' +
			'</td>';
			
			var table = $('#EmployeeEducation').dataTable().api();
			table.search( '' ).columns().search( '' ); //Clear search items
			table.row.add($("#EmployeeEducation tbody .current-row").html(html)).draw( false ).node();
			
			$("tr").removeClass("current-row");
			$("#EmployeeEducationModal").modal("hide");
		});					
		
		
		// ==================== Edit Button ====================
		function editRowEdu(el) {
			
			var currentRow = $(el).closest("tr");		
			$("tr").removeClass("current-row");		
			currentRow.addClass("current-row");
			
			$("#modal_degree").addClass("required");
			$("#modal_passing_year").addClass("required");
			
			$("#modal_education_id").val(currentRow.find(".education-id").val());
			$("#modal_degree").val(currentRow.find(".degree-name").val());
			$("#modal_institute").val(currentRow.find(".institute-name").val());
			$("#modal_passing_year").val(currentRow.find(".passing-year").val());
			$("#modal_result").val(currentRow.find(".education-result").val());
			$("#modal_education_type").val(currentRow.find(".education-type").val());
			$("#modal_remark").val(currentRow.find(".remark").val());
			
			$(".modal-title").text("Edit Employee's Education"); //Title change after the click edit
			$(".modal-body-education .alert").addClass("hidden"); //Hide the modal alert when the edit modal appears
			$("#EmployeeEducationModal").modal();	
		}
		
		// ==================== Delete Button ====================
		var delRowEdu = function(el) {
			swal({
				title: "Are you sure?",
				text: "Are you sure to delete this record?",
				type: "warning",
				showCancelButton: true,
				confirmButtonClass: "btn-danger",
				confirmButtonText: "Yes, delete it!",
				closeOnConfirm: false
				},function(){
				var table = $("#EmployeeEducation").DataTable();
				table.row($(el).closest("tr")).remove().draw(); //OR $(el).closest('tr').remove(); //Remove row after deleted
				swal("Deleted!", "This record is deleted.", "success");
			});
		};
		
		
		/**********************************************************[ AWARD ]***********************************************************/
			
		// ==================== Add Button ====================
		$("#btnAddEmployeeAward").on("click", function() {
			ResetInputs("#EmployeeAwardModal");
			
			$("tr").removeClass("current-row-award");
			
			//Disable enter button
			$('html').bind('keypress', function(e) {
				if (e.keyCode == 13) {return false;}
			});
			
			$("#modal_award_name").addClass("required");
			$("#modal_organization_name").addClass("required");
			
			$("#modal_award_name, #modal_organization_name").attr("autocomplete", "off"); //Field level auto suggested text remove
			$("#modal_achievement_date").val("${data.currentDate}");
			$("#modal_organization_name").val("${data.companyName}"); //Initail Load Organization Value by Current User
			$(".modal-title-award").text("Add Employee's Award"); //Title change after the click add
			$(".modal-body-award .alert").addClass("hidden"); //Initial modal alert hidden
			
			$("#EmployeeAwardModal").modal();
		});
		
		// ==================== Modal Ok Button ====================
		$("#btnAwardOk").on('click', function() {
			if ($(".current-row-award").length == 0) {
				$("#EmployeeAward tbody").append('<tr class="current-row-award"></tr>');
			}
			
			var awdId = $("#modal_award_id").val();
			var awardName = $("#modal_award_name").val();
			var orgName = $("#modal_organization_name").val();
			var achiDate = $("#modal_achievement_date").val();
			
			var html = "" +
			'<td>' + awardName + '</td>' +
			'<td>' + orgName + '</td>' +
			'<td>' + achiDate + '</td>' +
			'<td>' +
				'<input name="award_id[]" type="hidden" class="award-id" value="' + awdId + '"/>' +
				'<input name="award_name[]" type="hidden" class="award-name" value="' + awardName + '"/>' +
				'<input name="organization_name[]" type="hidden" class="organization-name" value="' + orgName + '"/>' +
				'<input name="achievement_date[]" type="hidden" class="achievement-date" value="' + achiDate + '"/>' +
				
				'<button type="button" onclick="editRowAwd(this)" class="btn-success btn btn-xs btn-edit-awd"><span class="fa fa-edit"></span></button>&nbsp;' +
				'<button type="button" onclick="delRowAwd(this)" class="btn-danger btn btn-xs"><span class="fa fa-trash"></span></button>' +
			'</td>';
			
			var table = $('#EmployeeAward').dataTable().api();
			table.search( '' ).columns().search( '' ); //Clear search items
			table.row.add($("#EmployeeAward tbody .current-row-award").html(html)).draw( false ).node();
			
			$("tr").removeClass("current-row-award");
			$("#EmployeeAwardModal").modal("hide");
			
		});
		
		// ==================== Edit Button ====================
		function editRowAwd(el) {
			var currentRowAwd = $(el).closest("tr");		
			$("tr").removeClass("current-row-award");
			currentRowAwd.addClass("current-row-award");
			
			$("#modal_award_name").addClass("required");
			$("#modal_organization_name").addClass("required");
			
			$("#modal_award_id").val(currentRowAwd.find(".award-id").val());
			$("#modal_award_name").val(currentRowAwd.find(".award-name").val());
			$("#modal_organization_name").val(currentRowAwd.find(".organization-name").val());
			$("#modal_achievement_date").val(currentRowAwd.find(".achievement-date").val());
			
			$(".modal-title-award").text("Edit Employee's Award"); //Title change after the click edit
			$(".modal-body-award .alert").addClass("hidden"); //Hide the modal alert when the edit modal appears
			$("#EmployeeAwardModal").modal();
		}
		
		// ==================== Delete Button ====================
		var delRowAwd = function(el) {
			swal({
				title: "Are you sure?",
				text: "Are you sure to delete this record?",
				type: "warning",
				showCancelButton: true,
				confirmButtonClass: "btn-danger",
				confirmButtonText: "Yes, delete it!",
				closeOnConfirm: false
				},function(){
				var table = $("#EmployeeAward").DataTable();
				table.row($(el).closest("tr")).remove().draw(); //OR $(el).closest('tr').remove(); //Remove row after deleted
				swal("Deleted!", "This record is deleted.", "success");
			});
		};
		
		// ==================== Modal Close ====================
		$(".btn-cancel,#btnModalAwardClose").on("click", function() {
			$("tr").removeClass("current-row-award");
			$("#EmployeeAwardModal").modal("hide");
		});
		
		
		/**********************************************************[ EXPERIENCE ]***********************************************************/
			
		
		// ==================== Add Button ====================
		$("#btnAddEmployeeExprience").on("click", function() {
			ResetInputs("#EmployeeExprienceModal");
			
			$("tr").removeClass("current-row-experience");
			
			$("#modal_org_name").addClass("required");
			$("#modal_role").addClass("required");
			$("#modal_start_date").addClass("required");
			$("#modal_end_date").addClass("required");
			
			//Disable enter button
			$('html').bind('keypress', function(e) {
				if (e.keyCode == 13) {return false;}
			});
			
			$("#modal_org_name, #modal_role, #modal_remark_experience").attr("autocomplete", "off"); //Field level auto suggested text remove
			
			$('#modal_exprience_status').prop('checked', false); //Initial check-box is false
			$("#modal_start_date").val("${data.fromData}");
			$("#modal_end_date").val("${data.currentDate}");
			$("#modal_org_name").val("${data.companyName}");
			$("#modal_role").val("${data.desig}");
			$('#modal_org_name').prop('readonly', true);
			$('#modal_role').prop('readonly', true);
			
			$(".modal-title-experience").text("Add Employee's Experience"); //Title change after the click add
			$(".modal-body-experience .alert").addClass("hidden"); //Initial modal alert hidden
			
			$("#EmployeeExprienceModal").modal();
		});
		
		// ==================== Modal Ok Button ====================
		$("#btnExpOk").on('click', function() {
			if ($(".current-row-experience").length == 0) {
				$("#EmployeeExprience tbody").append('<tr class="current-row-experience"></tr>');
			}
			
			var expId = $("#modal_experience_id").val();
			var exprienceStatus = $("#modal_exprience_status").val();
			var orgName = $("#modal_org_name").val();
			var role = $("#modal_role").val();
			var startDate = $("#modal_start_date").val();
			var endDate = $("#modal_end_date").val();
			var remarkExp = $("#modal_remark_experience").val();
			
			var html = "" +
			'<td>' + orgName + '</td>' +
			'<td>' + role + '</td>' +
			'<td>' + startDate + '</td>' +
			'<td>' + endDate + '</td>' +
			'<td>' + remarkExp + '</td>' +
			'<td>' +
				'<input name="experience_id[]" type="hidden" class="experience-id" value="' + expId + '"/>' +
				'<input name="org_name[]" type="hidden" class="org-name" value="' + orgName + '"/>' +
				'<input name="role[]" type="hidden" class="role" value="' + role + '"/>' +
				'<input name="start_date[]" type="hidden" class="start-date" value="' + startDate + '"/>' +
				'<input name="end_date[]" type="hidden" class="end-date" value="' + endDate + '"/>' +
				'<input name="remark_experience[]" type="hidden" class="remark-experience" value="' + remarkExp + '"/>' +
				
				'<button type="button" onclick="editRowExp(this)" class="btn-success btn btn-xs btn-edit-exp"><span class="fa fa-edit"></span></button>&nbsp;' +
				'<button type="button" onclick="delRowExp(this)" class="btn-danger btn btn-xs"><span class="fa fa-trash"></span></button>' +
			'</td>';
			
			var table = $('#EmployeeExprience').dataTable().api();
			table.search( '' ).columns().search( '' ); //Clear search items
			table.row.add($("#EmployeeExprience tbody .current-row-experience").html(html)).draw( false ).node();
			
			$("tr").removeClass("current-row-experience");
			$("#EmployeeExprienceModal").modal("hide");
			
		});
		
		// ==================== Edit Button ====================
		function editRowExp(el) {
			var currentRowExp = $(el).closest("tr");
			$("tr").removeClass("current-row-experience");
			currentRowExp.addClass("current-row-experience");
			
			$('#modal_org_name').prop('readonly', false);
			$('#modal_role').prop('readonly', false);
			$("#modal_experience_id").val(currentRowExp.find(".experience-id").val());
			$("#modal_org_name").val(currentRowExp.find(".org-name").val());
			$("#modal_role").val(currentRowExp.find(".role").val());
			$("#modal_start_date").val(currentRowExp.find(".start-date").val());
			$("#modal_end_date").val(currentRowExp.find(".end-date").val());
			$("#modal_remark_experience").val(currentRowExp.find(".remark-experience").val());
			
			$(".modal-title-experience").text("Edit Employee's Experience"); //Title change after the click edit
			$(".modal-body-experience .alert").addClass("hidden"); //Hide the modal alert when the edit modal appears
			$("#EmployeeExprienceModal").modal();
		}
		
		// ==================== Delete Button ====================
		var delRowExp = function(el) {
			swal({
				title: "Are you sure?",
				text: "Are you sure to delete this record?",
				type: "warning",
				showCancelButton: true,
				confirmButtonClass: "btn-danger",
				confirmButtonText: "Yes, delete it!",
				closeOnConfirm: false
				},function(){
				var table = $("#EmployeeExprience").DataTable();
				table.row($(el).closest("tr")).remove().draw(); //OR $(el).closest('tr').remove(); //Remove row after deleted
				swal("Deleted!", "This record is deleted.", "success");
			});
		};
		
		// ==================== Modal Close ====================
		$(".btn-cancel,#btnModalExperienceclose").on("click", function() {
			$("tr").removeClass("current-row-experience");
			$("#EmployeeExprienceModal").modal("hide");
		});
		
		
		
		/**********************************************************[ Common ]***********************************************************/
		
		
		//==============================================================
		function ShowSuccessMsg(title, msg){
			swal({
				title: title,
				text: msg,
				type: "success",
				confirmButtonColor: "#007AFF"
			});
		}
		
		function ShowErrorMsg(title, msg){
			swal({
				title: title,
				text: msg,
				type: "error",
				confirmButtonColor: "#007AFF"
			}, function(){
				  swal("Deleted!", "Your imaginary file has been deleted.", "success");
			});
		}
		
		//==================================================================
			
		function LoadMainContent(url){
			var navigateAway = function(){
				mainContentUrl = url;
				$.ajax({
			        url: url,
			        success:function( response, status, xhr ) { 
			        	if(response.indexOf("<!DOCTYPE html>") != -1){
			        		window.location = url;
			        	} else {				        		
			        		$('.main-content').html(response);
			        	}
			        	
			    	}
			    });
				isDirty = false;
			};
			
			if(	isDirty ){
				swal({
					title: "Discard changes?",
					text: "Are you sure to navigate away?",
					type: "warning",
					showCancelButton: true,
					confirmButtonColor: "#007AFF",
					confirmButtonText: "Yes, discard changes!",
					closeOnConfirm: true
				}, navigateAway);
			} else {
				navigateAway();
			}
		}
		
		function ConcatWithBR(arr){ 
			if(!arr){
				return "";
			}
			var msg = "";
			for (var i = 0; i < arr.length; i++) {
				msg += arr[i] + '<br />';
			};
			return msg;
		}
		
		function MarkCross(selector, invalid){
			$(selector).find("span").remove();

			if (invalid) {
				$(selector).append('<span>&nbsp;&nbsp;</span><span class="text-red fa fa-close"></span>');
			} else {
				$(selector).append('<span>&nbsp;&nbsp;</span><span class="text-green fa fa-check"></span>');
			}
		}

				
		</script>
		
	</body>
</html>