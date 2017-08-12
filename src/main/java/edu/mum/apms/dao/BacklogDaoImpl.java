package edu.mum.apms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.apms.model.Backlog;

@Repository
public class BacklogDaoImpl implements BacklogDao{

	@Autowired
	private SessionFactory session;

	@Override
	public Backlog get(int backlogId) {		
		return (Backlog) session.getCurrentSession().get(Backlog.class,backlogId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Backlog> getAll() {
		return session.getCurrentSession().createQuery("FROM Backlog").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Backlog> getAllByProject(int projectId) {		
		return session.getCurrentSession().createQuery("FROM Backlog WHERE Backlog.projectId = " + projectId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Backlog> getAllActiveByProject(int projectId) {		
		return session.getCurrentSession().createQuery("FROM Backlog WHERE Backlog.projectId = " + projectId + " AND Backlog.status <> 'COMPLETED'").list();
	}

	@Override
	public void add(Backlog backlog) {		
		session.getCurrentSession().save(backlog);		
	}

	@Override
	public void edit(Backlog backlog) {
		session.getCurrentSession().save(backlog);				
	}

	@Override
	public void delete(int backlogId) {
		session.getCurrentSession().delete(get(backlogId));		
	}

}
