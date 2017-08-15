package edu.mum.apms.rest;

import edu.mum.apms.model.*;
import edu.mum.apms.service.ProjectService;
import edu.mum.apms.service.ReleaseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectRestController {
	
	@Autowired
	ProjectService projectService;
	
	
	@RequestMapping("/restprojects")
    public List<Project> projects() {
        return projectService.getAll();
    }
	


}
