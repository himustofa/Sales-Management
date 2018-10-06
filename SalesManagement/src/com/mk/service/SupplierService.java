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
import com.mk.dao.ISupplierDAO;
import com.mk.dao.IUserDAO;
import com.mk.model.Supplier;

@Service("supplierService")
public class SupplierService implements ISupplierService {

	@Autowired
	ISupplierDAO supplierDAO;

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

		String[] ids = (String[]) request.get("supplier_id[]");
		String[] name = (String[]) request.get("supplier_name[]");
		String[] company = (String[]) request.get("supplier_company[]");
		String[] email = (String[]) request.get("supplier_email[]");
		String[] contact = (String[]) request.get("supplier_contact[]");
		String[] phone = (String[]) request.get("supplier_phone[]");
		String[] address = (String[]) request.get("supplier_address[]");
		String[] bank = (String[]) request.get("supplier_bank_name[]");
		String[] account = (String[]) request.get("supplier_bank_account[]");
		String[] website = (String[]) request.get("supplier_website[]");
		String[] desc = (String[]) request.get("supplier_desc[]");
		System.err.println("Service Education ID Array==============================================" + Arrays.toString(ids));
		// System.err.println("Service degrees====" + degrees.toString());

		if (errors.size() == 0) {
			Supplier entity = new Supplier();

			Map<String, Object> deleteEntityRequest = new HashMap<String, Object>();
			deleteEntityRequest.put("ids", ids);
			// deleteEntityRequest.put("empCode", request.get("emp_code")[0]);
			supplierDAO.deleteEntities(deleteEntityRequest);

			for (int i = 0; name != null && i < name.length; i++) {
				if (ids[i] != null && !ids[i].equals("")) {
					entity = supplierDAO.getEntityById(UUID.fromString(ids[i]));
					entity.setUpdatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				} else {
					entity = new Supplier();
					entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
					entity.setCreatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				}

				entity.setSupplierName(name[i]);
				entity.setSupplierCompanyName(company[i]);
				entity.setSupplierEmail(email[i]);
				entity.setSupplierContactPerson(contact[i]);
				entity.setSupplierPhoneNumber(phone[i]);
				entity.setSupplierAddress(address[i]);
				entity.setSupplierBankName(bank[i]);
				entity.setSupplierBankAccount(account[i]);
				entity.setSupplierWebsite(website[i]);
				entity.setSupplierDescription(desc[i]);

				id = supplierDAO.updateEntity(entity);
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
	public List<Supplier> getList(Map<String, String> map) {
		return supplierDAO.getList(map);
	}

}
