package edu.mum.apms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.service.BacklogService;

@RestController
public class BacklogRestController {

	@Autowired
	BacklogService backlogService;

	// Get all backlogs by Project
	@RequestMapping("/restBacklogsByProjectId/{projectId}")
	public List<Backlog> getBacklogsByProject(@PathVariable int projectId) {
		
		return backlogService.getAllBacklogByProject(projectId);
		
	}

	// Get backlog by id
	@RequestMapping("/restgetBacklog/{backlogId}")
	public Backlog getBacklog(@PathVariable int backlogId) {
		
		return backlogService.getBacklogById(backlogId);
		
	}

	// Remove backlog by id
	@RequestMapping("/restRemoveBacklogById/{backlogId}")
	public String removeacklog(@PathVariable int backlogId) {
		
		backlogService.deleteBacklog(backlogId);
		
		return "success";
	}
}
