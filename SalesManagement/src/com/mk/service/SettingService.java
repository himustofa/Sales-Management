package com.mk.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.dao.ISettingDAO;
import com.mk.dao.IUserDAO;
import com.mk.model.Setting;
import com.mk.model.User;

@Service("settingService")
public class SettingService implements ISettingService {

	@Autowired
	ISettingDAO settingDAO;

	@Autowired
	IUserDAO userDAO;

	@Override
	public Map<String, String> insert(Map<String, String[]> request) {
		
		Map<String, String> map = new HashMap<String, String>();
		//User currentUser = settingDAO.getCurrentUser();
		//String empCode = request.get("emp_code")[0];

		Setting setting = new Setting();
		
		if (request.get("company_name")[0] != null && !request.get("company_name")[0].isEmpty()) {
			setting.setCompnayName(request.get("company_name")[0]);
		}
		if (request.get("company_email")[0] != null && !request.get("company_email")[0].isEmpty()) {
			setting.setCompanyEmail(request.get("company_email")[0]);
		}
		if (request.get("company_phone")[0] != null && !request.get("company_phone")[0].isEmpty()) {
			setting.setCompanyPhoneNumber(request.get("company_phone")[0]);
		}
		if (request.get("company_address")[0] != null && !request.get("company_address")[0].isEmpty()) {
			setting.setCompanyAddress(request.get("company_address")[0]);
		}
		//setting.setLogoName(request.get("logo.jsp")[0]);
		//setting.setLogoData(request.get("exampleInputFile")[0]);
		
		
		if (request.get("timezone")[0] != null && !request.get("timezone")[0].isEmpty()) {
			setting.setTimeZone(request.get("timezone")[0]);
		}
		if (request.get("default_country")[0] != null && !request.get("default_country")[0].isEmpty()) {
			setting.setCountry(request.get("default_country")[0]);
		}
		if (request.get("date_format")[0] != null && !request.get("date_format")[0].isEmpty()) {
			setting.setDateFormat(request.get("date_format")[0]);
		}
		if (request.get("currency")[0] != null && !request.get("currency")[0].isEmpty()) {
			setting.setCurrencyFormat(request.get("currency")[0]);
		}
		
		
		
		if (request.get("user_id")[0] != null && !request.get("user_id")[0].isEmpty()) {
			Map<String, String> user = new HashMap<String, String>();
			user.put("user_id", request.get("user_id")[0]);
			user.put("username", request.get("username")[0]);
			user.put("password", request.get("password")[0]);
			int result = userDAO.updateDocById(user);
			System.err.println("Service User=======================================================" + result);
		}
		
		
		//setting.setUpdatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
		setting.setCreatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
		setting.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		UUID id = settingDAO.insertEntity(setting);
		
		System.err.println("Service Id=======================================================" + id);
		
		map.put("id", id.toString());
		
		return map;
	}
	
	@Override
	public List<Setting> getList() {
		return settingDAO.getList();
	}


}
