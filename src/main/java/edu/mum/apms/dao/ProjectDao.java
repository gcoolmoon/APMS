package edu.mum.apms.dao;

import edu.mum.apms.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project, Integer>{
}
