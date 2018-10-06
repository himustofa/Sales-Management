package com.mk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mk.bean.WSResponse;
import com.mk.dao.IUserDAO;
import com.mk.model.User;
import com.mk.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	IUserDAO userDAO;

	/*****************************************
	 *	SHOW 
	 *****************************************/
	@RequestMapping(value = "/show", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView show(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		//User currentUser = userDAO.getCurrentUser();
		//User username = userDAO.getByUserName(request.getParameter("username"));
		User user = userDAO.getUserList();
		data.put("user", user);
		//data.put("username", username.getUsername());
		return new ModelAndView("user", "data", data);
	}

	/***************************************** 
	 *	INSERT/STORE
	 ******************************************/
	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		System.err.println("Controller fullname========" + request.getParameter("fullname"));
		Map<String, String> data = userService.insert(map);
		System.err.println("Controller========" + data.get("id"));
		if(data.get("id") == null){
			return "Saved Unsuccessfully";
		} else {
			return "Saved Successfully";
		}
	}*/
	
	/*****************************************
	 * Insert/Store
	 ******************************************/
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> saveRecords(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		// System.out.println("Controller company code========" + request.getParameter("company_code"));
		Map<String, String> data = userService.insert(map);
		return data;
	}
	

}
