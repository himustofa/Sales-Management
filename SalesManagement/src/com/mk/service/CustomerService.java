package com.mk.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.bean.WSResponse;
import com.mk.dao.ICustomerDAO;
import com.mk.dao.IUserDAO;
import com.mk.model.Customer;

@Service("customerService")
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDAO customerDAO;

	@Autowired
	IUserDAO userDAO;

	/*****************************************
	 * Insert & Update & Delete
	 ******************************************/

	@Override
	public WSResponse manageRecord(Map<String, String[]> request) {

		String successMessage = "Saved successfully";
		String errorMessage = "Unsuccessful";

		UUID id = null;

		// User currentUser = userService.getCurrentUser();
		ArrayList<String> errors = this.validateRecord(request);
		System.out.println("Errors Service=======================================================" + errors.size());

		// String companyName = request.get("company_name")[0];
		// System.err.println("Service company name====" + companyName);

		String[] ids = (String[]) request.get("customer_id[]");
		String[] name = (String[]) request.get("customer_name[]");
		String[] phone = (String[]) request.get("customer_phone[]");
		String[] email = (String[]) request.get("customer_email[]");
		String[] contact = (String[]) request.get("customer_contact[]");
		String[] discount = (String[]) request.get("customer_discount[]");
		String[] address = (String[]) request.get("customer_address[]");
		String[] desc = (String[]) request.get("customer_desc[]");
		System.err.println("Service Education ID Array==============================================" + Arrays.toString(ids));
		// System.err.println("Service degrees====" + degrees.toString());

		if (errors.size() == 0) {
			Customer entity = new Customer();

			Map<String, Object> deleteEntityRequest = new HashMap<String, Object>();
			deleteEntityRequest.put("ids", ids);
			// deleteEntityRequest.put("empCode", request.get("emp_code")[0]);
			customerDAO.deleteEntities(deleteEntityRequest);

			for (int i = 0; name != null && i < name.length; i++) {
				if (ids[i] != null && !ids[i].equals("")) {
					entity = customerDAO.getEntityById(UUID.fromString(ids[i]));
					entity.setUpdatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				} else {
					entity = new Customer();
					entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
					entity.setCreatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				}

				entity.setCustomerName(name[i]);
				entity.setCustomerPhoneNumber(phone[i]);
				entity.setCustomerEmail(email[i]);
				entity.setCustomerContactPerson(contact[i]);
				if (discount[i] != null && !discount[i].isEmpty()) {
					entity.setCustomerDiscount(Double.parseDouble(discount[i]));
				}
				entity.setCustomerAddress(address[i]);
				entity.setCustomerDescription(desc[i]);

				id = customerDAO.updateEntity(entity);
			}
		}

		if (id != null) {
			return WSResponse.createSuccess(successMessage, null, null); // null = object/entity
		} else {
			return WSResponse.createFailure(errorMessage, errors.toArray(new String[errors.size()]));
		}

	}

	/*****************************************
	 * Server Side Validation
	 ******************************************/

	public ArrayList<String> validateRecord(Map<String, String[]> requestMap) {

		ArrayList<String> errors = new ArrayList<String>();

		/*if (Validation.isStrEmpty(requestMap.get("company_code")[0])) {
	        errors.add("Company Code should not be empty");
	    }
	    
	    String[] ids = (String[]) requestMap.get("education_id[]");
	    String[] degrees = (String[]) requestMap.get("degree[]");
		
		for (int i = 0; degrees != null && i < degrees.length; i++) {
	//		if (ids[i] != null && !ids[i].equals("")) {
				if (!degrees[i].matches("^[a-zA-Z0-9,.:;'!-_ ]{1,150}+$")) {
					errors.add("Degree should not be empty and length must be maximum 150 characters");
				}
	//		}
		}
		for (int i = 0; institute != null && i < institute.length; i++) {
			if (Validation.isValidLength(institute[i], 255)){
				errors.add("Institute length must be maximum 255 characters");
			}
		}*/


		return errors;
	}

	/*****************************************
	 * OTHER
	 ******************************************/

	@Override
	public List<Customer> getList(Map<String, String> map) {
		return customerDAO.getList(map);
	}

}
