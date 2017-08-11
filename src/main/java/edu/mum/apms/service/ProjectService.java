package edu.mum.apms.service;

import java.util.List;
import edu.mum.apms.model.Project;

public interface ProjectService {
	public void add(Project project);
	public void edit(Project project);
	public void delete(int projectId);
	public Project get(int projectId);
	public List<Project> getAll();
}
