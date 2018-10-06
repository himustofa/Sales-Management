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
import com.mk.model.Purchase;

@Repository("purchaseDAO")
public class PurchaseDAO implements IPurchaseDAO {

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
				query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Purchase");
			} else {
				query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Purchase WHERE id NOT IN(:suppIds)");
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
	public Purchase getEntityById(UUID id) {
		Purchase entity = (Purchase) sessionFactory.getCurrentSession().get(Purchase.class, id);
		return entity;
	}

	@Override
	@Transactional
	public UUID updateEntity(Purchase entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		return entity.getId();
	}

	@Override
	@Transactional
	public List<Purchase> getList(Map<String, String> map) {
		// User currentUser = userDAO.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Purchase");
		//query.setParameter("createdById", UUID.fromString("6eef02e0-04e0-4f14-a171-ceab238adcf4"));
		List<Purchase> list = query.list();
		return list;
	}

}
