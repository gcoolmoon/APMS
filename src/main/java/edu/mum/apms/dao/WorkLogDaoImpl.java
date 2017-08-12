package edu.mum.apms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.apms.model.WorkLog;

@Repository
public class WorkLogDaoImpl implements WorklogDao{

	@Autowired
	private SessionFactory session;
	
	@Override
	public WorkLog get(int worklogId) {
		return (WorkLog) session.getCurrentSession().get(WorkLog.class,worklogId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkLog> getAll() {
		return session.getCurrentSession().createQuery("FROM WorkLog").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkLog> getAllByTask(int taskId) {
		return session.getCurrentSession().createQuery("FROM WorkLog WHERE WorkLog.taskId = " + taskId).list();
	}

	@Override
	public void add(WorkLog worklog) {
		session.getCurrentSession().save(worklog);				
	}

	@Override
	public void edit(WorkLog worklog) {
		session.getCurrentSession().save(worklog);		
	}

	@Override
	public void delete(int worklogId) {
		session.getCurrentSession().delete(get(worklogId));	
	}

}
