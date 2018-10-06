package com.mk.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.bean.Utility;
import com.mk.model.Customer;

@Repository("customerDAO")
public class CustomerDAO implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public int deleteEntities(Map<String, Object> request) {
		String[] Ids = (String[]) request.get("ids");
		Query query;
		List<UUID> uuids = null;
		int i = 0;
		
		//System.err.println("DAO==============================================" + Arrays.toString(Ids));
		
		try {
			uuids = Utility.toUUID(Ids);

			if (uuids.size() == 0) {
				query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Customer");
			} else {
				query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Customer WHERE id NOT IN(:custIds)");
				query.setParameterList("custIds", uuids);
			}
			i = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	@Transactional
	public Customer getEntityById(UUID id) {
		Customer entity = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
		return entity;
	}

	@Override
	@Transactional
	public UUID updateEntity(Customer entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		return entity.getId();
	}

	@Override
	@Transactional
	public List<Customer> getList(Map<String, String> map) {
		// User currentUser = userDAO.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Customer");
		//query.setParameter("createdById", UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
		List<Customer> list = query.list();
		return list;
	}

}
