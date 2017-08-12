package edu.mum.apms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.mum.apms.model.WorkLog;

public interface WorklogDao extends JpaRepository<WorkLog, Integer>  {

//	public WorkLog get(int worklogId);
//
//	public List<WorkLog> getAll();
//
//	public List<WorkLog> getAllByTask(int taskId);
//
//	public void add(WorkLog worklog);
//
//	public void edit(WorkLog worklog);
//
//	public void delete(int worklogId);

}
