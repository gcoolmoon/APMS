package edu.mum.apms.dao;

import java.util.List;

import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.UserRoleType;


public interface UserRoleDao {

	List<UserRole> findAll();
	
	UserRole findByRole(UserRoleType role);
	
	UserRole findById(int id);
	
	List<UserRole> getUserRoles(String employeeId);
}
