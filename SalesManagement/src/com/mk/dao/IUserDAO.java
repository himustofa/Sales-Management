package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mk.model.User;

public interface IUserDAO {

	User getCurrentUser();

	String getCurrentUserName();

	User getByUserName(String username);

	User getByUsername(String username) throws UsernameNotFoundException;

	UUID deleteDoc(UUID id);

	UUID updateDoc(User doc);

	UUID insertDoc(User doc);

	List<User> getDocs(Map<String, String> params);

	User getDocById(UUID id);

	List<User> getAllDoc();

	User getUserList();

	int updateDocById(Map<String, String> user);

	boolean login(String username, String password) throws UsernameNotFoundException;

}
