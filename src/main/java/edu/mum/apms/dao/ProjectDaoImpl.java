package edu.mum.apms.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import edu.mum.apms.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	//@Autowired
	//LocalSessionFactoryBean
	private SessionFactory session;
	
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

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
