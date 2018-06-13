package com.niit.crudhibernatespring.dao;
import java.util.*;

import com.niit.crudhibernatespring.model.User;

public interface UserDAO {
	
	public boolean addUser (User user);
	public User getUserById (int userid);
	public List<User> getUserList();
	public boolean updateRecord(User user);
	public boolean deleteRecord(User user);

}
