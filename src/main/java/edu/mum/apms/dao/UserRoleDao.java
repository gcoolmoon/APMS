package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.UserRoleType;


public interface UserRoleDao extends JpaRepository<UserRole, Integer> {

//	List<UserRole> findAll();
	
//	UserRole findByRole(UserRoleType role);
//	
//	UserRole findById(int id);
//	
//	List<UserRole> getUserRoles(String employeeId);
}
