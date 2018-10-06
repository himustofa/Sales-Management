package com.mk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mk.bean.WSResponse;
import com.mk.model.Award;
import com.mk.model.Education;
import com.mk.model.Experience;
import com.mk.service.IEmployeeRecordService;

@RestController
@RequestMapping("/employee")
public class EmployeeRecordController {
	
	@Autowired
	IEmployeeRecordService employeeRecordService;
	
	
	/****************************** INDEX/HOME ******************************/
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index() {
		return new ModelAndView("index");
	}*/
	
	/****************************** SHOW/GET/SELECT ******************************/
	@RequestMapping(value="/show", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE )
	public ModelAndView showRecords(HttpServletRequest request) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		String companyCode = request.getParameter("company_code");
		String companyName = request.getParameter("company_name");
		String empCode = request.getParameter("emp_code");
		String empName = request.getParameter("emp_name");
		
		if (companyCode == null && empCode == null) {
			companyCode = "MKL";
			empCode = "MK";
		}
		
		
		List<Education> empEduList = null;
		List<Award> empAwdList = null;
		List<Experience> empExpList = null;
		
		if(empCode != null){
			Map<String, String> searchingKey = new HashMap<String, String>();
			searchingKey.put("empCode", empCode);
			searchingKey.put("companyCode", companyCode);
			
			empEduList = employeeRecordService.getAllEmpEducation(searchingKey);
			empAwdList = employeeRecordService.getAllEmpAward(searchingKey);
			empExpList = employeeRecordService.getAllEmpExperience(searchingKey);
			
			data.put("empCode",  empCode);
			data.put("empName",  empName);
			
			System.err.println("Cotroller Employee code==============" + empCode);
			System.err.println("Cotroller Employee name==============" + empName);
			System.err.println("Cotroller Company code==============" + companyCode);
			System.err.println("Cotroller Company Name==============" + companyName);
			
			data.put("empEduList",  empEduList);
			data.put("empAwdList",  empAwdList);
			data.put("empExpList",  empExpList);
			
			GsonBuilder gBuilder = new GsonBuilder();
			Gson gson = gBuilder.create();
			
			System.err.println("Cotroller Employee Education==============" + gson.toJson(empEduList));
			System.err.println("Cotroller Employee Award==============" + gson.toJson(empAwdList));
			System.err.println("Cotroller Employee Experience==============" + gson.toJson(empExpList));
		}
		
		
		data.put("companyCode", companyCode);
		data.put("companyName",companyName);
		
		return new ModelAndView("officerecord", "data", data);
	}
	
	/***************************************** Insert/Store ******************************************/
	
	@RequestMapping(value="/save", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE )
	public WSResponse saveRecords(HttpServletRequest request) {
		Map<String, String[]> empFamily = request.getParameterMap();
		
		System.out.println("Controller company code========" + request.getParameter("company_code"));
		System.out.println("Controller company name========" + request.getParameter("company_name"));
		System.out.println("Controller emp code========" + request.getParameter("emp_code"));
		System.out.println("Controller emp name========" + request.getParameter("emp_name"));

//		System.out.println("Controller ID========" + request.getParameter("education_id[]"));
		
		WSResponse data = employeeRecordService.manageEmployeeOfficialRecord(empFamily);
		return data;
	}


}
