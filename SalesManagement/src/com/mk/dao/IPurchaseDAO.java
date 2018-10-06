package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mk.model.Purchase;

public interface IPurchaseDAO {

	int deleteEntities(Map<String, Object> request);

	Purchase getEntityById(UUID id);

	UUID updateEntity(Purchase entity);

	List<Purchase> getList(Map<String, String> map);

}
