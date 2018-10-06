package com.mk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mk.dao.IUserDAO;
import com.mk.model.Setting;
import com.mk.model.User;
import com.mk.service.ISettingService;
import com.mk.service.IUserService;

@RestController
@RequestMapping("/setting")
public class SettingController {
	
	@Autowired
	private IUserService userService;

	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	private ISettingService settingService;
	
	/****************************** 
	 * Show 
	 *******************************/
	@RequestMapping(value = "/show", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showRecords(HttpServletRequest request) {

		Map<String, Object> data = new HashMap<String, Object>();
		
		//User username = userDAO.getByUserName(request.getParameter("username"));

		Map<String, String> map = new HashMap<String, String>();
		//map.put("companyCode", request.getParameter("company_code"));
		//map.put("createdById", username.getId().toString());
		List<Setting> list = settingService.getList();
		
		User user = userDAO.getUserList();
		List<User> userList = userDAO.getAllDoc();

		GsonBuilder gBuilder = new GsonBuilder();
		Gson gson = gBuilder.create();
		System.err.println("Controller setting==============" + gson.toJson(user));

		data.put("list", list);
		data.put("user", user);
		//data.put("username", username.getUsername());
		data.put("userList", userList);

		return new ModelAndView("setting", "data", data);
	}

	/*****************************************
	 * Insert/Store
	 ******************************************/
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> saveRecords(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		// System.out.println("Controller company code========" + request.getParameter("company_code"));
		Map<String, String> data = settingService.insert(map);
		return data;
	}

}
