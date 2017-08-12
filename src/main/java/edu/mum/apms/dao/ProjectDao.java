package edu.mum.apms.dao;

import edu.mum.apms.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project, Integer>{
//	public void add(Project project);
//	public void edit(Project project);
//	public void delete(int projectId);
//	public Project findByProjectId(int projectId);
//	public List<Project> getAll();
}
