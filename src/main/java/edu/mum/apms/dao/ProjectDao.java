package edu.mum.apms.dao;

import edu.mum.apms.model.Project;
import edu.mum.apms.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDao extends JpaRepository<Project, Integer>{
	public List<Project> findByCreatedBy(User user);
}
