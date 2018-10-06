package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mk.model.Product;

public interface IProductDAO {

	int deleteEntities(Map<String, Object> request);

	Product getEntityById(UUID id);

	UUID updateEntity(Product entity);

	List<Product> getList(Map<String, String> map);

}
