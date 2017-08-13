package edu.mum.apms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.mum.apms.service.ProjectService;

@Controller
public class ProjectController {

//	@Autowired
//	private ProjectService projectService;
	
	@RequestMapping("/projects")
	public String viewProjects() {
		return "/projects";
	}
	@RequestMapping("/projects/manage")
	public String manageProjects() {
		return "/manageProjects";
	}
	@RequestMapping("/projects/new")
	public String newProject() {
		return "/newProject";
	}

}
