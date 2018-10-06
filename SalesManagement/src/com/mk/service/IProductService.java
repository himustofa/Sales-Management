package com.mk.service;

import java.util.List;
import java.util.Map;

import com.mk.bean.WSResponse;
import com.mk.model.Product;

public interface IProductService {

	WSResponse manageRecord(Map<String, String[]> request);

	List<Product> getList(Map<String, String> map);

}
