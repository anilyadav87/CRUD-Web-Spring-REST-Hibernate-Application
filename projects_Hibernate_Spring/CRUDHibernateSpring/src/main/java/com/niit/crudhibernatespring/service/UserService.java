package com.niit.crudhibernatespring.service;

import java.util.List;
import com.niit.crudhibernatespring.model.User;
public interface UserService {
	
	public boolean addUser (User user);
	
	public User getUserById (int userid);
	
	public List<User> getUserList();
	
	public boolean updateRecord(User user);
	
	public boolean deleteRecord(User user);
}
