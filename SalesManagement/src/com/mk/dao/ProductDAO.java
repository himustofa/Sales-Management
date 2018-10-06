package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.bean.Utility;
import com.mk.model.Product;

@Repository("productDAO")
public class ProductDAO implements IProductDAO {

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
				query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Product");
			} else {
				query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE id NOT IN(:suppIds)");
				query.setParameterList("suppIds", uuids);
			}
			i = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	@Transactional
	public Product getEntityById(UUID id) {
		Product entity = (Product) sessionFactory.getCurrentSession().get(Product.class, id);
		return entity;
	}

	@Override
	@Transactional
	public UUID updateEntity(Product entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		return entity.getId();
	}

	@Override
	@Transactional
	public List<Product> getList(Map<String, String> map) {
		// User currentUser = userDAO.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Product");
		//query.setParameter("createdById", UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
		List<Product> list = query.list();
		return list;
	}

}
