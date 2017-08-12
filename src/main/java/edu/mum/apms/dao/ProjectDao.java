package edu.mum.apms.dao;

import edu.mum.apms.model.Project;
import java.util.List;

public interface ProjectDao {
	public void add(Project project);
	public void edit(Project project);
	public void delete(int projectId);
	public Project get(int projectId);
	public List<Project> getAll();
}
