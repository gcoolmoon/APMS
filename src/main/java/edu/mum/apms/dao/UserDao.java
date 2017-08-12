package edu.mum.apms.dao;

import java.util.List;

import edu.mum.apms.model.User;
import edu.mum.apms.model.UserRoleType;



public interface UserDao {

	User findById(int id);
	
	User findByEmpId(String empId);
	
	void save(User user);
	
	void deleteByEmpId(String empId);
	
	boolean addRole(String empId, UserRoleType role);
	
	List<User> findAllUsers();

}

