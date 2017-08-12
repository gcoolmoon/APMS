package edu.mum.apms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.mum.apms.model.Backlog;

public interface BacklogDao extends JpaRepository<Backlog, Integer> {
//	public Backlog get(int backlogId);
//
//	public List<Backlog> getAll();
//
//	public List<Backlog> getAllByProject(int projectId);
//
//	public List<Backlog> getAllActiveByProject(int projectId);
//
//	public void add(Backlog backlog);
//
//	public void edit(Backlog backlog);
//
//	public void delete(int backlogId);
}
