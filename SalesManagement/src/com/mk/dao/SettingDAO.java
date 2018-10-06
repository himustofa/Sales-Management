package com.mk.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.model.Setting;

@Repository("settingDAO")
public class SettingDAO implements ISettingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Setting getEntityById(UUID id) {
		Setting entity = (Setting) sessionFactory.getCurrentSession().get(Setting.class, id);
		return entity;
	}

	@Override
	@Transactional
	public List<Setting> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Setting");
		List<Setting> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public UUID insertEntity(Setting entity) {
		UUID id = (UUID) sessionFactory.getCurrentSession().save(entity);
		sessionFactory.getCurrentSession().flush();
		return id;
	}

	@Override
	@Transactional
	public UUID updateEntity(Setting entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		return entity.getId();
	}

}
