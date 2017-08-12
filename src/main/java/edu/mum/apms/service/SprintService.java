package edu.mum.apms.service;

import java.util.Date;
import java.util.List;

import edu.mum.apms.dao.SprintDao;
import edu.mum.apms.model.Sprint;

public class SprintService {
	
	private SprintDao sprintDao;
	
	public List<Sprint> getSprints(String releaseVersion){
		return sprintDao.getSprints(releaseVersion);
	}
	
	public List<Sprint> getDueDatedSprints(Date dueDate, String releaseVersion){
		return sprintDao.getSprintsByDueDate(dueDate, releaseVersion);
	}

}
