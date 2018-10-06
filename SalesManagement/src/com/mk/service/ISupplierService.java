package com.mk.service;

import java.util.List;
import java.util.Map;

import com.mk.bean.WSResponse;
import com.mk.model.Supplier;

public interface ISupplierService {

	WSResponse manageRecord(Map<String, String[]> request);

	List<Supplier> getList(Map<String, String> map);

}
