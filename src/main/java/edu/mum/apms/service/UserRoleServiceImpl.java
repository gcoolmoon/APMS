package edu.mum.apms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.apms.dao.UserRoleDao;
import edu.mum.apms.dao.UserRoleDao;
import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.UserRoleType;



@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	

	@Transactional
	public void add(UserRole user) {
		userRoleDao.save(user);
	}

	@Transactional
	public void edit(UserRole user) {
		userRoleDao.save(user);
	}

	@Transactional
	public void delete(int userId) {
		userRoleDao.delete(userId);
	}

	@Transactional
	public UserRole get(int userId) {
		return userRoleDao.findOne(userId);
	}

	@Transactional
	public List<UserRole> getAll() {
		return userRoleDao.findAll();
	}
}
