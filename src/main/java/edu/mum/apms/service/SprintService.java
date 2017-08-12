package edu.mum.apms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.apms.dao.SprintDao;
import edu.mum.apms.model.Sprint;

public class SprintService {
	
	@Autowired
	private SprintDao sprintDao;
	
	public List<Sprint> getSprints(String releaseVersion){
		//return sprintDao.getSprints(releaseVersion);
		return null;
	}
	
	public List<Sprint> getDueDatedSprints(Date dueDate, String releaseVersion){
		//return sprintDao.getSprintsByDueDate(dueDate, releaseVersion);
		return null;
	}

}
