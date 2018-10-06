package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mk.model.Sale;

public interface ISaleDAO {

	int deleteEntities(Map<String, Object> request);

	Sale getEntityById(UUID id);

	UUID updateEntity(Sale entity);

	List<Sale> getList(Map<String, String> map);

}
