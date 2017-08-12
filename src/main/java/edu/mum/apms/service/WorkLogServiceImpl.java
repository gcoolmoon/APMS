package edu.mum.apms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.apms.dao.WorklogDao;
import edu.mum.apms.model.WorkLog;

@Service
public class WorkLogServiceImpl implements WorklogService {

	@Autowired
	private WorklogDao worklogDao;

	@Override
	@Transactional
	public WorkLog getWorklogById(int worklogId) {
		return worklogDao.findOne(worklogId);
	}

	@Override
	@Transactional
	public List<WorkLog> getAllWorklogByTask(int taskId) {
		//return worklogDao.getAllByTask(taskId);
		return null;
	}

	@Override
	@Transactional
	public void addWorklog(WorkLog worklog) {
		//worklogDao.add(worklog);
	}

	@Override
	@Transactional
	public void updateWorklog(WorkLog worklog) {
		//worklogDao.edit(worklog);
	}

	@Override
	@Transactional
	public void deleteWorklog(int worklogId) {
		worklogDao.delete(worklogId);
	}

}
