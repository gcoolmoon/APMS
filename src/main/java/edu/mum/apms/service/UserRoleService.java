package edu.mum.apms.service;

import java.util.List;


import edu.mum.apms.model.UserRole;


public interface UserRoleService {

	UserRole findById(int id);

	//List<UserRole> findByRole(String role);
	
	List<UserRole> findAll();
	
}
