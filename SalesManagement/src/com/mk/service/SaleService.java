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
import com.mk.dao.IProductDAO;
import com.mk.dao.IPurchaseDAO;
import com.mk.dao.ISaleDAO;
import com.mk.dao.IUserDAO;
import com.mk.model.Customer;
import com.mk.model.Product;
import com.mk.model.Purchase;
import com.mk.model.Sale;
import com.mk.model.Supplier;

@Service("saleService")
public class SaleService implements ISaleService {

	@Autowired
	ISaleDAO saleDAO;

	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IProductDAO productDAO;
	
	@Autowired
	ICustomerDAO customerDAO;
	
	@Autowired
	IPurchaseDAO purchaseDAO;

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

		
		String[] productId = (String[]) request.get("sale_product_id[]");
		String[] productName = (String[]) request.get("sale_product_name[]");
		String[] productQuantity = (String[]) request.get("sale_product_quantity[]");
		String[] purchaseQuantity = (String[]) request.get("purchase_product_quantity[]");
		String[] customerId = (String[]) request.get("sale_customer_id[]");
		String[] customerName = (String[]) request.get("sale_customer_name[]");
		
		String[] ids = (String[]) request.get("sale_id[]");
		String[] saleDate = (String[]) request.get("sale_date[]");
		String[] saleDiscount = (String[]) request.get("sale_discount[]");
		String[] saleVat = (String[]) request.get("sale_vat[]");
		String[] saleAmount = (String[]) request.get("sale_amount[]");
		String[] salePayment = (String[]) request.get("sale_payment[]");
		String[] saleBalance = (String[]) request.get("sale_balance[]");
		String[] desc = (String[]) request.get("sale_desc[]");
		System.err.println("Service Education ID Array==============================================" + Arrays.toString(ids));
		// System.err.println("Service degrees====" + degrees.toString());

		if (errors.size() == 0) {
			Sale entity = new Sale();

			Map<String, Object> deleteEntityRequest = new HashMap<String, Object>();
			deleteEntityRequest.put("ids", ids);
			// deleteEntityRequest.put("empCode", request.get("emp_code")[0]);
			saleDAO.deleteEntities(deleteEntityRequest);

			for (int i = 0; productName != null && i < productName.length; i++) {
				if (ids[i] != null && !ids[i].equals("")) {
					entity = saleDAO.getEntityById(UUID.fromString(ids[i]));
					entity.setUpdatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				} else {
					entity = new Sale();
					entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
					entity.setCreatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				}

				
				if (productId[i] != null && !productId[i].isEmpty()) {
					entity.setProductId(UUID.fromString(productId[i]));
				}
				entity.setProductName(productName[i]);
				if (productQuantity[i] != null && !productQuantity[i].isEmpty()) {
					entity.setProductQuantity(Integer.parseInt(productQuantity[i]));
				}
				if (purchaseQuantity[i] != null && !purchaseQuantity[i].isEmpty()) {
					entity.setPurchaseProductQuantity(Integer.parseInt(purchaseQuantity[i]));
				}
				if (customerId[i] != null && !customerId[i].isEmpty()) {
					entity.setCustomerId(UUID.fromString(customerId[i]));
				}
				entity.setCustomerName(customerName[i]);
				entity.setSalesDate(saleDate[i]);
				if (saleDiscount[i] != null && !saleDiscount[i].isEmpty()) {
					entity.setSalesDiscount(Double.parseDouble(saleDiscount[i]));
				}
				if (saleVat[i] != null && !saleVat[i].isEmpty()) {
					entity.setSalesVat(Double.parseDouble(saleVat[i]));
				}
				if (saleAmount[i] != null && !saleAmount[i].isEmpty()) {
					entity.setSalesAmount(Double.parseDouble(saleAmount[i]));
				}
				if (salePayment[i] != null && !salePayment[i].isEmpty()) {
					entity.setSalesPayment(Double.parseDouble(salePayment[i]));
				}
				if (saleBalance[i] != null && !saleBalance[i].isEmpty()) {
					entity.setSalesBalance(Double.parseDouble(saleBalance[i]));
				}
				entity.setSalesDescription(desc[i]);
				
				

				id = saleDAO.updateEntity(entity);
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
	public List<Sale> getList(Map<String, String> map) {
		return saleDAO.getList(map);
	}

	@Override
	public List<Product> getProductList(Map<String, String> map) {
		return productDAO.getList(map);
	}
	
	@Override
	public List<Customer> getCustomerList(Map<String, String> map) {
		return customerDAO.getList(map);
	}
	
	@Override
	public List<Purchase> getPurchaseList(Map<String, String> map) {
		return purchaseDAO.getList(map);
	}

}
