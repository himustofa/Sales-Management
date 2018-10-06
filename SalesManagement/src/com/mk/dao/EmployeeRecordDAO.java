package com.mk.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.bean.Utility;
import com.mk.model.Award;
import com.mk.model.Education;
import com.mk.model.Experience;

@Repository("employeeRecordDAO")
public class EmployeeRecordDAO implements IEmployeeRecordDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	/*****************************************
	 * Employee Education
	 ******************************************/

	@Override
	@Transactional
	public int deleteEmployeeEducation(Map<String, Object> request) {
		String[] empEduIds = (String[]) request.get("ids");
		Query query;
		List<UUID> uuids = null;
		int i = 0;
		try {
			uuids = Utility.toUUID(empEduIds);

			if (uuids.size() == 0) {
				query = sessionFactory.getCurrentSession().createQuery(
						"delete from Education WHERE clientCode =:clientCode and companyCode =:companyCode and empCode =:empCode");
			} else {
				query = sessionFactory.getCurrentSession().createQuery(
						"delete from Education WHERE clientCode =:clientCode and companyCode =:companyCode and empCode =:empCode and id NOT IN(:empEduIds)");
				query.setParameterList("empEduIds", uuids);
			}
			query.setParameter("clientCode", "MK");
			query.setParameter("companyCode", request.get("companyCode"));
			query.setParameter("empCode", request.get("empCode"));
			i = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	@Transactional
	public Education getEmployeeEducationDocById(UUID id) {
		Education employeeEducation = (Education) sessionFactory.getCurrentSession().get(Education.class, id);
		return employeeEducation;
	}

	@Override
	@Transactional
	public UUID updateEmployeeEducationDoc(Education employeeEducation) {
		sessionFactory.getCurrentSession().saveOrUpdate(employeeEducation);
		sessionFactory.getCurrentSession().flush();
		return employeeEducation.getId();
	}

	@Override
	@Transactional
	public List<Education> getAllEmployeeEducationDoc(Map<String, String> params) {
		// User currentUser = userDAO.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Education WHERE clientCode =:clientCode and empCode =:empCode and companyCode=:companyCode");
		//query.setParameter("clientCode", params.get("clientCode"));
		query.setParameter("clientCode", "MK");
		query.setParameter("empCode", params.get("empCode"));
		query.setParameter("companyCode", params.get("companyCode"));
		List<Education> employeeEducationList = query.list();
		return employeeEducationList;
	}

	/*****************************************
	 * Employee Award
	 ******************************************/

	@Override
	@Transactional
	public int deleteEmployeeAward(Map<String, Object> request) {
		String[] awardId = (String[]) request.get("awardId");
		Query query;
		List<UUID> uuids = null;
		int i = 0;
		try {
			uuids = Utility.toUUID(awardId);

			if (uuids.size() == 0) {
				query = sessionFactory.getCurrentSession().createQuery(
						"delete from Award WHERE clientCode =:clientCode and companyCode =:companyCode and empCode =:empCode");
			} else {
				query = sessionFactory.getCurrentSession().createQuery(
						"delete from Award WHERE clientCode =:clientCode and companyCode =:companyCode and empCode =:empCode and id NOT IN(:empAwdIds)");
				query.setParameterList("empAwdIds", uuids);
			}
			query.setParameter("clientCode", "MK");
			query.setParameter("companyCode", request.get("companyCode"));
			query.setParameter("empCode", request.get("empCode"));
			i = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	@Transactional
	public Award getEmployeeAwardDocById(UUID id) {
		Award employeeAward = (Award) sessionFactory.getCurrentSession().get(Award.class, id);
		return employeeAward;
	}

	@Override
	@Transactional
	public UUID updateEmployeeAwardDoc(Award employeeAward) {
		sessionFactory.getCurrentSession().saveOrUpdate(employeeAward);
		sessionFactory.getCurrentSession().flush();
		return employeeAward.getId();
	}

	@Override
	@Transactional
	public List<Award> getAllEmployeeAwardDoc(Map<String, String> params) {
		System.out.println("Awd companyCode=======" + params.get("companyCode"));
		System.out.println("Awd empCode=======" + params.get("empCode"));

		// User currentUser = userDAO.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Award WHERE clientCode =:clientCode and empCode =:empCode and companyCode=:companyCode");
		query.setParameter("clientCode", "MK");
		query.setParameter("empCode", params.get("empCode"));
		query.setParameter("companyCode", params.get("companyCode"));
		List<Award> employeeAwardList = query.list();
		return employeeAwardList;
	}

	/*****************************************
	 * Employee Experience
	 ******************************************/

	@Override
	@Transactional
	public int deleteEmployeeExperience(Map<String, Object> request) {
		String[] experienceId = (String[]) request.get("experienceId");
		Query query;
		List<UUID> uuids = null;
		int i = 0;
		try {
			uuids = Utility.toUUID(experienceId);

			if (uuids.size() == 0) {
				query = sessionFactory.getCurrentSession().createQuery(
						"delete from Experience WHERE clientCode =:clientCode and companyCode =:companyCode and empCode =:empCode");
			} else {
				query = sessionFactory.getCurrentSession().createQuery(
						"delete from Experience WHERE clientCode =:clientCode and companyCode =:companyCode and empCode =:empCode and id NOT IN(:empExpIds)");
				query.setParameterList("empExpIds", uuids);
			}
			query.setParameter("clientCode", "MK");
			query.setParameter("companyCode", request.get("companyCode"));
			query.setParameter("empCode", request.get("empCode"));
			i = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	@Transactional
	public Experience getEmployeeExperienceDocById(UUID id) {
		Experience employeeExprience = (Experience) sessionFactory.getCurrentSession().get(Experience.class, id);
		return employeeExprience;
	}

	@Override
	@Transactional
	public UUID updateEmployeeExperienceDoc(Experience employeeExprience) {
		sessionFactory.getCurrentSession().saveOrUpdate(employeeExprience);
		sessionFactory.getCurrentSession().flush();
		return employeeExprience.getId();
	}

	@Override
	@Transactional
	public List<Experience> getAllEmployeeExperienceDoc(Map<String, String> params) {
		System.out.println("Exp companyCode=======" + params.get("companyCode"));
		System.out.println("Exp empCode=======" + params.get("empCode"));

		// User currentUser = userDAO.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Experience WHERE clientCode =:clientCode and empCode =:empCode and companyCode=:companyCode");
		query.setParameter("clientCode", "MK");
		query.setParameter("empCode", params.get("empCode"));
		query.setParameter("companyCode", params.get("companyCode"));
		List<Experience> employeeEducationList = query.list();
		return employeeEducationList;
	}

}
