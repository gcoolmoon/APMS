package edu.mum.apms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.apms.dao.UserRoleDao;
import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.UserRoleType;



@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	UserRoleDao dao;
	
	public UserRole findById(int id) {
		return dao.findOne(id);
	}

//	public List<UserRole> findByRole(String role){
//		return dao.findByRole(role);
//	}

	public List<UserRole> findAll() {
		return dao.findAll();
	}
}
