package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.Task;
import edu.mum.apms.model.WorkLog;

public interface WorklogDao extends JpaRepository<WorkLog, Integer> {

	public List<WorkLog> findByTask(Task task);

}
