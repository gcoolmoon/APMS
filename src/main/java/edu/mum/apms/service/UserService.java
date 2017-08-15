package edu.mum.apms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.apms.model.User;



public interface UserService {
	
	public void add(User user);
	public void edit(User user);
	public void delete(int userId);
	public User get(int userId);
	public List<User> getAll();
	public boolean checkPassword(int userId, String pass);

	public User checkPassword(String email, String pass);
//	User findById(int id);
//	
//	User findByEmployeeId(String empId);
//	
//	void saveUser(User user);
//	
//	void updateUser(User user);
//	
//	void deleteUserByEmpId(String empId);
//
//	List<User> findAllUsers(); 
//	
//	boolean isUserEmpIdUnique(Integer id, String empId);

}