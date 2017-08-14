package edu.mum.apms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.UserRoleType;

public abstract class UserRoleDaoImpl implements JpaRepository<UserRole, Integer>  {

	@PersistenceContext
	private EntityManager session;
	

	

	
	
}
