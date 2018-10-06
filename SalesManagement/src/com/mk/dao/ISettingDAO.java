package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mk.model.Setting;

public interface ISettingDAO {

	Setting getEntityById(UUID id);

	List<Setting> getList();

	UUID insertEntity(Setting entity);

	UUID updateEntity(Setting entity);

}
