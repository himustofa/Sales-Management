package com.mk.service;

import java.util.List;
import java.util.Map;

import com.mk.model.Setting;

public interface ISettingService {

	Map<String, String> insert(Map<String, String[]> request);

	List<Setting> getList();

}
