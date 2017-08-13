package edu.mum.apms.service;

import java.util.List;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Feature;

public interface BacklogService {
	
	public Backlog getBacklogById(int backlogId);

	public List<Backlog> getAllBacklogByProject(int projectId);

	public List<Backlog> getAllActiveBacklogByProject(int projectId);

	public List<Feature> getAddableFeatures(int projectId);
	
	public void addBacklog(Backlog backlog);

	public void updateBacklog(Backlog backlog);

	public void deleteBacklog(int backlogId);
	

}
