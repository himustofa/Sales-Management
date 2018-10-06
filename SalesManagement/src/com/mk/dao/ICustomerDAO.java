package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mk.model.Customer;

public interface ICustomerDAO {

	Customer getEntityById(UUID id);

	UUID updateEntity(Customer customer);

	List<Customer> getList(Map<String, String> map);

	int deleteEntities(Map<String, Object> request);

}
