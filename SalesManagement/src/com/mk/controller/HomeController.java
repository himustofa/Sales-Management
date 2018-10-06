package com.mk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mk.dao.IUserDAO;
import com.mk.model.User;
import com.mk.service.IUserService;

@Controller
public class HomeController {

	@Autowired
	private IUserService userService;

	@Autowired
	IUserDAO userDAO;

	/****************************** INDEX/HOME ******************************/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView login() {
		return new ModelAndView("index");
	}

	/****************************** BODY ******************************/
	@RequestMapping(value = "/body", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView body(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") User user) {

		ModelAndView model = null;

		try {
			
			boolean isValidUser = userDAO.login(request.getParameter("user"), request.getParameter("password"));
			if (isValidUser == true) {
				request.setAttribute("username", request.getParameter("user"));
				model = new ModelAndView("body");
			} else {
				model = new ModelAndView("index");
				request.setAttribute("message", "Invalid credentials!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

}
