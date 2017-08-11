package edu.mum.apms.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.mum.apms.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Project project) {
		session.getCurrentSession().save(project);		
	}

	@Override
	public void edit(Project project) {
		session.getCurrentSession().update(project);
	}

	@Override
	public void delete(int projectId) {
		session.getCurrentSession().delete(get(projectId));
	}

	@Override
	public Project get(int projectId) {		
		return (Project)session.getCurrentSession().get(Project.class, projectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAll() {
		return session.getCurrentSession().createQuery("FROM Project").list();
	}
}
