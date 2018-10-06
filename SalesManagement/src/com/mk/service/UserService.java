package com.mk.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.dao.IUserDAO;
import com.mk.model.User;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	
	@Override
	public Map<String, String> insert(Map<String, String[]> request) {
		
		Map<String, String> map = new HashMap<String, String>();
		//User currentUser = userDAO.getCurrentUser();
		//String empCode = request.get("emp_code")[0];

		User user = new User();
		
		user.setFullName(request.get("fullname")[0]);
		user.setDesignation(request.get("designation")[0]);
		user.setEmail(request.get("user_email")[0]);
		user.setPhoneNumber(request.get("user_phone")[0]);
		user.setAddress(request.get("user_address")[0]);
		user.setUsername(request.get("username")[0]);
		user.setPassword(request.get("password")[0]);
		user.setUserRole(request.get("usertype")[0]);
		
		//user.setPhotoName("logo.jsp");
		//user.setPhotoData(null);
		
		//user.setUpdatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
		user.setCreatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
		user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		UUID id = userDAO.insertDoc(user);
		
		System.err.println("Service Id=======================================================" + id);
		
		map.put("id", id.toString());
		
		return map;
	}
	
	
}
