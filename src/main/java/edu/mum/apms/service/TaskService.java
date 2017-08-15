package edu.mum.apms.service;

import java.util.List;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Task;

public interface TaskService {

	public Task getTaskById(int taskId);

	public List<Task> getAllTaskByBacklog(Backlog backlog);

	public List<Task> getAllActiveTaskByBacklog(int backlogId);

	public void addTask(Task task);

	public void updateTask(Task task);

	public void deleteTask(int taskId);
}
