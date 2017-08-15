package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {

	public List<Task> findByBacklog(Backlog backlog);

}
