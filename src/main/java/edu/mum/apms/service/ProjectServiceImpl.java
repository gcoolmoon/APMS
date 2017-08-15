package edu.mum.apms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.apms.dao.ProjectDao;
import edu.mum.apms.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Transactional
	public void add(Project project) {
		projectDao.save(project);
	}

	@Transactional
	public void edit(Project project) {
		projectDao.save(project);
	}

	@Transactional
	public void delete(int projectId) {
		projectDao.delete(projectId);
	}

	@Transactional
	public Project get(int projectId) {
		return projectDao.findOne(projectId);
	}

	@Transactional
	public List<Project> getAll() {
		return projectDao.findAll();
	}

}