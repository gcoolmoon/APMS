package edu.mum.apms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.apms.dao.TaskDao;
import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;
	
	@Override
	@Transactional
	public Task getTaskById(int taskId) {
		return taskDao.findOne(taskId);
	}

//	@Override
//	@Transactional
//	public List<Task> getAllTaskByBacklog(Backlog backlog) {		
//		return taskDao.findByBacklog(backlog);		
//	}

	@Override
	@Transactional
	public List<Task> getAllActiveTaskByBacklog(int backlogId) {
		//return taskDao.getAllActiveByBacklog(backlogId);
		return null;
	}

	@Override
	@Transactional
	public void addTask(Task task) {
		taskDao.save(task);
	}

	@Override
	@Transactional
	public void updateTask(Task task) {
		taskDao.save(task);
	}

	@Override
	@Transactional
	public void deleteTask(int taskId) {
		taskDao.delete(taskId);
	}

	@Override
	public List<Task> getAllTaskByBacklog(Backlog backlog) {
		// TODO Auto-generated method stub
		return taskDao.findByBacklog(backlog);
	}


}
