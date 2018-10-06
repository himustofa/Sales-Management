package com.mk.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.model.Customer;
import com.mk.model.User;

@Transactional
@Repository("userDAO")
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	@Override
	public List<User> getAllDoc() {
		Query query = sessionfactory.getCurrentSession().createQuery("From User");
		List<User> hrUsers = query.list();
		return hrUsers;
	}

	@Transactional
	@Override
	public User getDocById(UUID id) {
		Query query = sessionfactory.getCurrentSession().createQuery("From User WHERE id = :id");
		query.setParameter("id", id);
		List<User> hrUsers = query.list();
		return hrUsers.get(0);
	}

	@Transactional
	@Override
	public List<User> getDocs(Map<String, String> params) {
		Query query = sessionfactory.getCurrentSession().createQuery("From User where empCode like :empCode and " + "empName like :empName");
		query.setParameter("empCode", "%" + params.get("empCode") + "%");
		query.setParameter("empName", "%" + params.get("empName") + "%");

		List<User> userList = query.list();
		if (userList == null) {
			throw new UsernameNotFoundException("does not exist.");
		}
		return userList;
	}

	@Transactional
	@Override
	public UUID insertDoc(User doc) {
		UUID id = (UUID) sessionfactory.getCurrentSession().save(doc);
		sessionfactory.getCurrentSession().flush();
		return id;
	}

	@Transactional
	@Override
	public UUID updateDoc(User doc) {
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}

	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	// Get Details of Current User
	@Override
	public User getCurrentUser() {
		String currentUserName = this.getCurrentUserName();
		User userdetails = this.getByUsername(currentUserName);
		return userdetails;
	}

	// Get Name of Current User
	@Override
	public String getCurrentUserName() {
		String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		return currentUserName;
	}

	// Get Details according to userName
	@Override
	public User getByUsername(String username) throws UsernameNotFoundException {
		Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE username = :username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		if (user == null) {
			throw new UsernameNotFoundException("User with username '" + username + "' does not exist.");
		}
		return user;
	}

	@Transactional
	@Override
	public User getByUserName(String username) {
		Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE username = :username");
		query.setParameter("username", username);
		User userDetails = (User) query.uniqueResult();
		return userDetails;
	}
	
	/*****************************************
	 * OTHER
	 ******************************************/
	@Transactional
	@Override
	public User getUserList() {
		Query query = sessionfactory.getCurrentSession().createQuery("FROM User");
		List<User> list = query.list();
		if(list.size() > 0) {
			return list.get(0);
		} else {
			User user = new User();
			user.setFullName("Mustofa Kamal");
			user.setDesignation("Programmer");
			user.setEmail("mustofa2008@gmail.com");
			user.setPhoneNumber("+8801914141707");
			user.setAddress("Dhaka Cantonment, Bangladesh");
			user.setUsername("hikamal");
			user.setPassword("123456");
			user.setUserRole("admin");
			user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			return user;
		}
	}
	
	@Transactional
	@Override
	public int updateDocById(Map<String, String> user) {
		String hql = "UPDATE User set password = :password WHERE username = :username AND id = :id";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("password", user.get("password"));
		query.setParameter("username", user.get("username"));
		query.setParameter("id", user.get("id"));
		int result = query.executeUpdate();
		return result;
	}
	
	@Override
	public boolean login(String username, String password) throws UsernameNotFoundException {
		Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE username = :username AND password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		if (user == null) {
			System.err.println("=============User Login Failed");
			return false;
		} else {
			System.err.println("=============User Login Successfully");
			return true;
		}
	}
	
}
