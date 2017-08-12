package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.WorkLog;

public interface WorklogDao extends JpaRepository<WorkLog, Integer>  {

	public  List<WorkLog> findByTask(int taskId);
//	public WorkLog get(int worklogId);
//
//	public List<WorkLog> getAll();
//	public List<WorkLog> getAllByTask(int taskId);
//
//	public void add(WorkLog worklog);
//
//	public void edit(WorkLog worklog);
//
//	public void delete(int worklogId);

}
