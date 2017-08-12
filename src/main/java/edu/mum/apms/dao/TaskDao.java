package edu.mum.apms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.mum.apms.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {

//	public Task get(int taskId);
//
//	public List<Task> getAll();
//
//	public List<Task> getAllByBacklog(int backlogId);
//
//	public List<Task> getAllActiveByBacklog(int backlogId);
//
//	public void add(Task task);
//
//	public void edit(Task task);
//
//	public void delete(int taskId);

}
