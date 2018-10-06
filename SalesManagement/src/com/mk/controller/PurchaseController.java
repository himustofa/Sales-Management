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
import com.mk.bean.WSResponse;
import com.mk.dao.IUserDAO;
import com.mk.model.Product;
import com.mk.model.Purchase;
import com.mk.model.Supplier;
import com.mk.model.User;
import com.mk.service.IPurchaseService;
import com.mk.service.IUserService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private IUserService userService;

	@Autowired
	IUserDAO userDAO;

	@Autowired
	IPurchaseService purchaseService;

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
		List<Purchase> list = purchaseService.getList(map);
		
		User user = userDAO.getUserList();
		List<Product> productList = purchaseService.getProductList(map);
		List<Supplier> supplierList = purchaseService.getSupplierList(map);

		GsonBuilder gBuilder = new GsonBuilder();
		Gson gson = gBuilder.create();
		System.err.println("Controller purchase==============" + gson.toJson(user));

		data.put("list", list);
		data.put("user", user);
		//data.put("username", username.getUsername());
		data.put("productList", productList);
		data.put("supplierList", supplierList);

		return new ModelAndView("purchase", "data", data);
	}

	/*****************************************
	 * Insert/Store
	 ******************************************/
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public WSResponse saveRecords(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		// System.out.println("Controller company code========" + request.getParameter("company_code"));
		WSResponse data = purchaseService.manageRecord(map);
		return data;
	}

}
