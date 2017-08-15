package edu.mum.apms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.apms.dao.ReleaseDao;
import edu.mum.apms.model.Project;
import edu.mum.apms.model.Release;

public interface ReleaseService {
	
	
	public void add(Release project);
	public void edit(Release project);
	public void delete(int releaseId);
	public Release get(int releaseId);
	public List<Release> getAll();
	public List<Release> getReleasesByProject(int projectId);
	
	
	

}
