package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mk.model.Supplier;

public interface ISupplierDAO {

	int deleteEntities(Map<String, Object> request);

	Supplier getEntityById(UUID id);

	UUID updateEntity(Supplier entity);

	List<Supplier> getList(Map<String, String> map);

}
