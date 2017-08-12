package edu.mum.apms.dao;

import java.util.Date;
import java.util.List;

import edu.mum.apms.model.Sprint;

public interface SprintDao {
	
	List<Sprint> getSprints(String releaseVersion);
	
	List<Sprint> getSprintsByDueDate(Date dueDate, String releaseVersion);
	
	void addSprint(Sprint sprint);
	
	void getSprint(int sprintId);
	
	

}
