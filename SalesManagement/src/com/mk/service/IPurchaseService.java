package com.mk.service;

import java.util.List;
import java.util.Map;

import com.mk.bean.WSResponse;
import com.mk.model.Product;
import com.mk.model.Purchase;
import com.mk.model.Supplier;

public interface IPurchaseService {

	WSResponse manageRecord(Map<String, String[]> request);

	List<Purchase> getList(Map<String, String> map);

	List<Product> getProductList(Map<String, String> map);

	List<Supplier> getSupplierList(Map<String, String> map);

}
