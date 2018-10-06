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
import com.mk.dao.IProductDAO;
import com.mk.dao.IPurchaseDAO;
import com.mk.dao.ISupplierDAO;
import com.mk.dao.IUserDAO;
import com.mk.model.Product;
import com.mk.model.Purchase;
import com.mk.model.Supplier;

@Service("purchaseService")
public class PurchaseService implements IPurchaseService {

	@Autowired
	IPurchaseDAO purchaseDAO;

	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IProductDAO productDAO;
	
	@Autowired
	ISupplierDAO supplierDAO;

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

		String[] ids = (String[]) request.get("purchase_id[]");
		
		String[] productId = (String[]) request.get("purchase_product_id[]");
		String[] productName = (String[]) request.get("purchase_product_name[]");
		String[] supplierId = (String[]) request.get("purchase_supplier_id[]");
		String[] supplierName = (String[]) request.get("purchase_supplier_name[]");
		String[] date = (String[]) request.get("purchase_date[]");
		String[] quantity = (String[]) request.get("purchase_product_quantity[]");
		String[] price = (String[]) request.get("purchase_product_price[]");
		String[] amount = (String[]) request.get("purchase_amount[]");
		String[] payment = (String[]) request.get("purchase_payment[]");
		String[] balance = (String[]) request.get("purchase_balance[]");
		String[] desc = (String[]) request.get("purchase_desc[]");
		System.err.println("Service Education ID Array==============================================" + Arrays.toString(ids));
		// System.err.println("Service degrees====" + degrees.toString());

		if (errors.size() == 0) {
			Purchase entity = new Purchase();

			Map<String, Object> deleteEntityRequest = new HashMap<String, Object>();
			deleteEntityRequest.put("ids", ids);
			// deleteEntityRequest.put("empCode", request.get("emp_code")[0]);
			purchaseDAO.deleteEntities(deleteEntityRequest);

			for (int i = 0; productName != null && i < productName.length; i++) {
				if (ids[i] != null && !ids[i].equals("")) {
					entity = purchaseDAO.getEntityById(UUID.fromString(ids[i]));
					entity.setUpdatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				} else {
					entity = new Purchase();
					entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
					entity.setCreatedById(UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
				}

				if (productId[i] != null && !productId[i].isEmpty()) {
					entity.setProductId(UUID.fromString(productId[i]));
				}
				entity.setProductName(productName[i]);
				if (supplierId[i] != null && !supplierId[i].isEmpty()) {
					entity.setSupplierId(UUID.fromString(supplierId[i]));
				}
				entity.setSupplierName(supplierName[i]);
				entity.setPurchaseDate(date[i]);
				if (quantity[i] != null && !quantity[i].isEmpty()) {
					entity.setPurchaseProductQuantity(Integer.parseInt(quantity[i]));
				}
				if (price[i] != null && !price[i].isEmpty()) {
					entity.setPurchaseProductPrice(Double.parseDouble(price[i]));
				}
				if (amount[i] != null && !amount[i].isEmpty()) {
					entity.setPurchaseAmount(Double.parseDouble(amount[i]));
				}
				if (payment[i] != null && !payment[i].isEmpty()) {
					entity.setPurchasePayment(Double.parseDouble(payment[i]));
				}
				if (balance[i] != null && !balance[i].isEmpty()) {
					entity.setPurchaseBalance(Double.parseDouble(balance[i]));
				}
				entity.setPurchaseDescription(desc[i]);

				id = purchaseDAO.updateEntity(entity);
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
	public List<Purchase> getList(Map<String, String> map) {
		return purchaseDAO.getList(map);
	}
	
	@Override
	public List<Product> getProductList(Map<String, String> map) {
		return productDAO.getList(map);
	}
	
	@Override
	public List<Supplier> getSupplierList(Map<String, String> map) {
		return supplierDAO.getList(map);
	}

}
