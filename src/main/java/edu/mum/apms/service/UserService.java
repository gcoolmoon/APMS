package edu.mum.apms.service;

import java.util.List;

import edu.mum.apms.model.User;



public interface UserService {
	
	User findById(int id);
	
	User findByEmployeeId(String empId);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByEmpId(String empId);

	List<User> findAllUsers(); 
	
	boolean isUserEmpIdUnique(Integer id, String empId);

}