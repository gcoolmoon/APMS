package edu.mum.apms.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.Sprint;

public interface SprintDao extends JpaRepository<Sprint, Integer> {
	
	//List<Sprint> getSprints(String releaseVersion);
	
	//List<Sprint> getSprintsByDueDate(Date dueDate, String releaseVersion);
	
//	void addSprint(Sprint sprint);
	
	//void getSprint(int sprintId);
	
	

}
