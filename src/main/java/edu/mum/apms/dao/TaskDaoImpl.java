package edu.mum.apms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.apms.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private SessionFactory session;
	
	@Override
	public Task get(int taskId) {
		return (Task) session.getCurrentSession().get(Task.class,taskId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAll() {
		return session.getCurrentSession().createQuery("FROM Task").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAllByBacklog(int backlogId) {
		return session.getCurrentSession().createQuery("FROM Task WHERE Task.backlogId = " + backlogId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAllActiveByBacklog(int backlogId) {
		return session.getCurrentSession().createQuery("FROM Task WHERE Task.backlogId = " + backlogId + " AND Task.status <> 'COMPLETED'").list();
	}

	@Override
	public void add(Task task) {
		session.getCurrentSession().save(task);		
	}

	@Override
	public void edit(Task task) {
		session.getCurrentSession().save(task);		
	}

	@Override
	public void delete(int taskId) {
		session.getCurrentSession().delete(get(taskId));			
	}

}
