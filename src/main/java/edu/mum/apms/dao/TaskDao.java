package edu.mum.apms.dao;

import java.util.List;

import edu.mum.apms.model.Task;

public interface TaskDao {

	public Task get(int taskId);

	public List<Task> getAll();

	public List<Task> getAllByBacklog(int backlogId);

	public List<Task> getAllActiveByBacklog(int backlogId);

	public void add(Task task);

	public void edit(Task task);

	public void delete(int taskId);

}
