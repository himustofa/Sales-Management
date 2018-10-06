package com.mk.service;

import java.util.List;
import java.util.Map;

import com.mk.bean.WSResponse;
import com.mk.model.Customer;
import com.mk.model.Product;
import com.mk.model.Purchase;
import com.mk.model.Sale;

public interface ISaleService {

	WSResponse manageRecord(Map<String, String[]> request);

	List<Sale> getList(Map<String, String> map);

	List<Product> getProductList(Map<String, String> map);

	List<Customer> getCustomerList(Map<String, String> map);

	List<Purchase> getPurchaseList(Map<String, String> map);

}
