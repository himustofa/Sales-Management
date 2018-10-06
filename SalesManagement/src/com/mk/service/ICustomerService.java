package com.mk.service;

import java.util.List;
import java.util.Map;

import com.mk.bean.WSResponse;
import com.mk.model.Customer;

public interface ICustomerService {

	WSResponse manageRecord(Map<String, String[]> request);

	List<Customer> getList(Map<String, String> map);

}
