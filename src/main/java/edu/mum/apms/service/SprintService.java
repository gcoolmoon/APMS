package edu.mum.apms.service;

import java.util.List;


import edu.mum.apms.model.Sprint;

public interface SprintService {
	
	public void add(Sprint sprint);
	public void edit(Sprint sprint);
	public void delete(int sprintId);
	public Sprint get(int sprintId);
	public List<Sprint> getAll();

}
