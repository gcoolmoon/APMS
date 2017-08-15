package edu.mum.apms.service;

import java.util.List;

import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.UserRole;


public interface UserRoleService {

	public void add(UserRole userRole);
	public void edit(UserRole userRole);
	public void delete(int userRoleId);
	public UserRole get(int userRoleId);
	public List<UserRole> getAll();
	
}
